package com.suppergerrie2.tutorial.enchantment;

import com.suppergerrie2.tutorial.Reference;
import com.suppergerrie2.tutorial.init.ModEnchantments;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class EnchantmentGrassness extends Enchantment {

	public EnchantmentGrassness() {
		super(Rarity.UNCOMMON, EnumEnchantmentType.ARMOR_FEET, new EntityEquipmentSlot[] {EntityEquipmentSlot.FEET});
		this.setRegistryName("grassness");
		this.setName("grassness");
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@SubscribeEvent
	public static void growGrassness(LivingUpdateEvent event) {
		if(!event.getEntity().world.isRemote) {
			//Get the enchantment level the entity has
			int level = EnchantmentHelper.getMaxEnchantmentLevel(ModEnchantments.GRASSNESS, event.getEntityLiving());

			//We only continue if the entity has the enchantment and thus the level is higher than 0
			if(level>0&&event.getEntityLiving().onGround) {
				Entity e = event.getEntity();
				if(e instanceof EntityPlayerMP&&((EntityPlayerMP)e).isSpectator()) {
					return;
				}
				World w = e.world;
				int r = level+1;
				BlockPos pos = e.getPosition();
				for(int x = -r; x <= r; x++) {
					for(int z = -r; z <= r; z++) {
						BlockPos blockpos = pos.add(x,-1,z);
						if(blockpos.distanceSq(pos.getX(), pos.getY(), pos.getZ())>r*r) {
							continue;
						}

						IBlockState iblockstate = w.getBlockState(blockpos);
						if (iblockstate.getBlock() == Blocks.DIRT && iblockstate.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT && w.getLightFromNeighbors(blockpos.up()) >= 4)
						{
							w.setBlockState(blockpos, Blocks.GRASS.getDefaultState());
						}
					}
				}
			}
		}
	}
}
