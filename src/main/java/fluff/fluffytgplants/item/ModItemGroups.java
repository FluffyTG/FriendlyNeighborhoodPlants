package fluff.fluffytgplants.item;

import fluff.fluffytgplants.FNPlants;
import fluff.fluffytgplants.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups
{
public static final ItemGroup TOKEN_GROUP = Registry.register(Registries.ITEM_GROUP,
        new Identifier(FNPlants.MOD_ID, "smiletoken"),
        FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fluffsstuff"))
                .icon(() -> new ItemStack(ModItems.SMILE_TOKEN)).entries((displayContext, entries) ->
                {
                    entries.add(ModItems.SMILE_TOKEN);
                    entries.add(ModItems.FROWN_TOKEN);
                    entries.add(ModBlocks.TOKEN_BLOCK);

                    entries.add(ModItems.SAPPHIRE);
                    entries.add(ModBlocks.SAPPHIRE_ORE);
                    entries.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
                    entries.add(ModBlocks.SAPPHIRE_BLOCK);

                    entries.add(ModBlocks.DENSE_DEEPSLATE_DIAMOND_ORE);
                    entries.add(ModBlocks.DENSE_DIAMOND_ORE);

                    entries.add(ModBlocks.TRELLIS);

                    entries.add(ModItems.TOBACCO_SEEDS);
                    entries.add(ModItems.TOBACCO_LEAF);
                    entries.add(ModItems.TOBACCO_LEAF_CURED);
                    entries.add(ModItems.MOIST_TOBACCO_LEAF_CURED);
                    entries.add(ModItems.CRUSHED_TOBACCO);
                    entries.add(ModItems.TOBACCO_STICK);

                    entries.add(ModItems.HEMP_SEEDS);
                    entries.add(ModItems.CANNABIS);
                    entries.add(ModItems.COOKIE);

                    entries.add(ModItems.TOMATO_SEEDS);
                    entries.add(ModItems.TOMATO);

                    entries.add(ModItems.STRAWBERRY_SEEDS);
                    entries.add(ModItems.STRAWBERRY);

                    entries.add(ModItems.CORN_SEEDS);
                    entries.add(ModItems.CORN);



                    entries.add(ModBlocks.CHARRED_SAPLING);
                    entries.add(ModBlocks.CHARRED_LOG);
                    entries.add(ModBlocks.CHARRED_WOOD);
                    entries.add(ModBlocks.CHARRED_LOG_STRIPPED);
                    entries.add(ModBlocks.CHARRED_WOOD_STRIPPED);
                    entries.add(ModBlocks.CHARRED_PLANKS);
                    entries.add(ModBlocks.CHARRED_LEAVES);

                    entries.add(ModItems.SKEWER);

                    entries.add(ModItems.FORK);
                    entries.add(ModItems.SPOON);

                    entries.add(ModItems.BOWL_O_MILK);
                    entries.add(ModItems.BOWL_O_STRAWBERRY);

                    entries.add(ModItems.CEREAL_KITS);
                    entries.add(ModItems.CEREAL_KITS_BOWL);
                    entries.add(ModItems.CEREAL_KITS_MILK);
                    entries.add(ModItems.CEREAL_KITS_STRAWBERRY);

                    entries.add(ModItems.GRITS);
                    entries.add(ModItems.CORNBREAD);
                    entries.add(ModItems.CORN_CHILI_LIME);
                    entries.add(ModItems.CREAMED_CORN);
                    entries.add(ModItems.FUFU);

                    entries.add(ModItems.STRAWBERRY_JAM);
                    entries.add(ModItems.STRAWBERRY_ICE_CREAM);
                    entries.add(ModItems.STRAWBERRY_PARFAIT);
                    entries.add(ModItems.STRAWBERRY_MILK_BUCKET);
                    entries.add(ModItems.CHOCOLATE_STRAWBERRIES);

                    entries.add(ModItems.TOMATO_SALAD);
                    entries.add(ModItems.TOMATO_PUREE);
                    entries.add(ModItems.FRIED_TOMATO);
                    entries.add(ModItems.TOMATO_SOUP);
                    entries.add(ModItems.TOMATO_SKEWER);

                }).build());
    public static void registerItemGroups()
    {
        FNPlants.LOGGER.info("Registering Item Groups for " + FNPlants.MOD_ID);
}
}
