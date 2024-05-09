package fluff.fluffytgplants.block;

import fluff.fluffytgplants.FNPlants;
import fluff.fluffytgplants.block.custom.ModCrops.*;
import fluff.fluffytgplants.block.custom.ModSaplings.ModNetherSapling;
import fluff.fluffytgplants.block.custom.ModSpecialBlocks.DenseOres.DenseDeepslateDiamond;
import fluff.fluffytgplants.block.custom.ModSpecialBlocks.DenseOres.DenseStoneDiamond;
import fluff.fluffytgplants.block.custom.TrellisBlock;
import fluff.fluffytgplants.world.ModConfiguredFeatures;
import fluff.fluffytgplants.world.tree.CharredSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks
{
    public static  final Block TOKEN_BLOCK = registerBlock("token_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static  final Block SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));

    public static  final Block DENSE_DIAMOND_ORE = registerBlock("dense_diamond_ore",
            new DenseStoneDiamond(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).strength(10.10f), UniformIntProvider.create(10,19)));
    public static  final Block DENSE_DEEPSLATE_DIAMOND_ORE = registerBlock("dense_deepslate_diamond_ore",
            new DenseDeepslateDiamond(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).strength(12.12f), UniformIntProvider.create(14,25)));



    public static final Block CHARRED_LOG = registerBlock("charred_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(8f)));
    public static final Block CHARRED_WOOD = registerBlock("charred_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(8f)));
    public static final Block CHARRED_LOG_STRIPPED = registerBlock("charred_log_stripped",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(8f)));
    public static final Block CHARRED_WOOD_STRIPPED = registerBlock("charred_wood_stripped",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(8f)));
    public static  final Block CHARRED_PLANKS = registerBlock("charred_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(10f)));
    public static  final Block CHARRED_LEAVES = registerBlock("charred_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque()));
    public static  final Block CHARRED_SAPLING = registerBlock("charred_sapling",
            new ModNetherSapling(new CharredSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING), ModConfiguredFeatures.CHARRED_KEY));



    public static final Block TRELLIS = registerBlock("trellis",
            new TrellisBlock(AbstractBlock.Settings.create().strength(4.0f).sounds(BlockSoundGroup.WOOD)));

    public static final Block TOBACCO_CROP = Registry.register(Registries.BLOCK, new Identifier(FNPlants.MOD_ID, "tobacco_crop"),
        new TobaccoCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));
    public static  final Block TOBACCO_FLOWER = registerBlock("tobacco_flower",
            new FlowerBlock(StatusEffects.DARKNESS, 30,
                    FabricBlockSettings.copyOf(Blocks.ALLIUM).nonOpaque().noCollision()));
    public static final Block POTTED_TOBACCO_FLOWER = Registry.register(Registries.BLOCK, new Identifier(FNPlants.MOD_ID, "potted_tobacco_flower"),
            new FlowerPotBlock(TOBACCO_FLOWER, FabricBlockSettings.copyOf(Blocks.POTTED_ALLIUM).nonOpaque()));
    public static final Block HEMP_CROP = Registry.register(Registries.BLOCK, new Identifier(FNPlants.MOD_ID, "hemp_crop"),
            new HempCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT).requiresTool().strength(4f,10f)));

    public static final Block TOMATO_CROP = Registry.register(Registries.BLOCK, new Identifier(FNPlants.MOD_ID, "tomato_crop"),
            new TomatoCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block STRAWBERRY_CROP = Registry.register(Registries.BLOCK, new Identifier(FNPlants.MOD_ID, "strawberry_crop"),
            new StrawberryCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block HOPS_CROP = Registry.register(Registries.BLOCK, new Identifier(FNPlants.MOD_ID, "hops_crop"),
            new HopsCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));

    public static final Block CORN_CROP = Registry.register(Registries.BLOCK, new Identifier(FNPlants.MOD_ID, "corn_crop"),
            new CornCropBlock(FabricBlockSettings.copyOf(Blocks.WHEAT)));








    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(FNPlants.MOD_ID, name), block);
    }
    private  static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(Registries.ITEM, new Identifier(FNPlants.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks()
        {
            FNPlants.LOGGER.info("Registering Blocks for " + FNPlants.MOD_ID);
        }
}
