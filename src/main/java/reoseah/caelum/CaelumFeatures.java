package reoseah.caelum;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import reoseah.caelum.features.SkyrootConfig;
import reoseah.caelum.features.SkyrootShrubFeature;
import reoseah.caelum.features.SkyrootTreeFeature;

public class CaelumFeatures {
	public static final Feature<SkyrootConfig> SKYROOT_TREE = new SkyrootTreeFeature(SkyrootConfig.CODEC);
	public static final Feature<SkyrootConfig> SKYROOT_SHRUB = new SkyrootShrubFeature(SkyrootConfig.CODEC);

	public static void register() {
		Registry.register(Registry.FEATURE, "caelum:skyroot_tree", SKYROOT_TREE);
		Registry.register(Registry.FEATURE, "caelum:skyroot_shrub", SKYROOT_SHRUB);

	}
}