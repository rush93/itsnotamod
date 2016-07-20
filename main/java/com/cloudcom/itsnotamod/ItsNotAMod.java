package com.cloudcom.itsnotamod;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ItsNotAMod.MODID, name = "It's not a Mod", version = "0.1", acceptedMinecraftVersions = "[1.10.2]")
public class ItsNotAMod
{
    public static final String MODID = "inam";
    
    @Instance(ItsNotAMod.MODID)
    public static ItsNotAMod instance;
    
    @SidedProxy(clientSide = "com.cloudcom.itsnotamod.InamClient", serverSide = "com.cloudcom.itsnotamod.InamServer")
    public static InamCommon proxy;
    
    public static Logger logger;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	logger = event.getModLog();
        proxy.preInit(event.getSuggestedConfigurationFile());
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	//Event de craft
    	MinecraftForge.EVENT_BUS.register(new CraftEventHandler());
    	
    	//Event de ...
    	
    	proxy.init();
    }
}
