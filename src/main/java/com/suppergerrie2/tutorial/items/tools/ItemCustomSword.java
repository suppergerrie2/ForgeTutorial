package com.suppergerrie2.tutorial.items.tools;

import net.minecraft.item.ItemSword;

public class ItemCustomSword extends ItemSword {

	public ItemCustomSword(String name, ToolMaterial material) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}

}
