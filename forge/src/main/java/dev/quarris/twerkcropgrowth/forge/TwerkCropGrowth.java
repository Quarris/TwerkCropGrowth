package dev.quarris.twerkcropgrowth.forge;

import dev.quarris.twerkcropgrowth.common.CommonClass;
import dev.quarris.twerkcropgrowth.common.ModRef;
import net.minecraftforge.fml.common.Mod;

@Mod(ModRef.ID)
public class TwerkCropGrowth {

    public TwerkCropGrowth() {
        CommonClass.init();
        ForgeConfigs.register();
    }
}
