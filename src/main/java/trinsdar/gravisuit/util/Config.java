package trinsdar.gravisuit.util;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;
import trinsdar.gravisuit.GravisuitClassic;
import trinsdar.gravisuit.proxy.CommonProxy;

public class Config {
    private static final String CATEGORY_POWER_VALUES = "power values";
    private static final String CATEGORY_ENABLED_ITEMS = "enabled items";

    public static int
    advancedElectricJetpackStorage = 500000,
    advancedLappackStorage = 600000,
    ultimateLappackStorage = 10000000,
    advancedNanoChestplateStorage = 600000,
    gravisuitStorage = 10000000,
    advancedChainsawStorage = 100000,
    advancedDrillStorage = 100000,
    gravitoolStorage = 50000,
    vajraStorage = 3000000;

    public static int
    advancedElectricJetpackTransfer = 500,
    advancedLappackTransfer = 500,
    ultimateLappackTransfer = 4000,
    advancedNanoChestplateTransfer = 500,
    gravisuitTransfer = 5000,
    advancedChainsawTransfer = 200,
    advancedDrillTransfer = 200,
    gravitoolTransfer = 400,
    vajraTransfer = 1000;

    public static boolean
    enableAdvancedElectricJetpack = true,
    enableAdvancedLappack = true,
    enableUltimateLappack = true,
    enableAdvancedNanoChestplate = true,
    enableGravisuit = true,
    enableAdvancedChainsaw = true,
    enableAdvancedDrill = true,
    enableGravitool = true,
    enableVajra = true,
    enableMiscCraftingItems = true;

    public static void readConfig() {
        Configuration cfg = CommonProxy.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
        } catch (Exception e1) {
            GravisuitClassic.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_POWER_VALUES, "Set the max EU storage and max EU transfer of each item here.");
        advancedElectricJetpackStorage = cfg.getInt("advancedElectricJetpackStorage", CATEGORY_POWER_VALUES, advancedElectricJetpackStorage, 1, Integer.MAX_VALUE, "");
        advancedLappackStorage = cfg.getInt("advancedLappackStorage", CATEGORY_POWER_VALUES, advancedLappackStorage, 1, Integer.MAX_VALUE, "");
        ultimateLappackStorage = cfg.getInt("ultimateLappackStorage", CATEGORY_POWER_VALUES, ultimateLappackStorage, 1, Integer.MAX_VALUE, "");
        advancedNanoChestplateStorage = cfg.getInt("advancedNanoChestplateStorage", CATEGORY_POWER_VALUES, advancedNanoChestplateStorage, 1, Integer.MAX_VALUE, "");
        gravisuitStorage = cfg.getInt("gravisuitStorage", CATEGORY_POWER_VALUES, gravisuitStorage, 1, Integer.MAX_VALUE, "");
        advancedChainsawStorage = cfg.getInt("advancedChainsawStorage", CATEGORY_POWER_VALUES, advancedChainsawStorage, 1, Integer.MAX_VALUE, "");
        advancedDrillStorage = cfg.getInt("advancedDrillStorage", CATEGORY_POWER_VALUES, advancedDrillStorage, 1, Integer.MAX_VALUE, "");
        gravitoolStorage = cfg.getInt("gravitoolStorage", CATEGORY_POWER_VALUES, gravitoolStorage, 1, Integer.MAX_VALUE, "");
        vajraStorage = cfg.getInt("vajraStorage", CATEGORY_POWER_VALUES, vajraStorage, 1, Integer.MAX_VALUE, "");

        advancedElectricJetpackTransfer = cfg.getInt("advancedElectricJetpackTransfer", CATEGORY_POWER_VALUES, advancedElectricJetpackTransfer, 1, Integer.MAX_VALUE, "");
        advancedLappackTransfer = cfg.getInt("advancedLappackTransfer", CATEGORY_POWER_VALUES, advancedLappackTransfer, 1, Integer.MAX_VALUE, "");
        ultimateLappackTransfer = cfg.getInt("ultimateLappackTransfer", CATEGORY_POWER_VALUES, ultimateLappackTransfer, 1, Integer.MAX_VALUE, "");
        advancedNanoChestplateTransfer = cfg.getInt("advancedNanoChestplateTransfer", CATEGORY_POWER_VALUES, advancedNanoChestplateTransfer, 1, Integer.MAX_VALUE, "");
        gravisuitTransfer = cfg.getInt("gravisuitTransfer", CATEGORY_POWER_VALUES, gravisuitTransfer, 1, Integer.MAX_VALUE, "");
        advancedChainsawTransfer = cfg.getInt("advancedChainsawTransfer", CATEGORY_POWER_VALUES, advancedChainsawTransfer, 1, Integer.MAX_VALUE, "");
        advancedDrillTransfer = cfg.getInt("advancedDrillTransfer", CATEGORY_POWER_VALUES, advancedDrillTransfer, 1, Integer.MAX_VALUE, "");
        gravitoolTransfer = cfg.getInt("gravitoolTransfer", CATEGORY_POWER_VALUES, gravitoolTransfer, 1, Integer.MAX_VALUE, "");
        vajraTransfer = cfg.getInt("vajraTransfer", CATEGORY_POWER_VALUES, vajraTransfer, 1, Integer.MAX_VALUE, "");

        cfg.addCustomCategoryComment(CATEGORY_ENABLED_ITEMS, "Enable or Disable each item here.");

        enableAdvancedElectricJetpack = cfg.getBoolean("enableAdvancedElectricJetpack", CATEGORY_ENABLED_ITEMS, enableAdvancedElectricJetpack, "");
        enableAdvancedLappack = cfg.getBoolean("enableAdvancedLappack", CATEGORY_ENABLED_ITEMS, enableAdvancedLappack, "");
        enableUltimateLappack = cfg.getBoolean("enableUltimateLappack", CATEGORY_ENABLED_ITEMS, enableUltimateLappack, "");
        enableAdvancedNanoChestplate = cfg.getBoolean("enableAdvancedNanoChestplate", CATEGORY_ENABLED_ITEMS, enableAdvancedNanoChestplate, "");
        enableGravisuit = cfg.getBoolean("enableGravisuit", CATEGORY_ENABLED_ITEMS, enableGravisuit, "");
        enableAdvancedChainsaw = cfg.getBoolean("enableAdvancedChainsaw", CATEGORY_ENABLED_ITEMS, enableAdvancedChainsaw, "");
        enableAdvancedDrill = cfg.getBoolean("enableAdvancedDrill", CATEGORY_ENABLED_ITEMS, enableAdvancedDrill, "");
        enableGravitool = cfg.getBoolean("enableGravitool", CATEGORY_ENABLED_ITEMS, enableGravitool, "");
        enableVajra = cfg.getBoolean("enableVajra", CATEGORY_ENABLED_ITEMS, enableVajra, "");
        enableMiscCraftingItems = cfg.getBoolean("enableMiscCraftingItems", CATEGORY_ENABLED_ITEMS, enableMiscCraftingItems, "");
    }
}
