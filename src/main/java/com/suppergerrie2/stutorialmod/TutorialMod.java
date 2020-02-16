package com.suppergerrie2.stutorialmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TutorialMod.MOD_ID)
public class TutorialMod {

    public static final String MOD_ID = "stutorialmod";

    public TutorialMod() {
        //Register the ITEMS deferred register to the mod event bus.
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
