package trinsdar.gravisuit.util;

import ic2.bobIntigration.SubModul;
import ic2.core.IC2;
import net.minecraftforge.fml.common.Loader;
import trinsdar.gravisuit.items.ItemComponents;
import trinsdar.gravisuit.items.armor.ItemArmorAdvancedElectricJetpack;
import trinsdar.gravisuit.items.armor.ItemArmorAdvancedLappack;
import trinsdar.gravisuit.items.armor.ItemArmorAdvancedNanoChestplate;
import trinsdar.gravisuit.items.armor.ItemArmorGravisuit;
import trinsdar.gravisuit.items.tools.ItemRelocator;
import trinsdar.gravisuit.items.tools.ItemToolAdvancedChainsaw;
import trinsdar.gravisuit.items.tools.ItemToolAdvancedDiamondDrill;
import trinsdar.gravisuit.items.tools.ItemToolGravitool;
import trinsdar.gravisuit.items.tools.ItemToolVajra;
import trinsdar.gravisuit.util.baubles.BItemArmorAdvancedElectricJetpack;

public class Registry {
    public static final ItemArmorAdvancedElectricJetpack advancedElectricJetpack = new ItemArmorAdvancedElectricJetpack();
    public static final ItemArmorAdvancedNanoChestplate advancedNanoChestplate = new ItemArmorAdvancedNanoChestplate();
    public static final ItemArmorGravisuit gravisuit = new ItemArmorGravisuit();
    public static final ItemArmorAdvancedLappack advancedLappack = new ItemArmorAdvancedLappack("advancedLappack", 2, Config.advancedLappackStorage, 16, Config.advancedLappackTransfer);
    public static final ItemArmorAdvancedLappack ultimateLappack = new ItemArmorAdvancedLappack("ultimateLappack", 3, Config.ultimateLappackStorage, 19, Config.ultimateLappackTransfer);
    public static final ItemToolGravitool gravitool = new ItemToolGravitool();
    public static final ItemToolAdvancedDiamondDrill advancedDiamondDrill = new ItemToolAdvancedDiamondDrill();
    public static final ItemToolAdvancedChainsaw advancedChainsaw = new ItemToolAdvancedChainsaw();
    public static final ItemToolVajra vajra = new ItemToolVajra();
    public static final ItemRelocator relocator = new ItemRelocator();
    public static final ItemComponents
    superConductorCover = new ItemComponents("superConductorCover", 0),
    superConductor = new ItemComponents("superConductor", 1),
    coolingCore = new ItemComponents("coolingCore", 2),
    gravitationEngine = new ItemComponents("gravitationEngine", 3),
    magnetron = new ItemComponents("magnetron", 4),
    vajraCore = new ItemComponents("vajraCore", 5),
    engineBoost = new ItemComponents("engineBoost", 6);


    private static ItemArmorAdvancedElectricJetpack jetpack(){
        if (Loader.isModLoaded("baubles")){
            return new BItemArmorAdvancedElectricJetpack();
        }
        return new ItemArmorAdvancedElectricJetpack();
    }

    public static void init(){
        if (Config.enableAdvancedElectricJetpack){
            IC2.getInstance().createItem(advancedElectricJetpack);
        }
        if (Config.enableAdvancedNanoChestplate){
            IC2.getInstance().createItem(advancedNanoChestplate);
        }
        if (Config.enableGravisuit){
            IC2.getInstance().createItem(gravisuit);
        }
        if (Config.enableAdvancedLappack){
            IC2.getInstance().createItem(advancedLappack);
        }
        if (Config.enableUltimateLappack){
            IC2.getInstance().createItem(ultimateLappack);
        }
        if (Config.enableGravitool){
            IC2.getInstance().createItem(gravitool);
        }
        if (Config.enableAdvancedDrill){
            IC2.getInstance().createItem(advancedDiamondDrill);
        }
        if (Config.enableAdvancedChainsaw){
            IC2.getInstance().createItem(advancedChainsaw);
        }
        if (Config.enableVajra){
            IC2.getInstance().createItem(vajra);
        }
        if (Config.enableMiscCraftingItems){
            IC2.getInstance().createItem(superConductorCover);
            IC2.getInstance().createItem(superConductor);
            IC2.getInstance().createItem(coolingCore);
            IC2.getInstance().createItem(gravitationEngine);
            IC2.getInstance().createItem(magnetron);
            IC2.getInstance().createItem(vajraCore);
            IC2.getInstance().createItem(engineBoost);
        }
        IC2.getInstance().createItem(relocator);
    }
}
