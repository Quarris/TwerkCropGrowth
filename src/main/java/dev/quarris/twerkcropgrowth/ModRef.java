package dev.quarris.twerkcropgrowth;

import net.minecraft.resources.ResourceLocation;

public class ModRef {

    public static final String ID = "twerkcropgrowth";

    public static ResourceLocation res(String name) {
        return new ResourceLocation(ID, name);
    }
}
