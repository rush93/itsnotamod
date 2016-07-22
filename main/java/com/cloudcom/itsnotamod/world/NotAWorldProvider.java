package com.cloudcom.itsnotamod.world;

import net.minecraft.init.Biomes;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderFlat;

public class NotAWorldProvider extends WorldProvider
{	
	public static DimensionType dimensionType;
	
	public NotAWorldProvider()
	{
		super();
	}
	

	@Override
    public void createBiomeProvider()
    {
        this.biomeProvider = new BiomeProviderSingle(Biomes.VOID);
    }
	
	@Override
    public IChunkGenerator createChunkGenerator()
    {
        return new ChunkProviderFlat(this.worldObj, this.worldObj.getSeed(), false, "3;minecraft:air");
    }
    
	@Override
	public DimensionType getDimensionType() {
		return dimensionType;
	}

}