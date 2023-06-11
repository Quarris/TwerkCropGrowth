package dev.quarris.twerkcropgrowth;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModRef {

    public static final String ID = "twerkcropgrowth";
    public static final String NAME = "TwerkCropGrowth";

    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static ResourceLocation res(String name) {
        return new ResourceLocation(ID, name);
    }
}
