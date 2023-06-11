package dev.quarris.twerkcropgrowth;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.Collections;
import java.util.stream.Collectors;

public class GrowthHandler {

    public static void applyGrowth(ServerPlayer player) {
        if (!player.onGround()) return;

        int radius = Configs.radius.get();
        int height = Configs.height.get();
        ServerLevel level = player.serverLevel();
        var blocksPoses = BlockPos.betweenClosedStream(new AABB(player.blockPosition()).inflate(radius, height, radius))
            .map(BlockPos::immutable)
            .filter(level::isLoaded)
            .collect(Collectors.toList());
        Collections.shuffle(blocksPoses);
        blocksPoses.stream()
            .limit(Configs.maxBlocks.get())
            .filter(p -> level.random.nextFloat() < Configs.chance.get())
            .forEach(pos -> {
                BlockState state = level.getBlockState(pos);
                if (!state.is(BlockTags.SAPLINGS) && !state.is(BlockTags.CROPS))
                    return;

                if (state.getBlock() instanceof BonemealableBlock block) {
                    if (block.isValidBonemealTarget(level, pos, state, false) && block.isBonemealSuccess(level, player.getRandom(), pos, state)) {
                        block.performBonemeal(level, player.getRandom(), pos, state);
                        level.levelEvent(1505, pos, 0);
                    }
                }
            });
    }
}
