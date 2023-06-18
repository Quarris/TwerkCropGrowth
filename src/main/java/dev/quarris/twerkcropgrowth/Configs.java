package dev.quarris.twerkcropgrowth;

import net.minecraftforge.common.ForgeConfigSpec;

public class Configs {

    // General Configs
    public static ForgeConfigSpec.IntValue randomTickTries;
    public static ForgeConfigSpec.DoubleValue randomTickChance;

    // Twerk Configs
    public static ForgeConfigSpec.IntValue twerkRadius;
    public static ForgeConfigSpec.IntValue twerkHeight;
    public static ForgeConfigSpec.IntValue twerkMaxBlocks;
    public static ForgeConfigSpec.DoubleValue twerkChance;

    // Sprint Configs
    public static ForgeConfigSpec.IntValue sprintRadius;
    public static ForgeConfigSpec.IntValue sprintHeight;
    public static ForgeConfigSpec.IntValue sprintMaxBlocks;
    public static ForgeConfigSpec.DoubleValue sprintChance;

    public static void register(ForgeConfigSpec.Builder builder) {
        // General Configs
        builder.comment("General Configs").push("general");
        randomTickTries = builder.comment(
            "Amount of tries that the random tick will affect a block.",
            "Example, when set to 15: Each time growth is applied on a random tick block, it will trigger 15 growth ticks.",
            "Random ticks, in general, progress slower than applying bonemeal affects;",
            "This config is there to buff random tick growth."
        ).defineInRange("random_tick_tries", 30, 1, 100);
        randomTickChance = builder.comment(
            "Chance that each random tick tries actually triggers.",
            "Example, when set to 0.7 (70%): Each time a random tick try is to be applied, it will actually take effect 70% of the time.",
            "Random ticks, in general, progress slower than applying bonemeal affects;",
            "This config is there to buff random tick growth."
        ).defineInRange("random_tick_tries", 0.6, 0, 1);
        builder.pop();

        // Twerk Configs
        builder.push("twerk").comment("Configs for Twerking (Crouching)");
        twerkRadius = builder.comment(
            "The square radius around the player to check.",
            "A radius of 5 would cause an area of 11x11."
        ).defineInRange("radius", 3, 0, 30);
        twerkHeight = builder.comment(
            "The height above and below the player to check."
        ).defineInRange("height", 1, 0, 15);
        twerkMaxBlocks = builder.comment(
            "Maximum number of blocks that are able to be targeted every check."
        ).defineInRange("max_blocks", 5, 1, Integer.MAX_VALUE);
        twerkChance = builder.comment(
            "The probability of performing a check every time you twerk (crouch)."
        ).defineInRange("chance", 0.4, 0, 1);
        builder.pop();

        // Sprint Configs
        builder.push("sprint").comment("Configs for Sprinting");
        sprintRadius = builder.comment(
            "The square radius around the player to check.",
            "A radius of 5 would cause an area of 11x11."
        ).defineInRange("radius", 3, 0, 30);
        sprintHeight = builder.comment(
            "The height above and below the player to check."
        ).defineInRange("height", 1, 0, 15);
        sprintMaxBlocks = builder.comment(
            "Maximum number of blocks that are able to be targeted every check."
        ).defineInRange("max_blocks", 5, 1, Integer.MAX_VALUE);
        sprintChance = builder.comment(
            "The probability of performing a check every tick while you are sprinting."
        ).defineInRange("chance", 0.05, 0, 1);
        builder.pop();
    }
}
