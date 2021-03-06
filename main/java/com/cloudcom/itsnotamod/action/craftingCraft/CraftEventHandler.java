package com.cloudcom.itsnotamod.action.craftingCraft;


import com.cloudcom.itsnotamod.gui.NotAGuiInformation;
import com.cloudcom.itsnotamod.world.NotAWorld;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftEventHandler {
	
	@SubscribeEvent
	public void onCraftTable(ItemCraftedEvent event) {
		EntityPlayer player = event.player;
		World worldObj = player.getEntityWorld();
		if (event.crafting.getItem() == Item.getItemById(58)) {

			// Test de recup des valeurs
			System.out.println(player.posX + 2 + " " + player.posY + " " + player.posZ);

			// Création d'un sheep
			EntitySheep entity = new EntitySheep(worldObj);

			// La pos de là où il va spawn
			entity.setPosition(player.posX + 2, player.posY, player.posZ);

			// Choix de la couleur
			EnumDyeColor color = EnumDyeColor.PINK;
			entity.setFleeceColor(color);

			// Test
			System.out.println(color.toString());

			if (!worldObj.isRemote){
				// Spawn de l'entity
				worldObj.spawnEntityInWorld(entity);
			}


			if(player.getServer() != null ) {
				NotAWorld.generateAndTeleportStructure(player, new TestStructure(player));
			} else {
				
				NotAGuiInformation gui = new NotAGuiInformation(new Gui(),"Mission","Suicide-toi pour avoir ta table de craft !");
				Minecraft.getMinecraft().displayGuiScreen(gui);
			}
			
		}
	}
	

}
