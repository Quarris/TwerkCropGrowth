package dev.quarris.twerkcropgrowth.fabric;

import dev.quarris.twerkcropgrowth.common.ModRef;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class DataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(BlockTagGenerator::new);
    }

    private static class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
        public BlockTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            getOrCreateTagBuilder(ModRef.TWERK_GROWTH)
                .addOptionalTag(BlockTags.CROPS)
                .addOptionalTag(BlockTags.SAPLINGS)
                .add(Blocks.SUGAR_CANE)
                .add(Blocks.CACTUS);

            getOrCreateTagBuilder(ModRef.SPRINT_GROWTH)
                .addOptionalTag(BlockTags.CROPS)
                .addOptionalTag(BlockTags.SAPLINGS)
                .add(Blocks.SUGAR_CANE)
                .add(Blocks.CACTUS);
        }
    }
}