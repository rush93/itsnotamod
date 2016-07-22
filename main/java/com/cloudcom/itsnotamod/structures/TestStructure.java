package com.cloudcom.itsnotamod.structures;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;

public class TestStructure extends NotAStructure {

	@Override
	public void generateStructure(BlockPos playerPos, World world) {
		world.setBlockState(playerPos.add(0, -1, 0), Block.getStateById(3));
		world.setBlockState(playerPos.add(0, 1, 0), Block.getStateById(3));
	}
	
	public int getMaxXSize() {
		return 10;
	}
	
	public void activeEntity(Entity entity) {
		if(entity instanceof EntityPlayer) {
			((EntityPlayer)entity).setGameType(GameType.ADVENTURE);
		}
	}
}
