package dev.quarris.twerkcropgrowth;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(ModRef.ID)
public class ModRoot {

    public ModRoot() {
        var configBuilder = new ForgeConfigSpec.Builder();
        Configs.register(configBuilder);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, configBuilder.build());
    }
}
