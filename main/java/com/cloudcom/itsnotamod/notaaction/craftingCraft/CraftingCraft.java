package com.cloudcom.itsnotamod.notaaction.craftingCraft;

import net.minecraftforge.common.MinecraftForge;

public class CraftingCraft {
	public static void init(){
		MinecraftForge.EVENT_BUS.register(new CraftEventHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerDeathEventHandler());
	}
}
