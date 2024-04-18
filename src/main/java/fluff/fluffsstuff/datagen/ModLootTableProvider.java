package fluff.fluffsstuff.datagen;

import fluff.fluffsstuff.block.ModBlocks;
import fluff.fluffsstuff.block.custom.CannabisCropBlock;
import fluff.fluffsstuff.block.custom.TobaccoCropBlock;
import fluff.fluffsstuff.block.custom.TomatoCropBlock;
import fluff.fluffsstuff.item.ModItems;
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
        addDrop(ModBlocks.TOBACCO_FLOWER);
        addPottedPlantDrops(ModBlocks.POTTED_TOBACCO_FLOWER);

        BlockStatePropertyLootCondition.Builder builder1 = BlockStatePropertyLootCondition.builder
                (ModBlocks.CANNABIS_CROP).properties((StatePredicate.Builder.create()
                .exactMatch(CannabisCropBlock.AGE, 5)));
        addDrop(ModBlocks.CANNABIS_CROP,cropDrops(ModBlocks.CANNABIS_CROP,ModItems.CANNABIS, ModItems.CANNABIS_SEEDS, builder1));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder
                (ModBlocks.TOMATO_CROP).properties((StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, 5)));
        addDrop(ModBlocks.TOMATO_CROP,cropDrops(ModBlocks.TOMATO_CROP,ModItems.TOMATO, ModItems.TOMATO_SEEDS, builder2));

        BlockStatePropertyLootCondition.Builder builder3 = BlockStatePropertyLootCondition.builder
                (ModBlocks.CORN_CROP).properties((StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, 6)));
        addDrop(ModBlocks.CORN_CROP,cropDrops(ModBlocks.CORN_CROP,ModItems.CORN, ModItems.CORN_SEEDS, builder3));
    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item, float min, float max) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop,
                (LootPoolEntry.Builder)this.applyExplosionDecay(drop, ((LeafEntry.Builder)
                        ItemEntry.builder(item).apply(SetCountLootFunction.builder
                                (UniformLootNumberProvider.create(min, max))))
                                    .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
