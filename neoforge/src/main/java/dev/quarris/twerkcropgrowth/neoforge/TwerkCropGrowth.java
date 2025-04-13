package dev.quarris.twerkcropgrowth.neoforge;


import dev.quarris.twerkcropgrowth.common.CommonClass;
import dev.quarris.twerkcropgrowth.common.ModRef;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(ModRef.ID)
public class TwerkCropGrowth {

    public TwerkCropGrowth(ModContainer container, IEventBus eventBus) {
        CommonClass.init();
        NeoForgeConfigs.register(container);
    }
}
