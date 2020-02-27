package com.suppergerrie2.stutorialmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings({"WeakerAccess", "unused"})
public class ModBlocks {

    //The BLOCKS deferred register in which you can register blocks.
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    //Register the tutorial block with "tutorial_block" as registry name and default ROCK properties
    public static final RegistryObject<Block> TUTORIAL_BLOCK = BLOCKS.register("tutorial_block", () -> new Block(Block.Properties.create(Material.ROCK)));
}
