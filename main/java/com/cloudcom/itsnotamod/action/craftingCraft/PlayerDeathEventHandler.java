package com.cloudcom.itsnotamod.action.craftingCraft;

import com.cloudcom.itsnotamod.action.AbstractStuctureEventHandler;
import com.cloudcom.itsnotamod.action.NotAStructure;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerDeathEventHandler extends AbstractStuctureEventHandler{
	
	public static String Name = "LivingDeathEvent";

	@SubscribeEvent
	public void PlayerDeath(LivingDeathEvent event) {
		if (runEvent(Name,event)) {
			event.getEntityLiving().setHealth(20);
			event.getEntityLiving().addPotionEffect(new PotionEffect(Potion.getPotionById(11), 10, 10000));
		}
	}
	
}
