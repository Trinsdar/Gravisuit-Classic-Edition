
package trinsdar.gravisuit.network;

import ic2.core.util.misc.StackUtil;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import trinsdar.gravisuit.items.tools.ItemRelocator;
import trinsdar.gravisuit.items.tools.ItemRelocator.TeleportData;

public class PacketRelocator implements IMessage {
    public static final int ADDDESTINATION = 0;
    public static final int REMOVEDESTINATION = 1;
    public static final int ADDDEFAULT= 2;
    public static final int TELEPORT = 3;

    private boolean dataB;
    private byte function = -1;
    private TeleportData location;
    private ItemStack relocator;

    public PacketRelocator() {
    }

//    public PacketRelocator(int function, int data, boolean b) {
//        this.data = data;
//        this.function = (byte) function;
//        this.dataB = b;
//    }

    public PacketRelocator(TeleportData location, int function, ItemStack relocator) {
        this.location = location;
        this.function = (byte) function;
        this.relocator = relocator;
    }

    public ItemStack getRelocator() {
        return relocator;
    }

    @Override
    public void toBytes(ByteBuf bytes) {
        bytes.writeByte(function);
        if (function == ADDDESTINATION) {
            bytes.writeDouble(location.getX());
            bytes.writeDouble(location.getY());
            bytes.writeDouble(location.getZ());
            bytes.writeInt(location.getDimId());
            ByteBufUtils.writeUTF8String(bytes, location.getName());
        }

        if (function == REMOVEDESTINATION || function == TELEPORT || function == ADDDEFAULT) {
            ByteBufUtils.writeUTF8String(bytes, location.getName());
        }
        ByteBufUtils.writeItemStack(bytes, relocator);
    }

    @Override
    public void fromBytes(ByteBuf bytes) {
        function = bytes.readByte();
        if (function == ADDDESTINATION) {
            location = new TeleportData(bytes.readInt(), bytes.readInt(), bytes.readInt(), bytes.readInt(), ByteBufUtils.readUTF8String(bytes));
        }

        if (function == REMOVEDESTINATION || function == TELEPORT || function == ADDDEFAULT) {
            location = new TeleportData(ByteBufUtils.readUTF8String(bytes));
        }
        relocator = ByteBufUtils.readItemStack(bytes);
    }

    public static class Handler extends MessageHandlerWrapper<PacketRelocator, IMessage> {

        @Override
        public IMessage handleMessage(PacketRelocator message, MessageContext ctx) {
            ItemStack teleporter = message.getRelocator();
            if (teleporter.isEmpty()) {
                return null;
            }

            EntityPlayerMP serverPlayer = ctx.getServerHandler().player;

            serverPlayer.getServerWorld().addScheduledTask(() -> {
                NBTTagCompound nbt = StackUtil.getNbtData(teleporter);
                NBTTagCompound map = nbt.getCompoundTag("Locations");

                if (message.function == ADDDESTINATION) {
                    NBTTagCompound tag = new NBTTagCompound();

                    message.location.writeToNBT(tag);
                    map.setTag(message.location.getName(), tag);
                    nbt.setTag("Locations", map);
                    teleporter.setTagCompound(nbt);
                }

                if (message.function == REMOVEDESTINATION) {
                    map.removeTag(message.location.getName());
                    nbt.setTag("Locations", map);
                    teleporter.setTagCompound(nbt);
                }

                if (message.function == TELEPORT) {
                    NBTTagCompound teleportData;
                    if (map.hasKey(message.location.getName())){
                        teleportData = map.getCompoundTag(message.location.getName());
                        ItemRelocator.teleportEntity(ctx.getServerHandler().player, (int)teleportData.getDouble("X"), (int)teleportData.getDouble("Y"), (int)teleportData.getDouble("Z"), teleportData.getInteger("Dimension"), teleporter);
                    }
                }

                if (message.function == ADDDEFAULT){
                    nbt.setString("DefaultLocation", message.location.getName());
                }
            });


            return null;
        }
    }
}
