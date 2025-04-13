package dev.quarris.twerkcropgrowth.fabric;

import dev.quarris.twerkcropgrowth.common.Configs;
import dev.quarris.twerkcropgrowth.common.ModRef;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.minecraft.world.InteractionResult;

@Config(name = ModRef.ID)
public class FabricConfigs implements ConfigData {

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("general")
    public GeneralConfig general = new GeneralConfig();

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("twerk")
    public TwerkConfig twerk = new TwerkConfig();

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Category("sprint")
    public SprintConfig sprint = new SprintConfig();

    public static class GeneralConfig {
        @Comment("Amount of tries that the random tick will affect a block.\n" +
            "Example, when set to 15: Each time growth is applied on a random tick block, it will trigger 15 growth ticks.\n" +
            "Random ticks, in general, progress slower than applying bonemeal affects;\n" +
            "This config is there to buff random tick growth.")
        @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
        public int randomTickTries = 30;

        @Comment("Chance that each random tick tries actually triggers.\n" +
            "Example, when set to 0.7 (70%): Each time a random tick try is to be applied, it will actually take effect 70% of the time.\n" +
            "Random ticks, in general, progress slower than applying bonemeal affects;\n" +
            "This config is there to buff random tick growth.")
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        public double randomTickChance = 0.6;
    }

    public static class TwerkConfig {
        @Comment("The square radius around the player to check.\n" +
            "A radius of 5 would cause an area of 11x11.")
        @ConfigEntry.BoundedDiscrete(min = 0, max = 30)
        public int radius = 3;

        @Comment("The height above and below the player to check.")
        @ConfigEntry.BoundedDiscrete(min = 0, max = 15)
        public int height = 1;

        @Comment("Maximum number of blocks that are able to be targeted every check.")
        @ConfigEntry.BoundedDiscrete(min = 1, max = Integer.MAX_VALUE)
        public int maxBlocks = 5;

        @Comment("The probability of performing a check every time you twerk (crouch).")
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        public double chance = 0.4;
    }

    public static class SprintConfig {
        @Comment("The square radius around the player to check.\n" +
            "A radius of 5 would cause an area of 11x11.")
        @ConfigEntry.BoundedDiscrete(min = 0, max = 30)
        public int radius = 3;

        @Comment("The height above and below the player to check.")
        @ConfigEntry.BoundedDiscrete(min = 0, max = 15)
        public int height = 1;

        @Comment("Maximum number of blocks that are able to be targeted every check.")
        @ConfigEntry.BoundedDiscrete(min = 1, max = Integer.MAX_VALUE)
        public int maxBlocks = 5;

        @Comment("The probability of performing a check every tick while you are sprinting.")
        @ConfigEntry.BoundedDiscrete(min = 0, max = 100)
        public double chance = 0.05;
    }

    private static FabricConfigs instance;

    public static void register() {
        // Register the config
        AutoConfig.register(FabricConfigs.class, JanksonConfigSerializer::new);
        instance = AutoConfig.getConfigHolder(FabricConfigs.class).getConfig();

        // Load the values into the common config
        loadConfig();

        // Register a change listener to update common config when changed
        AutoConfig.getConfigHolder(FabricConfigs.class).registerSaveListener((manager, data) -> {
            loadConfig();
            return InteractionResult.SUCCESS;
        });
    }

    public static void loadConfig() {
        if (instance == null) {
            instance = AutoConfig.getConfigHolder(FabricConfigs.class).getConfig();
        }

        // General configs
        Configs.randomTickTries = instance.general.randomTickTries;
        Configs.randomTickChance = instance.general.randomTickChance;

        // Twerk configs
        Configs.twerkRadius = instance.twerk.radius;
        Configs.twerkHeight = instance.twerk.height;
        Configs.twerkMaxBlocks = instance.twerk.maxBlocks;
        Configs.twerkChance = instance.twerk.chance;

        // Sprint configs
        Configs.sprintRadius = instance.sprint.radius;
        Configs.sprintHeight = instance.sprint.height;
        Configs.sprintMaxBlocks = instance.sprint.maxBlocks;
        Configs.sprintChance = instance.sprint.chance;
    }
}