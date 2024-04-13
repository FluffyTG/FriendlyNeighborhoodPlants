package fluff.fluffsstuff.datagen;

import fluff.fluffsstuff.block.ModBlocks;
import fluff.fluffsstuff.block.custom.CannabisCropBlock;
import fluff.fluffsstuff.block.custom.TobaccoCropBlock;
import fluff.fluffsstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider
{
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOKEN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);

        blockStateModelGenerator.registerCrop(ModBlocks.TOBACCO_CROP, TobaccoCropBlock.AGE, 0,1,2,3,4);
        blockStateModelGenerator.registerCrop(ModBlocks.CANNABIS_CROP, CannabisCropBlock.AGE, 0,1,2,3,4,5);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SMILE_TOKEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOBACCO_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.CANNABIS, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOBACCO_LEAF_CURED, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_TEMP_PICK, Models.HANDHELD);
    }
}
