package reoseah.caelum.registry;

import java.util.OptionalLong;

import com.mojang.serialization.Lifecycle;

import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.SimpleRegistry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.FixedBiomeSource;
import net.minecraft.world.biome.source.HorizontalVoronoiBiomeAccessType;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.GenerationShapeConfig;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import net.minecraft.world.gen.chunk.NoiseSamplingConfig;
import net.minecraft.world.gen.chunk.SlideConfig;
import net.minecraft.world.gen.chunk.StructuresConfig;
import reoseah.caelum.mixins.ChunkGeneratorSettingsInvoker;
import reoseah.caelum.mixins.DimensionOptionsInvoker;
import reoseah.caelum.mixins.DimensionTypeInvoker;

public class CaelumDimension {
	public static final RegistryKey<World> DIMENSION_KEY = RegistryKey.of(Registry.DIMENSION, new Identifier("caelum:caelum"));
	public static final RegistryKey<DimensionType> DIMENSION_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, new Identifier("caelum:caelum"));
	public static final RegistryKey<DimensionOptions> DIMENSION_OPTIONS = RegistryKey.of(Registry.DIMENSION_OPTIONS, new Identifier("caelum:caelum"));
	public static final RegistryKey<ChunkGeneratorSettings> CHUNK_GENERATOR_SETTINGS_KEY = RegistryKey.of(Registry.NOISE_SETTINGS_WORLDGEN, new Identifier("caelum:caelum"));

	public static final DimensionType DIMENSION_TYPE = DimensionTypeInvoker.create(OptionalLong.empty(), true, false, false, true, 1, false, false, true, false, false, 128, HorizontalVoronoiBiomeAccessType.INSTANCE, new Identifier("caelum:infiniburn_caelum"), new Identifier("caelum:caelum"), 0.1F);

	public static final ChunkGeneratorSettings CHUNK_GENERATOR_SETTINGS = ChunkGeneratorSettingsInvoker.create(
			new StructuresConfig(false),
			new GenerationShapeConfig(128,
					new NoiseSamplingConfig(2D, 1D, 80.0D, 160.0D),
					new SlideConfig(-3000, 64, -46),
					new SlideConfig(-30, 7, 5),
					2, 1, 0.0D, 0.0D, true, false, false, false),
			CaelumBlocks.AERRACK.getDefaultState(), Blocks.WATER.getDefaultState(), -10, -10, 0, false);

	public static void register() {
		Registry.register(BuiltinRegistries.CHUNK_GENERATOR_SETTINGS, new Identifier("caelum:caelum"), CHUNK_GENERATOR_SETTINGS);

		DimensionOptionsInvoker.getBASE_DIMENSIONS().add(DIMENSION_OPTIONS);
	}

	public static void onAddRegistryDefaults(MutableRegistry<DimensionType> registry) {
		registry.add(DIMENSION_TYPE_KEY, DIMENSION_TYPE, Lifecycle.stable());
	}

	public static void onAddDefaultDimensions(SimpleRegistry<DimensionOptions> options, Registry<Biome> biomes, Registry<ChunkGeneratorSettings> chunkGeneratorSettings, long seed) {
		if (null == biomes.get(CaelumBiomes.CAELUM_FOREST_KEY.getValue())) {
			// dirty hack
			Registry.register(biomes, CaelumBiomes.CAELUM_FOREST_KEY.getValue(), CaelumBiomes.CAELUM_FOREST);
		}

		if (null == chunkGeneratorSettings.get(RegistryKey.of(Registry.NOISE_SETTINGS_WORLDGEN, new Identifier("caelum:caelum")))) {
			Registry.register(chunkGeneratorSettings, new Identifier("caelum:caelum"), CHUNK_GENERATOR_SETTINGS);
		}

		ChunkGenerator caelumGenerator = new NoiseChunkGenerator(
				new FixedBiomeSource(biomes.get(CaelumBiomes.CAELUM_FOREST_KEY.getValue())),
				seed,
				() -> chunkGeneratorSettings.getOrThrow(CHUNK_GENERATOR_SETTINGS_KEY));

		options.add(DIMENSION_OPTIONS, new DimensionOptions(() -> DIMENSION_TYPE, caelumGenerator), Lifecycle.stable());
	}
}
