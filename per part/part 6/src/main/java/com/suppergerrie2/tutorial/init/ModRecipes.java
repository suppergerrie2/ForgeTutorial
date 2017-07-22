package com.suppergerrie2.tutorial.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void init() {
		GameRegistry.addSmelting(ModItems.tutorialDust, new ItemStack(ModItems.tutorialIngot, 1), 1.5f);
		GameRegistry.addSmelting(ModBlocks.tutorialOre, new ItemStack(ModItems.tutorialDust, 2), 0.2f);
		System.out.println("TEST");
	}
	
}
