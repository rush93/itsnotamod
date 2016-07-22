package com.cloudcom.itsnotamod.notaaction;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public abstract class NotAStructure {
	
	public static ArrayList<NotAStructure> activeStructures = new ArrayList<NotAStructure>();
	public EntityPlayer activePlayer;
	public ArrayList<String> events;
	public BlockPos oldPlayerPos;
	public abstract void generateStructure(BlockPos playerPos, World world, BlockPos oldPosition);
	
	public NotAStructure(EntityPlayer activePlayer) {
		activeStructures.add(this);
		this.activePlayer = activePlayer;
		this.events = new ArrayList<String>();
	}
	
	public void registerEvent(String event) {
		this.events.add(event);
	}
	
	public int getMaxXSize() {
		return 1000;
	}
	
	public void transformEntity(Entity entity) {
		
	}
	
	public abstract void activeEntity(Entity entity);
	
	public abstract void runEvent(String event);

	public abstract boolean setCancel(String event);
	
	public boolean canRunEvent(String event) {
		return events.contains(event);
	}
	
	public void PlayerLeave() {
		activeStructures.remove(this);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activePlayer == null) ? 0 : activePlayer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotAStructure other = (NotAStructure) obj;
		if (activePlayer == null) {
			if (other.activePlayer != null)
				return false;
		} else if (!activePlayer.getUniqueID().equals(other.activePlayer.getUniqueID()))
			return false;
		return true;
	}
}
