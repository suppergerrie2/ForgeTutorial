package com.suppergerrie2.tutorial;

import com.suppergerrie2.tutorial.gen.OreGen;
import com.suppergerrie2.tutorial.init.ModBlocks;
import com.suppergerrie2.tutorial.init.ModItems;
import com.suppergerrie2.tutorial.init.ModRecipes;
import com.suppergerrie2.tutorial.proxies.IProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name=Reference.MODNAME, version=Reference.VERSION, acceptedMinecraftVersions=Reference.ACCEPTED_MINECRAFT_VERSIONS)
public class TutorialMod {
	
	@Instance
	public static TutorialMod instance;
	
	@SidedProxy(modId=Reference.MODID,clientSide=Reference.CLIENTPROXY, serverSide=Reference.SERVERPROXY)
	public static IProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(Reference.MODID + ":preInit");
		ModItems.init();
		ModBlocks.init();
		
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println(Reference.MODID + ":init");
		ModRecipes.init();
		
		GameRegistry.registerWorldGenerator(new OreGen(), 0);
		
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(Reference.MODID + ":postInit");
		
		proxy.postInit(event);
	}
	
}
