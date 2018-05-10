package com.suppergerrie2.tutorial.init;

import com.suppergerrie2.tutorial.Reference;
import com.suppergerrie2.tutorial.items.ItemBasic;
import com.suppergerrie2.tutorial.items.ItemCustomFood;
import com.suppergerrie2.tutorial.items.ItemEffectFood;
import com.suppergerrie2.tutorial.items.tools.ItemCustomAxe;
import com.suppergerrie2.tutorial.items.tools.ItemCustomHoe;
import com.suppergerrie2.tutorial.items.tools.ItemCustomPickaxe;
import com.suppergerrie2.tutorial.items.tools.ItemCustomSpade;
import com.suppergerrie2.tutorial.items.tools.ItemCustomSword;
import com.suppergerrie2.tutorial.items.tools.ItemPickaxeAxe;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModItems {
	
	static Item tutorialIngot;
	public static Item tutorialDust;
	static Item tutorialApple;
	static Item tutorialEffectApple;
	static Item tutorialPickaxe;
	static Item tutorialAxe;
	static Item tutorialSpade;
	static Item tutorialHoe;
	static Item tutorialSword;
	static Item tutorialPickaxeAxe;
	public static Item tutorialSeeds;
	
	public static final ToolMaterial TUTORIALMATERIAL = EnumHelper.addToolMaterial("TUTORIALMATERIAL", 3, 2048, 13f, 4.0f, 30);
	
	static final CreativeTabs tabTutorialMod = new CreativeTabs("tabTutorialMod") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(tutorialDust);
		}
		
		@Override
		public boolean hasSearchBar() {
			return true;
		}
		
	}.setBackgroundImageName("item_search.png");
	
	public static void init() {
		tutorialIngot = new ItemBasic("tutorial_ingot").setCreativeTab(tabTutorialMod).setMaxStackSize(32);
		tutorialDust = new ItemBasic("tutorial_dust").setCreativeTab(tabTutorialMod);
		tutorialApple = new ItemCustomFood("tutorial_apple", 5, 0.3f, false).setCreativeTab(tabTutorialMod);
		tutorialEffectApple = new ItemEffectFood("tutorial_effect_apple", 5, 0.3f, false).setCreativeTab(tabTutorialMod);
		
		tutorialPickaxe = new ItemCustomPickaxe("tutorial_pickaxe", TUTORIALMATERIAL).setCreativeTab(tabTutorialMod);
		tutorialAxe = new ItemCustomAxe("tutorial_axe", TUTORIALMATERIAL, 9.0f, -2.8f).setCreativeTab(tabTutorialMod);
		tutorialSpade = new ItemCustomSpade("tutorial_shovel", TUTORIALMATERIAL).setCreativeTab(tabTutorialMod);
		tutorialHoe = new ItemCustomHoe("tutorial_hoe", TUTORIALMATERIAL).setCreativeTab(tabTutorialMod);
		tutorialSword = new ItemCustomSword("tutorial_sword", TUTORIALMATERIAL).setCreativeTab(tabTutorialMod);
		tutorialPickaxeAxe = new ItemPickaxeAxe("tutorial_pickaxe_axe", TUTORIALMATERIAL).setCreativeTab(tabTutorialMod);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(tutorialIngot, tutorialDust, tutorialApple, tutorialEffectApple, tutorialPickaxe, tutorialAxe, tutorialSpade, tutorialHoe, tutorialSword, tutorialPickaxeAxe);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(tutorialIngot);
		registerRender(tutorialDust);
		registerRender(tutorialApple);
		registerRender(tutorialEffectApple);
		registerRender(tutorialPickaxe);
		registerRender(tutorialAxe);
		registerRender(tutorialSpade);
		registerRender(tutorialHoe);
		registerRender(tutorialSword);
		registerRender(tutorialPickaxeAxe);
		registerRender(tutorialSeeds);
	}
	
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}
