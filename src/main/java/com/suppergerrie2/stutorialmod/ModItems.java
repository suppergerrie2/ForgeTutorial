package com.suppergerrie2.stutorialmod;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings({"WeakerAccess", "unused"})
public class ModItems {

    //The ITEMS deferred register in which you can register items.
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    //Register the tutorial dust with "tutorial_dust" as registry name and default properties
    public static final RegistryObject<Item> TUTORIAL_DUST = ITEMS.register("tutorial_dust", () -> new Item(new Item.Properties()));

    //Register the tutorial block's item so a player can place it.
    public static final RegistryObject<Item> TUTORIAL_BLOCK = ITEMS.register("tutorial_block", () -> new BlockItem(ModBlocks.TUTORIAL_BLOCK.get(), new Item.Properties()));

}
