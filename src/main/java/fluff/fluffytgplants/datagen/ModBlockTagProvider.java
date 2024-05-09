package fluff.fluffytgplants.datagen;

import fluff.fluffytgplants.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider
{
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.INFINIBURN_OVERWORLD)
                .add(ModBlocks.CHARRED_PLANKS)
                .add(ModBlocks.CHARRED_LOG)
                .add(ModBlocks.CHARRED_LOG_STRIPPED)
                .add(ModBlocks.CHARRED_WOOD)
                .add(ModBlocks.CHARRED_WOOD_STRIPPED);
    }
}
