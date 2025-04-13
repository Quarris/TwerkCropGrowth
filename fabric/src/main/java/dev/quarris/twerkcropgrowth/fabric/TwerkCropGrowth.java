package dev.quarris.twerkcropgrowth.fabric;

import dev.quarris.twerkcropgrowth.common.CommonClass;
import net.fabricmc.api.ModInitializer;

public class TwerkCropGrowth implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonClass.init();
        FabricConfigs.register();
    }
}
