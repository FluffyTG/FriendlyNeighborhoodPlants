package fluff.fluffsstuff.world;

import fluff.fluffsstuff.FluffsStuff;
import fluff.fluffsstuff.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.NoiseThresholdBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures
{
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPPHIRE_ORE_KEY = registerKey("sapphire_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEPSLATE_SAPPHIRE_ORE_KEY = registerKey("deepslate_sapphire_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_DIAMOND_ORE_KEY = registerKey("dense_diamond_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_DEEPSLATE_DIAMOND_ORE_KEY = registerKey("dense_deepslate_diamond_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> CHARRED_KEY = registerKey("charred");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RARE_CROPS_KEY = registerKey("tobacco_flower_key");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        RuleTest diamondStoneReplacables = new BlockMatchRuleTest(Blocks.DIAMOND_ORE);
        RuleTest diamondDeepslateReplacables = new BlockMatchRuleTest(Blocks.DEEPSLATE_DIAMOND_ORE);

        List<OreFeatureConfig.Target> overworldSapphireOre =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.SAPPHIRE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> endSapphireOre =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.SAPPHIRE_BLOCK.getDefaultState()));

        List<OreFeatureConfig.Target> denseDiamondOreOverworld =
                List.of(OreFeatureConfig.createTarget(diamondStoneReplacables, ModBlocks.DENSE_DIAMOND_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> denseDeepslateDiamondOreOverworld =
                List.of(OreFeatureConfig.createTarget(diamondDeepslateReplacables, ModBlocks.DENSE_DEEPSLATE_DIAMOND_ORE.getDefaultState()));


        register(context, SAPPHIRE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldSapphireOre, 12));
        register(context, DEEPSLATE_SAPPHIRE_ORE_KEY, Feature.ORE, new OreFeatureConfig(endSapphireOre, 12));

        register(context, DENSE_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(denseDiamondOreOverworld, 12));
        register(context, DENSE_DEEPSLATE_DIAMOND_ORE_KEY, Feature.ORE, new OreFeatureConfig(denseDeepslateDiamondOreOverworld, 12));

        register(context, CHARRED_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.CHARRED_LOG),
                new StraightTrunkPlacer(5,4,3),

                BlockStateProvider.of(ModBlocks.CHARRED_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),

                new TwoLayersFeatureSize(1,0,2)).build());

        register(context, RARE_CROPS_KEY, Feature.RANDOM_PATCH, new RandomPatchFeatureConfig
                (1, 0, 0, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TOBACCO_FLOWER)),
                        BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.noFluid(),
                                BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), List.of(Blocks.GRASS_BLOCK, Blocks.DIRT /// add more later
                                ))))));


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(FluffsStuff.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
