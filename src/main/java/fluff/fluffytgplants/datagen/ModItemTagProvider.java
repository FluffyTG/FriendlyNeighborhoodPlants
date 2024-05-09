package fluff.fluffytgplants.datagen;

import fluff.fluffytgplants.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.CHARRED_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD)
                .add(ModBlocks.CHARRED_PLANKS.asItem())
                .add(ModBlocks.CHARRED_LOG.asItem())
                .add(ModBlocks.CHARRED_LOG_STRIPPED.asItem())
                .add(ModBlocks.CHARRED_WOOD.asItem())
                .add(ModBlocks.CHARRED_WOOD_STRIPPED.asItem());
    }
}
