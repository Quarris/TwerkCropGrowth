package dev.quarris.twerkcropgrowth.forge;

import dev.quarris.twerkcropgrowth.common.Configs;
import dev.quarris.twerkcropgrowth.common.GrowthHandler;
import dev.quarris.twerkcropgrowth.common.ModRef;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModRef.ID)
public class SprintHandler {

    @SubscribeEvent
    public static void doSprintGrowth(TickEvent.PlayerTickEvent.Post event) {
        if (!(event.player instanceof ServerPlayer player)) return;

        if (player.isSprinting()) {
            GrowthHandler.applyGrowth(player, ModRef.SPRINT_GROWTH, Configs.sprintRadius, Configs.sprintHeight, Configs.sprintMaxBlocks, Configs.sprintChance);
        }
    }
}
