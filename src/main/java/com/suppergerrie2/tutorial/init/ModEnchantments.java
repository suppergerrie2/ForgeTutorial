package com.suppergerrie2.tutorial.init;

import com.suppergerrie2.tutorial.Reference;
import com.suppergerrie2.tutorial.enchantment.EnchantmentGrassness;
import com.suppergerrie2.tutorial.enchantment.EnchantmentThunder;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class ModEnchantments {

	public static final EnumEnchantmentType WEAPONS = EnumHelper.addEnchantmentType("weapons", (item)->(item instanceof ItemSword || item instanceof ItemBow));
	
	public static final Enchantment THUNDER = new EnchantmentThunder();
	public static final Enchantment GRASSNESS = new EnchantmentGrassness();
	
	@SubscribeEvent
	public static void registerEnchantments(Register<Enchantment> event) {
		event.getRegistry().registerAll(THUNDER, GRASSNESS);
	}
	
}
