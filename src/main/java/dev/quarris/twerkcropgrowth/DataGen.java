package dev.quarris.twerkcropgrowth;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class DataGen {

    public static void gatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(event.includeServer(), new BlockTagGen(event.getGenerator().getPackOutput(), event.getLookupProvider(), ModRef.ID, event.getExistingFileHelper()));
    }

    public static class BlockTagGen extends BlockTagsProvider {

        public BlockTagGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, modId, existingFileHelper);
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void addTags(HolderLookup.Provider provider) {
            this.tag(ModRef.TWERK_GROWTH)
                .addTags(BlockTags.CROPS, BlockTags.SAPLINGS)
                .add(Blocks.SUGAR_CANE, Blocks.CACTUS);

            this.tag(ModRef.SPRINT_GROWTH)
                .addTags(BlockTags.CROPS, BlockTags.SAPLINGS)
                .add(Blocks.SUGAR_CANE, Blocks.CACTUS);
        }
    }

}
