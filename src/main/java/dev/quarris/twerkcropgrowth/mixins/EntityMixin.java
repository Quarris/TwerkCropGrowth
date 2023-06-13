package dev.quarris.twerkcropgrowth.mixins;

import dev.quarris.twerkcropgrowth.Configs;
import dev.quarris.twerkcropgrowth.GrowthHandler;
import dev.quarris.twerkcropgrowth.ModRef;
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
            GrowthHandler.applyGrowth(player, ModRef.TWERK_GROWTH, Configs.twerkRadius.get(), Configs.twerkHeight.get(), Configs.twerkMaxBlocks.get(), Configs.twerkChance.get());
        }
    }

}
