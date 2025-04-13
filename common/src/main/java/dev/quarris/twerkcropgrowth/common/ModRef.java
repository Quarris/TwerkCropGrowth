package dev.quarris.twerkcropgrowth.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModRef {

    public static final String ID = "twerkcropgrowth";
    public static final String NAME = "TwerkCropGrowth";

    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static ResourceLocation res(String name) {
        return ResourceLocation.fromNamespaceAndPath(ID, name);
    }

    public static TagKey<Block> TWERK_GROWTH = TagKey.create(Registries.BLOCK, res("twerk_growth"));
    public static TagKey<Block> SPRINT_GROWTH = TagKey.create(Registries.BLOCK, res("sprint_growth"));
}
