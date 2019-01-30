package trinsdar.gravisuit.items.armor;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import ic2.core.IC2;
import ic2.core.item.armor.electric.ItemArmorElectricJetpack;
import ic2.core.item.render.model.JetpackModel;
import ic2.core.platform.textures.Ic2Icons;
import ic2.core.platform.textures.models.BaseModel;
import ic2.core.util.helpers.ItemWithMeta;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trinsdar.gravisuit.GravisuitClassic;

@Optional.Interface(iface = "baubles.api.IBauble", modid = "baubles", striprefs = true)
public class ItemArmorAdvancedElectricJetpack extends ItemArmorElectricJetpack implements IBauble {

    public ItemArmorAdvancedElectricJetpack(){
        super();
        this.setRegistryName("advanced_electric_jetpack");
        this.setUnlocalizedName(GravisuitClassic.MODID +".advancedElectricJetpack");
        this.setCreativeTab(IC2.tabIC2);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BaseModel getModelFromItem(ItemStack item) {
        ItemStack stack = getArmor(item);
        return new JetpackModel(Ic2Icons.getTextures("gravisuit_items")[14]);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(int i) {
        return Ic2Icons.getTextures("gravisuit_items")[14];
    }

    @Override
    public double getMaxCharge(ItemStack stack) {
        return 100000.0D;
    }

    @Override
    public int getTier(ItemStack stack) {
        return 2;
    }

    @Override
    public boolean canProvideEnergy(ItemStack stack) {
        return true;
    }

    @Override
    public double getTransferLimit(ItemStack stack) {
        return 120.0D;
    }

    @Override
    public int getMaxHeight(ItemStack stack, int worldHeight) {
        return (int)((float)worldHeight / 1.024F);
    }

    @Override
    public String getTexture() {
        return "gravisuit:textures/models/advanced_electric_jetpack";
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
        super.onArmorTick(world, player, stack);
    }

    @Override
    @Optional.Method(modid = "baubles")
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.BODY;
    }

    @Override
    @Optional.Method(modid = "baubles")
    public void onWornTick(ItemStack itemstack, EntityLivingBase entity) {
        if (entity instanceof EntityPlayer) {
            this.onArmorTick(entity.getEntityWorld(), (EntityPlayer)entity, itemstack);
        }

    }


    @Override
    @Optional.Method(modid = "baubles")
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    @Optional.Method(modid = "baubles")
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    @Optional.Method(modid = "baubles")
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return getArmor(itemstack).isEmpty();
    }

    @Override
    @Optional.Method(modid = "baubles")
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    @Optional.Method(modid = "baubles")
    public boolean willAutoSync(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }
}
