package reoseah.caelum.surface_builders;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class CaelumSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig> {
	public CaelumSurfaceBuilder(Codec<TernarySurfaceConfig> codec) {
		super(codec);
	}

	@Override
	public void generate(Random random,
			Chunk chunk,
			Biome biome,
			int x, int z, int surfaceY,
			double depthNoise,
			BlockState defaultBlock,
			BlockState defaultFluid,
			int seaLevel,
			long seed,
			TernarySurfaceConfig config) {
		int surfaceDepth = (int) (depthNoise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
		this.generate(random, chunk, biome, x, z, surfaceY, surfaceDepth, defaultBlock, defaultFluid, config.getTopMaterial(), config.getUnderMaterial(), config.getUnderwaterMaterial(), seaLevel);
	}

	protected void generate(Random random,
			Chunk chunk,
			Biome biome,
			int x, int z, int y,
			int surfaceDepth,
			BlockState defaultBlock,
			BlockState defaultFluid,
			BlockState topMaterial,
			BlockState underMaterial,
			BlockState underwaterMaterial,
			int seaLevel) {
		BlockState top = topMaterial;
		BlockState under = underMaterial;
		BlockPos.Mutable pos = new BlockPos.Mutable();
		int depth = -1;
		int chunkX = x & 15;
		int chunkZ = z & 15;
		boolean hadSurface = false;

		for (int dy = y; dy >= 0; --dy) {
			pos.set(chunkX, dy, chunkZ);
			BlockState state = chunk.getBlockState(pos);
			if (state.isAir()) {
				if (hadSurface) {
					break;
				}
				depth = -1;
				continue;
			}
			if (state.getBlock() != defaultBlock.getBlock()) {
				continue;
			}

			hadSurface = true;
			if (depth == -1) {
				if (surfaceDepth < 0) {
					top = Blocks.AIR.getDefaultState();
					under = defaultBlock;
				} else if (dy >= seaLevel - 4 && dy <= seaLevel + 1) {
					top = topMaterial;
					under = underMaterial;
				}

				depth = surfaceDepth;
				if (dy >= seaLevel - 1) {
					chunk.setBlockState(pos, top, false);
				} else if (dy < seaLevel - 7 - surfaceDepth) {
					top = Blocks.AIR.getDefaultState();
					under = defaultBlock;
					chunk.setBlockState(pos, underwaterMaterial, false);
				} else {
					chunk.setBlockState(pos, under, false);
				}
				continue;
			}
			if (depth > 0) {
				--depth;
				chunk.setBlockState(pos, under, false);
			}
		}
	}
}
