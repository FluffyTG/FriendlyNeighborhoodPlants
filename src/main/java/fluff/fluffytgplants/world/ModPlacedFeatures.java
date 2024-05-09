package fluff.fluffytgplants.world;

import fluff.fluffytgplants.FNPlants;
import fluff.fluffytgplants.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures
{
    public static final RegistryKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = registerKey("sapphire_ore_placed");
    public static final RegistryKey<PlacedFeature> END_SAPPHIRE_ORE_PLACED_KEY = registerKey("end_sapphire_ore_placed");

    public static final RegistryKey<PlacedFeature> DENSE_DIAMOND_ORE_PLACED_KEY = registerKey("dense_diamond_ore_placed");
    public static final RegistryKey<PlacedFeature> DENSE_DEEPSLATE_DIAMOND_ORE_PLACED_KEY = registerKey("dense_deepslate_diamond_ore_placed");

    public static final RegistryKey<PlacedFeature> CHARRED_PLACED_KEY = registerKey("charred_placed");
    public static final RegistryKey<PlacedFeature> RARE_CROPS_PLACED_KEY = registerKey("rare_crops_placed");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SAPPHIRE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPPHIRE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(12,//veins per chunk))
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(context, END_SAPPHIRE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DEEPSLATE_SAPPHIRE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(12,//veins per chunk))
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, DENSE_DIAMOND_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DENSE_DIAMOND_ORE_KEY),
                ModOrePlacement.modifiersWithCount(24,//veins per chunk))
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(20))));
        register(context, DENSE_DEEPSLATE_DIAMOND_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DENSE_DEEPSLATE_DIAMOND_ORE_KEY),
                ModOrePlacement.modifiersWithCount(24,//veins per chunk))
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(20))));

        register(context, CHARRED_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CHARRED_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2),
                        ModBlocks.CHARRED_SAPLING));
        register(context, RARE_CROPS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RARE_CROPS_KEY),
                VegetationPlacedFeatures.modifiers(1));
    }
    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(FNPlants.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
