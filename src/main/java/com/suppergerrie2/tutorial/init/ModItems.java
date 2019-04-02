package com.suppergerrie2.tutorial.init;

import com.suppergerrie2.tutorial.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

/**
 * In this class I register all of my items, it also contains a reference to all of the items this mod adds. <br/>
 * We use the {@link RegistryEvent.Register<Item> registry event} to register the item. <br/>
 * And we use the {@link ObjectHolder objectholder} technique to let forge insert our item in the item variables. <br/>
 */
@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD) //This line tells forge this class has events we want to listen to, we also tell forge we want to listen to the Mod bus. (This is new in 1.13)
@ObjectHolder(Reference.MODID) //We use ObjectHolder to let forge inject the item into our variables, this to make sure when people replace our item we use the correct one.
public class ModItems {

    //Name has to match the registry name, else forge cant inject the item into here.
    //We dont have to add the modid because we added @ObjectHolder(modid) on the class itself
    //Note: even though this is final, forge can still change it! Your ide will complain that it will be null forever but this wont be the case.
    public static final Item tutorial_dust = null;

    /**
     * In here we register our items, this event is fired by forge on the {@link Mod.EventBusSubscriber.Bus mod bus}. <br/>
     * It's important we register in the event because we need to register on the right time. Else the game may crash because it didnt expect new items to appear
     * @param event The registry event itself
     */
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(

                //We instantiate a new item instance and pass in a Item.Properties instance with the maxStackSize set to 32, and the creative tab (group) set to miscellaneous.
                //Note that the tutorial_dust variable's name matches the registry name.
                new Item(new Item.Properties().maxStackSize(32).group(ItemGroup.MISC)).setRegistryName(Reference.MODID, "tutorial_dust"),


                //ItemBlock
                createItemBlockForBlock(ModBlocks.tutorial_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).maxStackSize(64))

        );
    }

    /**
     * Create the itemblock for the given block instance. The registryname will be set here.
     * @param block The block instance to create the item for.
     * @param properties The item properties to use
     * @return The itemblock
     */
    private static ItemBlock createItemBlockForBlock(Block block, Item.Properties properties) {
        return (ItemBlock) new ItemBlock(block, properties).setRegistryName(block.getRegistryName());
    }

}
