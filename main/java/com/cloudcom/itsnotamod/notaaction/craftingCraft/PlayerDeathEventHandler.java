package com.cloudcom.itsnotamod.notaaction.craftingCraft;

import com.cloudcom.itsnotamod.notaaction.AbstractStuctureEventHandler;
import com.cloudcom.itsnotamod.notaaction.NotAStructure;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerDeathEventHandler extends AbstractStuctureEventHandler{
	
	public static String Name = "LivingDeathEvent";

	@SubscribeEvent
	public void PlayerDeath(LivingDeathEvent event) {
		NotAStructure str = runEvent(Name,event);
		if (str!=null && str.setCancel(Name)) {
			event.getEntityLiving().setHealth(20);
			event.getEntityLiving().addPotionEffect(new PotionEffect(Potion.getPotionById(11), 10, 10000));
		}
	}
	
}
