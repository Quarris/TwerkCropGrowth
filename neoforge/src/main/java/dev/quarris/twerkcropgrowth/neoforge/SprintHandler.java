package dev.quarris.twerkcropgrowth.neoforge;

import dev.quarris.twerkcropgrowth.common.Configs;
import dev.quarris.twerkcropgrowth.common.GrowthHandler;
import dev.quarris.twerkcropgrowth.common.ModRef;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = ModRef.ID)
public class SprintHandler {

    @SubscribeEvent
    public static void doSprintGrowth(PlayerTickEvent.Post event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        if (player.isSprinting()) {
            GrowthHandler.applyGrowth(player, ModRef.SPRINT_GROWTH, Configs.sprintRadius, Configs.sprintHeight, Configs.sprintMaxBlocks, Configs.sprintChance);
        }
    }
}
