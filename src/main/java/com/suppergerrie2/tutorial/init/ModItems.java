package com.suppergerrie2.tutorial.init;

import com.suppergerrie2.tutorial.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Reference.MODID)
public class ModItems {

    public static final Item tutorial_item = null;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(

                new Item(new Item.Properties().maxStackSize(32).group(ItemGroup.MISC)).setRegistryName(Reference.MODID, "tutorial_dust")

        );
    }

}
