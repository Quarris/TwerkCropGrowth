package dev.quarris.twerkcropgrowth.common;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.Collections;
import java.util.stream.Collectors;

public class GrowthHandler {

    public static void applyGrowth(ServerPlayer player, TagKey<Block> tag, int radius, int height, int maxBlocks, double chance) {
        if (!player.onGround()) return;

        ServerLevel level = player.serverLevel();
        var blocksPoses = BlockPos.betweenClosedStream(new AABB(player.blockPosition()).inflate(radius, height, radius))
            .map(BlockPos::immutable)
            .filter(level::isLoaded)
            .collect(Collectors.toList());
        Collections.shuffle(blocksPoses);
        blocksPoses.stream()
            .limit(maxBlocks)
            .filter(p -> level.random.nextFloat() < chance)
            .filter(pos -> level.getBlockState(pos).is(tag))
            .forEach(pos -> {
                BlockState state = level.getBlockState(pos);

                if (state.getBlock() instanceof BonemealableBlock block) {
                    if (block.isValidBonemealTarget(level, pos, state)) {
                        if (block.isBonemealSuccess(level, player.getRandom(), pos, state)) {
                            block.performBonemeal(level, player.getRandom(), pos, state);
                        }
                        level.levelEvent(1505, pos, 0);
                    }
                    return;
                }

                if (state.isRandomlyTicking()) {
                    for (int i = 0; i < Configs.randomTickTries; i++) {
                        if (player.getRandom().nextFloat() < Configs.randomTickChance) {
                            level.getBlockState(pos).randomTick(level, pos, player.getRandom());
                        }
                    }
                    level.levelEvent(1505, pos, 0);
                }
            });
    }
}