package fluff.fluffsstuff.world.gen;

import fluff.fluffsstuff.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SMALL_END_ISLANDS, BiomeKeys.END_MIDLANDS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CHARRED_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RARE_CROPS_PLACED_KEY);
    }
}
