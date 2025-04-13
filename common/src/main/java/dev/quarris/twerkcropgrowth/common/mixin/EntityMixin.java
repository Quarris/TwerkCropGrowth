package dev.quarris.twerkcropgrowth.common.mixin;

import dev.quarris.twerkcropgrowth.common.Configs;
import dev.quarris.twerkcropgrowth.common.GrowthHandler;
import dev.quarris.twerkcropgrowth.common.ModRef;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(method = "setShiftKeyDown", at = @At("HEAD"))
    public void applyBonemealAffect(boolean sneak, CallbackInfo ci) {
        if (!((Object) this instanceof ServerPlayer player)) {
            return;
        }

        if (sneak) {
            GrowthHandler.applyGrowth(player, ModRef.TWERK_GROWTH, Configs.twerkRadius, Configs.twerkHeight, Configs.twerkMaxBlocks, Configs.twerkChance);
        }
    }
}
