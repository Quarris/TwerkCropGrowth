package dev.quarris.twerkcropgrowth.common;

/**
 * Common configuration class that stores all the configuration values.
 * This class is used by all platform implementations.
 */
public class Configs {
    // General Configs
    public static int randomTickTries = 30;
    public static double randomTickChance = 0.6;

    // Twerk Configs
    public static int twerkRadius = 3;
    public static int twerkHeight = 1;
    public static int twerkMaxBlocks = 5;
    public static double twerkChance = 0.4;

    // Sprint Configs
    public static int sprintRadius = 3;
    public static int sprintHeight = 1;
    public static int sprintMaxBlocks = 5;
    public static double sprintChance = 0.05;
}