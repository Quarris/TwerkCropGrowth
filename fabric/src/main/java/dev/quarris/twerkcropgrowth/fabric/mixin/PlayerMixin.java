package dev.quarris.twerkcropgrowth.fabric.mixin;

import dev.quarris.twerkcropgrowth.common.Configs;
import dev.quarris.twerkcropgrowth.common.GrowthHandler;
import dev.quarris.twerkcropgrowth.common.ModRef;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerMixin {

    @Inject(method = "tick", at = @At("TAIL"))
    private void sprintGrowth(CallbackInfo ci) {
        if (!((Object) this instanceof ServerPlayer player)) return;

        if (player.isSprinting()) {
            GrowthHandler.applyGrowth(player, ModRef.SPRINT_GROWTH, Configs.sprintRadius, Configs.sprintHeight, Configs.sprintMaxBlocks, Configs.sprintChance);
        }
    }
}
