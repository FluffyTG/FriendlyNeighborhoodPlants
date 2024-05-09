package fluff.fluffytgplants.datagen;

import fluff.fluffytgplants.block.ModBlocks;
import fluff.fluffytgplants.block.custom.ModCrops.HempCropBlock;
import fluff.fluffytgplants.block.custom.ModCrops.HopsCropBlock;
import fluff.fluffytgplants.block.custom.ModCrops.StrawberryCropBlock;
import fluff.fluffytgplants.block.custom.ModCrops.TomatoCropBlock;
import fluff.fluffytgplants.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public  ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.TOKEN_BLOCK);
        addDrop(ModBlocks.SAPPHIRE_ORE, copperLikeOreDrops(ModBlocks.SAPPHIRE_ORE, ModItems.SAPPHIRE,1,2));
        addDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, copperLikeOreDrops(ModBlocks.SAPPHIRE_ORE, ModItems.SAPPHIRE,1,3));

        addDrop(ModBlocks.DENSE_DIAMOND_ORE, copperLikeOreDrops(ModBlocks.DENSE_DIAMOND_ORE, Items.DIAMOND,1,3));
        addDrop(ModBlocks.DENSE_DEEPSLATE_DIAMOND_ORE, copperLikeOreDrops(ModBlocks.DENSE_DEEPSLATE_DIAMOND_ORE, Items.DIAMOND,1,4));
        
        addDrop(ModBlocks.TOBACCO_FLOWER);
        addDrop(ModBlocks.TRELLIS);
        addPottedPlantDrops(ModBlocks.POTTED_TOBACCO_FLOWER);

        BlockStatePropertyLootCondition.Builder builder1 = BlockStatePropertyLootCondition.builder
                (ModBlocks.HEMP_CROP).properties((StatePredicate.Builder.create()
                .exactMatch(HempCropBlock.AGE, 5)));
        addDrop(ModBlocks.HEMP_CROP,cropDrops(ModBlocks.HEMP_CROP,ModItems.CANNABIS, ModItems.HEMP_SEEDS, builder1));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder
                (ModBlocks.TOMATO_CROP).properties((StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, 5)));
        addDrop(ModBlocks.TOMATO_CROP,cropDrops(ModBlocks.TOMATO_CROP,ModItems.TOMATO, ModItems.TOMATO_SEEDS, builder2));

        BlockStatePropertyLootCondition.Builder builder3 = BlockStatePropertyLootCondition.builder
                (ModBlocks.CORN_CROP).properties((StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, 6)));
        addDrop(ModBlocks.CORN_CROP,cropDrops(ModBlocks.CORN_CROP,ModItems.CORN, ModItems.CORN_SEEDS, builder3));

        BlockStatePropertyLootCondition.Builder builder4 = BlockStatePropertyLootCondition.builder
                (ModBlocks.STRAWBERRY_CROP).properties((StatePredicate.Builder.create()
                .exactMatch(StrawberryCropBlock.AGE, 5)));
        addDrop(ModBlocks.STRAWBERRY_CROP,cropDrops(ModBlocks.STRAWBERRY_CROP,ModItems.STRAWBERRY, ModItems.STRAWBERRY_SEEDS, builder4));

        BlockStatePropertyLootCondition.Builder builder5 = BlockStatePropertyLootCondition.builder
                (ModBlocks.HOPS_CROP).properties((StatePredicate.Builder.create()
                .exactMatch(HopsCropBlock.AGE, 8)));
        addDrop(ModBlocks.HOPS_CROP,cropDrops(ModBlocks.HOPS_CROP,ModItems.HOPS, ModItems.HOPS_SEEDS, builder5));


        addDrop(ModBlocks.CHARRED_WOOD_STRIPPED);
        addDrop(ModBlocks.CHARRED_WOOD);
        addDrop(ModBlocks.CHARRED_PLANKS);
        addDrop(ModBlocks.CHARRED_LEAVES, leavesDrops(ModBlocks.CHARRED_LEAVES, ModBlocks.CHARRED_SAPLING, 0.0025f));
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item, float min, float max) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop,
                (LootPoolEntry.Builder)this.applyExplosionDecay(drop, ((LeafEntry.Builder)
                        ItemEntry.builder(item).apply(SetCountLootFunction.builder
                                (UniformLootNumberProvider.create(min, max))))
                                    .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
