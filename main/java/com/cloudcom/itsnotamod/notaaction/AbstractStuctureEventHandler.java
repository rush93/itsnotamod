package com.cloudcom.itsnotamod.notaaction;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;

public class AbstractStuctureEventHandler {
	
	public NotAStructure runEvent(String eventName, EntityEvent event) {
		Entity e = event.getEntity();
		boolean run = false;
		if (e instanceof EntityPlayer) {
			
			EntityPlayer p = (EntityPlayer) e;
			ArrayList<NotAStructure> structures = NotAStructure.activeStructures;
			for (int i = 0; i < structures.size(); i++) {
				if(p.getUniqueID().equals(structures.get(i).activePlayer.getUniqueID()) && structures.get(i).canRunEvent(eventName)) {
					event.setCanceled(structures.get(i).setCancel(eventName));
					structures.get(i).runEvent(eventName);
					return structures.get(i);
				}
			}
		}
		return null;
	}
}
