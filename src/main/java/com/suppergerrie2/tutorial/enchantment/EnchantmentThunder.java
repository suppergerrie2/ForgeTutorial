package com.suppergerrie2.tutorial.enchantment;

import com.suppergerrie2.tutorial.init.ModEnchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.inventory.EntityEquipmentSlot;

public class EnchantmentThunder extends Enchantment {

	public EnchantmentThunder() {
		super(Rarity.COMMON, ModEnchantments.WEAPONS, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND});
		this.setRegistryName("thunder");
		this.setName("thunder");
	}

	@Override
	public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
		user.world.addWeatherEffect(new EntityLightningBolt(user.world, target.posX, target.posY, target.posZ, false));
	}	
}
