package dev.quarris.twerkcropgrowth.mixin;

import dev.quarris.twerkcropgrowth.Constants;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Inject(at = @At("TAIL"), method = "<init>")
    private void init(CallbackInfo info) {
        Constants.LOG.info("This line is printed by the TwerkCropGrowth common mixin!");
        Constants.LOG.info("MC Version: {}", Minecraft.getInstance().getVersionType());
    }
}
