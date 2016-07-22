package com.cloudcom.itsnotamod.notaaction.craftingCraft;

import java.util.ArrayList;

import com.cloudcom.itsnotamod.notaaction.NotAStructure;
import com.cloudcom.itsnotamod.world.NotAWorld;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

public class TestStructure extends NotAStructure {

	public TestStructure(EntityPlayer activePlayer) {
		super(activePlayer);
		super.registerEvent(PlayerDeathEventHandler.Name);
	}

	@Override
	public void generateStructure(BlockPos playerPos, World world, BlockPos pos) {
		world.setBlockState(playerPos.add(0, -1, 0), Block.getStateById(3));
		this.oldPlayerPos = pos;
	}
	
	public int getMaxXSize() {
		return 10;
	}
	
	public void activeEntity(Entity entity) {
		if(entity instanceof EntityPlayer) {
			((EntityPlayer)entity).setGameType(GameType.ADVENTURE);
		}
	}

	@Override
	public void runEvent(String event) {
		if(event.equals("LivingDeathEvent")){
			NotAWorld.BackToOverWorld(this.activePlayer, oldPlayerPos.getX(), oldPlayerPos.getY(), oldPlayerPos.getZ());
			activePlayer.setGameType(GameType.SURVIVAL);
			PlayerLeave();
		}
	}

	@Override
	public boolean setCancel(String event) {
		return true;
	}
}
