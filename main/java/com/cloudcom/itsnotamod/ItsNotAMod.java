package com.cloudcom.itsnotamod;

import org.apache.logging.log4j.Logger;

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
    
    @SidedProxy(clientSide = "à modifier ensuite", serverSide = "à modifier ensuite")
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
    	proxy.init();
    }
}
