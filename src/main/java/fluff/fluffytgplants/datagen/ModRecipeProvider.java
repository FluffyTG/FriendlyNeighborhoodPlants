package fluff.fluffytgplants.datagen;

import fluff.fluffytgplants.block.ModBlocks;
import fluff.fluffytgplants.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public static final List<ItemConvertible> TOBACCO_SMELTABLE = List.of((ModItems.TOBACCO_LEAF));
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE, RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_BLOCK);
        offerSmelting(exporter, TOBACCO_SMELTABLE, RecipeCategory.MISC, ModItems.TOBACCO_LEAF_CURED, 1.0f, 400, "tobacco");

    }
}
