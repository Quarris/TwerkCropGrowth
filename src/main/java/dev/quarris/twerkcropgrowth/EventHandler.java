package dev.quarris.twerkcropgrowth;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ModRef.ID)
public class EventHandler {

    @SubscribeEvent
    public static void doSprintGrowth(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) return;
        if (!(event.player instanceof ServerPlayer player)) return;

        if (event.player.isSprinting()) {
            GrowthHandler.applyGrowth(player, ModRef.SPRINT_GROWTH, Configs.sprintRadius.get(), Configs.sprintHeight.get(), Configs.sprintMaxBlocks.get(), Configs.sprintChance.get());
        }
    }
}
