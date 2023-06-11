package dev.quarris.twerkcropgrowth;

import net.minecraftforge.common.ForgeConfigSpec;

public class Configs {

    public static ForgeConfigSpec.IntValue radius;
    public static ForgeConfigSpec.IntValue height;
    public static ForgeConfigSpec.IntValue maxBlocks;
    public static ForgeConfigSpec.DoubleValue chance;

    public static void register(ForgeConfigSpec.Builder builder) {
        radius = builder.comment(
            "The square radius around the player to apply growth affect to.",
            "A radius of 5 would cause an area of 11x11."
        ).defineInRange("radius", 3, 0, 30);
        height = builder.comment(
            "The height above and below the player to apply the affect to."
        ).defineInRange("height", 1, 0, 15);
        maxBlocks = builder.comment(
            "Maximum number of blocks that are able to be targeted every time you twerk."
        ).defineInRange("max_blocks", 5, 1, Integer.MAX_VALUE);
        chance = builder.comment(
            "The probability of the bonemeal effect applying to the target block."
        ).defineInRange("chance", 0.4, 0, 1);
    }
}
