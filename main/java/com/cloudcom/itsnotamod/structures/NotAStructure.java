package com.cloudcom.itsnotamod.structures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

public abstract class NotAStructure {
	
	
	public abstract void generateStructure(BlockPos playerPos, World world);
	
	public int getMaxXSize() {
		return 1000;
	}
	
	public void transformEntity(Entity entity) {
		
	}
	public abstract void activeEntity(Entity entity);
}
