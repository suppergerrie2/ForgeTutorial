package com.suppergerrie2.tutorial.init;

import com.suppergerrie2.tutorial.Reference;
import com.suppergerrie2.tutorial.blocks.BlockBasic;
import com.suppergerrie2.tutorial.blocks.BlockOre;
import com.suppergerrie2.tutorial.blocks.BlockOreMultiple;
import com.suppergerrie2.tutorial.blocks.BlockTutorialSlab;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModBlocks {

	static Block tutorialBlock;
	public static Block tutorialOre;
	static Block tuturialOreMultiple;
	
	public static BlockTutorialSlab tutorialSlabHalf;
	public static BlockTutorialSlab tutorialSlabDouble;
	
	public static void init() {
		tutorialBlock = new BlockBasic("tutorial_block", Material.ROCK).setHardness(1.5f).setCreativeTab(ModItems.tabTutorialMod).setLightLevel(1.0f);
		tutorialBlock.setHarvestLevel("pickaxe", 2);
		tutorialOre = new BlockOre("tutorial_ore", Material.ROCK, ModItems.tutorialDust, 1, 5).setHardness(3f).setResistance(5f).setCreativeTab(ModItems.tabTutorialMod);
		tutorialOre.setHarvestLevel("pickaxe", 2);
		tuturialOreMultiple = new BlockOreMultiple("tutorial_ore_multiple", Material.ROCK).setHardness(3f).setResistance(5f).setCreativeTab(ModItems.tabTutorialMod);
		tuturialOreMultiple.setHarvestLevel("pickaxe", 2);
		
		tutorialSlabHalf = new BlockTutorialSlab.Half("tutorial_slab", Material.ROCK);
		tutorialSlabHalf.setCreativeTab(ModItems.tabTutorialMod).setHardness(3f).setResistance(5f).setHarvestLevel("pickaxe", 2);
		tutorialSlabDouble = new BlockTutorialSlab.Double("double_tutorial_slab", Material.ROCK);
		tutorialSlabDouble.setHardness(3f).setResistance(5f).setHarvestLevel("pickaxe", 2);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(tutorialBlock, tutorialOre, tuturialOreMultiple, tutorialSlabHalf, tutorialSlabDouble);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(new ItemBlock(tutorialBlock).setRegistryName(tutorialBlock.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(tutorialOre).setRegistryName(tutorialOre.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(tuturialOreMultiple).setRegistryName(tuturialOreMultiple.getRegistryName()));
		event.getRegistry().register(new ItemSlab(tutorialSlabHalf, tutorialSlabHalf, tutorialSlabDouble).setRegistryName(tutorialSlabHalf.getRegistryName()));
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(Item.getItemFromBlock(tutorialBlock));
		registerRender(Item.getItemFromBlock(tutorialOre));
		registerRender(Item.getItemFromBlock(tuturialOreMultiple));
		registerRender(Item.getItemFromBlock(tutorialSlabHalf));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}
