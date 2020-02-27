package com.suppergerrie2.stutorialmod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TutorialMod.MOD_ID)
public class TutorialMod {

    @SuppressWarnings("WeakerAccess")
    public static final String MOD_ID = "stutorialmod";

    public TutorialMod() {
        //Register the ITEMS and BLOCKS deferred register to the mod event bus.
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
