package com.cloudcom.itsnotamod.world;

import org.lwjgl.util.vector.Vector3f;

import com.cloudcom.itsnotamod.structures.NotAStructure;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

public class NotAWorld {
	public static int notADimensionID = -3;
	public static DimensionType notADimensionType;
	public static int lastX = 0;
	
	public static void init()
	{		
		DimensionType notADimentionType = DimensionType.register("NotADimension", "NotADimension", "NotADimension".hashCode(), NotAWorldProvider.class, true);
		NotAWorldProvider.dimensionType = notADimentionType;
		DimensionManager.registerDimension(notADimensionID, notADimentionType);
	}
	
	public static void generateAndTeleportStructure(MinecraftServer server, Entity entity, NotAStructure structure) {
		teleportEntityToDimension( server, entity, notADimensionID);
		entity.setPositionAndUpdate(lastX, 64, 0);
		structure.generateStructure(entity.getPosition(), entity.getEntityWorld());
		lastX+=structure.getMaxXSize();
		structure.activeEntity(entity);
	}
	
	private static Entity teleportEntityToDimension(MinecraftServer server, Entity entity, int dimension)
	{
		World worldObj = server.worldServerForDimension(dimension);

		if (entity instanceof EntityPlayerMP)
		{
			server.getPlayerList().transferPlayerToDimension((EntityPlayerMP) entity, dimension, new NotAWorldTeleporter((WorldServer) server.getEntityWorld()));
			return entity;
		}
		else
		{
			return travelEntity(server, entity, dimension);
		}
	}
	
	private static Entity travelEntity(MinecraftServer server, Entity entity, int dimensionId)
	{
		if (!entity.worldObj.isRemote && !entity.isDead)
		{
			entity.worldObj.theProfiler.startSection("changeDimension");
			int j = entity.dimension;
			WorldServer worldserver = server.worldServerForDimension(j);
			WorldServer worldserver1 = server.worldServerForDimension(dimensionId);
			entity.dimension = dimensionId;

			Entity newEntity = EntityList.createEntityByName(EntityList.getEntityString(entity), worldserver1);

			if (newEntity != null)
			{
				
				entity.worldObj.removeEntity(entity);

				newEntity.forceSpawn = true;

				worldserver1.spawnEntityInWorld(newEntity);
			}

			worldserver1.updateEntityWithOptionalForce(newEntity, true);

			entity.isDead = true;
			entity.worldObj.theProfiler.endSection();
			worldserver.resetUpdateEntityTick();
			worldserver1.resetUpdateEntityTick();
			entity.worldObj.theProfiler.endSection();
			return newEntity;
		}

		return entity;
	}
}