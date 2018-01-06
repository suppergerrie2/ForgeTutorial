package com.suppergerrie2.tutorial.blocks;

import java.util.ArrayList;

import com.suppergerrie2.tutorial.init.ModItems;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockOreMultiple extends BlockBasic {

	public BlockOreMultiple(String name, Material material) {
		super(name, material);
	}

	@Override 
	public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune){
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		
		drops.add(new ItemStack(ModItems.tutorialDust, RANDOM.nextInt(4)+2));
		if(RANDOM.nextFloat()>0.5f) {
			drops.add(new ItemStack(Items.DIAMOND, 1));
		}
		
		return drops;
	}
}
