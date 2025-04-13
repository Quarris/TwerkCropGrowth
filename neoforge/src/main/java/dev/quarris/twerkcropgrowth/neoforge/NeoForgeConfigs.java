package dev.quarris.twerkcropgrowth.neoforge;

import dev.quarris.twerkcropgrowth.common.Configs;
import dev.quarris.twerkcropgrowth.common.ModRef;
import dev.quarris.twerkcropgrowth.common.platform.Services;
import dev.quarris.twerkcropgrowth.neoforge.platform.NeoForgePlatformHelper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class NeoForgeConfigs {
    private static ModConfigSpec.IntValue randomTickTries;
    private static ModConfigSpec.DoubleValue randomTickChance;

    private static ModConfigSpec.IntValue twerkRadius;
    private static ModConfigSpec.IntValue twerkHeight;
    private static ModConfigSpec.IntValue twerkMaxBlocks;
    private static ModConfigSpec.DoubleValue twerkChance;

    private static ModConfigSpec.IntValue sprintRadius;
    private static ModConfigSpec.IntValue sprintHeight;
    private static ModConfigSpec.IntValue sprintMaxBlocks;
    private static ModConfigSpec.DoubleValue sprintChance;

    public static void register(ModContainer container) {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        setupConfig(builder);
        ModConfigSpec spec = builder.build();
        container.registerConfig(ModConfig.Type.COMMON, spec);
    }

    private static void setupConfig(ModConfigSpec.Builder builder) {
        // General Configs
        builder.comment("General Configs").push("general");
        randomTickTries = builder.comment(
            "Amount of tries that the random tick will affect a block.",
            "Example, when set to 15: Each time growth is applied on a random tick block, it will trigger 15 growth ticks.",
            "Random ticks, in general, progress slower than applying bonemeal affects;",
            "This config is there to buff random tick growth."
        ).defineInRange("random_tick_tries", Configs.randomTickTries, 1, 100);
        randomTickChance = builder.comment(
            "Chance that each random tick tries actually triggers.",
            "Example, when set to 0.7 (70%): Each time a random tick try is to be applied, it will actually take effect 70% of the time.",
            "Random ticks, in general, progress slower than applying bonemeal affects;",
            "This config is there to buff random tick growth."
        ).defineInRange("random_tick_chance", Configs.randomTickChance, 0, 1);
        builder.pop();

        // Twerk Configs
        builder.push("twerk").comment("Configs for Twerking (Crouching)");
        twerkRadius = builder.comment(
            "The square radius around the player to check.",
            "A radius of 5 would cause an area of 11x11."
        ).defineInRange("radius", Configs.twerkRadius, 0, 30);
        twerkHeight = builder.comment(
            "The height above and below the player to check."
        ).defineInRange("height", Configs.twerkHeight, 0, 15);
        twerkMaxBlocks = builder.comment(
            "Maximum number of blocks that are able to be targeted every check."
        ).defineInRange("max_blocks", Configs.twerkMaxBlocks, 1, Integer.MAX_VALUE);
        twerkChance = builder.comment(
            "The probability of performing a check every time you twerk (crouch)."
        ).defineInRange("chance", Configs.twerkChance, 0, 1);
        builder.pop();

        // Sprint Configs
        builder.push("sprint").comment("Configs for Sprinting");
        sprintRadius = builder.comment(
            "The square radius around the player to check.",
            "A radius of 5 would cause an area of 11x11."
        ).defineInRange("radius", Configs.sprintRadius, 0, 30);
        sprintHeight = builder.comment(
            "The height above and below the player to check."
        ).defineInRange("height", Configs.sprintHeight, 0, 15);
        sprintMaxBlocks = builder.comment(
            "Maximum number of blocks that are able to be targeted every check."
        ).defineInRange("max_blocks", Configs.sprintMaxBlocks, 1, Integer.MAX_VALUE);
        sprintChance = builder.comment(
            "The probability of performing a check every tick while you are sprinting."
        ).defineInRange("chance", Configs.sprintChance, 0, 1);
        builder.pop();
    }

    public static void loadConfig() {
        Configs.randomTickTries = randomTickTries.get();
        Configs.randomTickChance = randomTickChance.get();

        Configs.twerkRadius = twerkRadius.get();
        Configs.twerkHeight = twerkHeight.get();
        Configs.twerkMaxBlocks = twerkMaxBlocks.get();
        Configs.twerkChance = twerkChance.get();

        Configs.sprintRadius = sprintRadius.get();
        Configs.sprintHeight = sprintHeight.get();
        Configs.sprintMaxBlocks = sprintMaxBlocks.get();
        Configs.sprintChance = sprintChance.get();
    }

    @EventBusSubscriber(modid = ModRef.ID, bus = EventBusSubscriber.Bus.MOD)
    public static class ConfigEvents {
        @SubscribeEvent
        public static void onConfigLoad(ModConfigEvent.Loading event) {
            ModConfig config = event.getConfig();
            if (ModRef.ID.equals(config.getModId())) {
                loadConfig();
            }
        }

        @SubscribeEvent
        public static void onConfigReload(ModConfigEvent.Reloading event) {
            ModConfig config = event.getConfig();
            if (ModRef.ID.equals(config.getModId())) {
                loadConfig();
            }
        }
    }
}