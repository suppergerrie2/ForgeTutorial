package com.suppergerrie2.tutorial.init;

import com.suppergerrie2.tutorial.Reference;
import com.suppergerrie2.tutorial.items.ItemBasic;
import com.suppergerrie2.tutorial.items.ItemCustomFood;
import com.suppergerrie2.tutorial.items.ItemEffectFood;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModItems {
	
	static Item tutorialIngot;
	static Item tutorialDust;
	static Item tutorialApple;
	static Item tutorialEffectApple;
	
	public static void init() {
		tutorialIngot = new ItemBasic("tutorialIngot").setCreativeTab(CreativeTabs.MATERIALS).setMaxStackSize(32);
		tutorialDust = new ItemBasic("tutorialDust").setCreativeTab(CreativeTabs.MATERIALS);
		tutorialApple = new ItemCustomFood("tutorialApple", 5, 0.3f, false).setCreativeTab(CreativeTabs.FOOD);
		tutorialEffectApple = new ItemEffectFood("tutorialEffectApple", 5, 0.3f, false).setCreativeTab(CreativeTabs.FOOD);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(tutorialIngot, tutorialDust, tutorialApple, tutorialEffectApple);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(tutorialIngot);
		registerRender(tutorialDust);
		registerRender(tutorialApple);
		registerRender(tutorialEffectApple);
	}
	
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}
