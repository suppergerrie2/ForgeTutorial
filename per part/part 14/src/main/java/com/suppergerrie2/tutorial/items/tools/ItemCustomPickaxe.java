package com.suppergerrie2.tutorial.items.tools;

import net.minecraft.item.ItemPickaxe;

public class ItemCustomPickaxe extends ItemPickaxe {

	public ItemCustomPickaxe(String name, ToolMaterial material) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
	
}
