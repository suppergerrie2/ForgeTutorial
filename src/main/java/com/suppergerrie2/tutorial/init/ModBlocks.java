package com.suppergerrie2.tutorial.init;

import com.suppergerrie2.tutorial.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

/**
 * In this class I register all of my blocks, it also contains a reference to all of the blocks this mod adds. <br/>
 * We use the {@link RegistryEvent.Register<Block> registry event} to register the block. <br/>
 * And we use the {@link ObjectHolder objectholder} technique to let forge insert our block in the block variables. <br/>
 */
@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.MOD) //This line tells forge this class has events we want to listen to, we also tell forge we want to listen to the Mod bus. (This is new in 1.13)
@ObjectHolder(Reference.MODID) //We use ObjectHolder to let forge inject the block into our variables, this to make sure when people replace our block we use the correct one.
public class ModBlocks {

    //Name has to match the registry name, else forge cant inject the block into here.
    //We dont have to add the modid because we added @ObjectHolder(modid) on the class itself
    //Note: even though this is final, forge can still change it! Your ide will complain that it will be null forever but this wont be the case.
    public static final Block tutorial_block = null;

    /**
     * In here we register our blocks, this event is fired by forge on the {@link Mod.EventBusSubscriber.Bus mod bus}. <br/>
     * It's important we register in the event because we need to register on the right time. Else the game may crash because it didnt expect new blocks to appear
     * @param event The registry event itself
     */
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(

                //We instantiate a new block instance and pass in a Block.Properties instance with the hardnessAndResistence set to 2.0, we create that instance by calling Block.Properties.create.
                //Note that the tutorial_block variable's name matches the registry name.
                new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0f, 3.0f)).setRegistryName(Reference.MODID, "tutorial_block")

        );
    }

}