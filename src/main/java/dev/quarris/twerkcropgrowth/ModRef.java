package dev.quarris.twerkcropgrowth;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModRef {

    public static final String ID = "twerkcropgrowth";
    public static final String NAME = "TwerkCropGrowth";

    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);

    public static ResourceLocation res(String name) {
        return new ResourceLocation(ID, name);
    }

    public static TagKey<Block> TWERK_GROWTH = BlockTags.create(res("twerk_growth"));
    public static TagKey<Block> SPRINT_GROWTH = BlockTags.create(res("sprint_growth"));
}
