package com.suppergerrie2.tutorial.items.tools;

import net.minecraft.item.ItemAxe;

public class ItemCustomAxe extends ItemAxe {

	public ItemCustomAxe(String name, ToolMaterial material, float damage, float speed) {
		super(material, damage, speed);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}

}
