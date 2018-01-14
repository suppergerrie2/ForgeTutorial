package com.suppergerrie2.tutorial.items.tools;

import net.minecraft.item.ItemHoe;

public class ItemCustomHoe extends ItemHoe {

	public ItemCustomHoe(String name, ToolMaterial material) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}


}
