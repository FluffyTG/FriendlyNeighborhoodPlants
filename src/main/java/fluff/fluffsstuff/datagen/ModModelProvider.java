package fluff.fluffsstuff.datagen;

import fluff.fluffsstuff.block.ModBlocks;
import fluff.fluffsstuff.block.custom.ModCrops.StrawberryCropBlock;
import fluff.fluffsstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
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
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TOKEN_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);


        blockStateModelGenerator.registerLog(ModBlocks.CHARRED_LOG).log(ModBlocks.CHARRED_LOG).wood(ModBlocks.CHARRED_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.CHARRED_LOG_STRIPPED).log(ModBlocks.CHARRED_LOG_STRIPPED).wood(ModBlocks.CHARRED_WOOD_STRIPPED);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHARRED_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHARRED_LEAVES);
        blockStateModelGenerator.registerTintableCross(ModBlocks.CHARRED_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRELLIS);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.TOBACCO_FLOWER, ModBlocks.POTTED_TOBACCO_FLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);

        // not used due to
        //blockStateModelGenerator.registerCrop(ModBlocks.TOBACCO_CROP, TobaccoCropBlock.AGE, 0,1,2,3,4);
        //blockStateModelGenerator.registerCrop(ModBlocks.CANNABIS_CROP, CannabisCropBlock.AGE, 0,1,2,3,4,5);
        //blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_CROP, TomatoCropBlock.AGE, 0,1,2,3,4,5);
        //blockStateModelGenerator.registerCrop(ModBlocks.CORN_CROP, CornCropBlock.AGE, 0,1,2,3,4,5,6,7,8,9,10,11);
        blockStateModelGenerator.registerCrop(ModBlocks.STRAWBERRY_CROP, StrawberryCropBlock.AGE, 0,1,2,3,4,5);
        //blockStateModelGenerator.registerCrop(ModBlocks.HOPS_CROP, HopsCropBlock.AGE, 0,1,2,3,4,5,6,7,8);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_TEMP_PICK, Models.HANDHELD);

        itemModelGenerator.register(ModItems.SMILE_TOKEN, Models.GENERATED);

        itemModelGenerator.register(ModItems.TOBACCO_LEAF, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOBACCO_LEAF_CURED, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOIST_TOBACCO_LEAF_CURED, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRUSHED_TOBACCO, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOBACCO_STICK, Models.HANDHELD);

        itemModelGenerator.register(ModItems.CANNABIS, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKIE, Models.GENERATED);

        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);

        itemModelGenerator.register(ModItems.STRAWBERRY, Models.GENERATED);

        itemModelGenerator.register(ModItems.HOPS, Models.GENERATED);

        itemModelGenerator.register(ModItems.CORN, Models.GENERATED);




    }
}
