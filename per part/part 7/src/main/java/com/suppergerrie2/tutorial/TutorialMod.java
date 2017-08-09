package com.suppergerrie2.tutorial;

import com.suppergerrie2.tutorial.gen.OreGen;
import com.suppergerrie2.tutorial.init.ModBlocks;
import com.suppergerrie2.tutorial.init.ModItems;
import com.suppergerrie2.tutorial.init.ModRecipes;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name=Reference.MODNAME, version=Reference.VERSION, acceptedMinecraftVersions=Reference.ACCEPTED_MINECRAFT_VERSIONS)
public class TutorialMod {
	
	@Instance
	public static TutorialMod instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(Reference.MODID + ":preInit");
		ModItems.init();
		ModBlocks.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println(Reference.MODID + ":init");
		ModRecipes.init();
		
		GameRegistry.registerWorldGenerator(new OreGen(ModBlocks.tutorialOre, 7, 10, 50, 10), 0);
		GameRegistry.registerWorldGenerator(new OreGen(Blocks.BRICK_BLOCK, 7, 0, 255, 10, 1, BlockMatcher.forBlock(Blocks.END_STONE)), 0);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(Reference.MODID + ":postInit");
	}
	
}
