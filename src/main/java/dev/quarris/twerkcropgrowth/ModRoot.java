package dev.quarris.twerkcropgrowth;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModRef.ID)
public class ModRoot {

    public ModRoot() {
        var configBuilder = new ForgeConfigSpec.Builder();
        Configs.register(configBuilder);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, configBuilder.build());

        FMLJavaModLoadingContext.get().getModEventBus().addListener(DataGen::gatherData);
    }


}
