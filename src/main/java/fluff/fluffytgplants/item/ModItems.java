package fluff.fluffytgplants.item;

import fluff.fluffytgplants.FNPlants;
import fluff.fluffytgplants.block.ModBlocks;
import fluff.fluffytgplants.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems
{
    public static final Item SMILE_TOKEN = registerItem("smiletoken", new Item(new FabricItemSettings()));
    public static final Item FROWN_TOKEN = registerItem("frowntoken", new Item(new FabricItemSettings()));
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new FabricItemSettings()));

    public static final Item TOBACCO_SEEDS = registerItem("tobacco_seeds", new AliasedBlockItem(ModBlocks.TOBACCO_CROP, new FabricItemSettings()));
    public static final Item TOBACCO_LEAF = registerItem("tobacco_leaf", new Item(new FabricItemSettings()));
    public static final Item TOBACCO_LEAF_CURED = registerItem("tobacco_leaf_cured", new DriedTobaccoLeafItem(new FabricItemSettings()));
    public static final Item CRUSHED_TOBACCO = registerItem("crushed_tobacco", new Item(new FabricItemSettings()));
    public static final Item MOIST_TOBACCO_LEAF_CURED = registerItem("moist_tobacco_leaf_cured",
            new CrushableItem(ModItems.CRUSHED_TOBACCO, 2, 2, new FabricItemSettings()));
    public static final Item TOBACCO_STICK = registerItem("tobacco_stick", new TobaccoStickItem(new FabricItemSettings().maxDamage(3)));


    public static final Item HEMP_SEEDS = registerItem("hemp_seeds", new AliasedBlockItem(ModBlocks.HEMP_CROP, new FabricItemSettings()));
    public static final Item CANNABIS = registerItem("cannabis", new Item(new FabricItemSettings()));
    public static final Item COOKIE = registerItem("cookie", new Item(new FabricItemSettings().food(ModFoodComponents.COOKIE)));

    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds", new AliasedBlockItem(ModBlocks.TOMATO_CROP, new FabricItemSettings()));
    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));

    public static final Item STRAWBERRY_SEEDS = registerItem("strawberry_seeds", new AliasedBlockItem(ModBlocks.STRAWBERRY_CROP, new FabricItemSettings()));
    public static final Item STRAWBERRY = registerItem("strawberry", new Item(new FabricItemSettings().food(ModFoodComponents.STRAWBERRY)));

    public static final Item HOPS_SEEDS = registerItem("hops_seeds", new AliasedBlockItem(ModBlocks.HOPS_CROP, new FabricItemSettings()));
    public static final Item HOPS = registerItem("hops", new Item(new FabricItemSettings().food(ModFoodComponents.HOPS)));

    public static final Item CORN_SEEDS = registerItem("corn_seeds", new AliasedBlockItem(ModBlocks.CORN_CROP, new FabricItemSettings()));
    public static final Item CORN = registerItem("corn", new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));


    //SKEWERS
    public static final Item SKEWER = registerItem("skewer", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item TOMATO_SKEWER = registerItem("tomato_skewer", new DurabilityFood(new FabricItemSettings()
            .food(ModFoodComponents.TOMATO).maxDamage(4),8, 16, ModItems.SKEWER));

    //FOOD
    public static final Item FORK = registerItem("fork", new Item(new FabricItemSettings()));
    public static final Item SPOON = registerItem("spoon", new Item(new FabricItemSettings()));

    public static final Item BOWL_O_MILK = registerItem("bowl_o_milk", new Item(new FabricItemSettings().food(ModFoodComponents.CORN).recipeRemainder(Items.BOWL)));
    public static final Item BOWL_O_STRAWBERRY = registerItem("bowl_o_strawberry", new Item(new FabricItemSettings().food(ModFoodComponents.CORN).recipeRemainder(Items.BOWL)));

    public static final Item TOMATO_SOUP = registerItem("tomato_soup", new Item(new FabricItemSettings().food(ModFoodComponents.CORN).recipeRemainder(Items.BOWL)));
    public static final Item TOMATO_PUREE = registerItem("tomato_puree", new Item(new FabricItemSettings().food(ModFoodComponents.CORN).recipeRemainder(Items.BOWL)));
    public static final Item TOMATO_SALAD = registerItem("tomato_salad", new Item(new FabricItemSettings().food(ModFoodComponents.CORN).recipeRemainder(Items.BOWL)));
    public static final Item FRIED_TOMATO = registerItem("fried_tomato", new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));

    public static final Item CREAMED_CORN = registerItem("creamed_corn", new Item(new FabricItemSettings().food(ModFoodComponents.CORN).recipeRemainder(Items.BOWL)));
    public static final Item CORNBREAD = registerItem("cornbread", new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));
    public static final Item CORN_CHILI_LIME = registerItem("corn_chili_lime", new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));
    public static final Item FUFU = registerItem("fufu", new Item(new FabricItemSettings().food(ModFoodComponents.CORN).recipeRemainder(Items.BOWL)));
    public static final Item GRITS = registerItem("grits", new Item(new FabricItemSettings().food(ModFoodComponents.CORN).recipeRemainder(Items.BOWL)));
    public static final Item CEREAL_KITS = registerItem("cereal_kits", new Item(new FabricItemSettings()));
    public static final Item CEREAL_KITS_BOWL = registerItem("cereal_kits_bowl",
            new DurabilityFood(new FabricItemSettings().food(ModFoodComponents.CEREAL_KITS_MILK)
                    ,10,20, Items.BOWL));
    public static final Item CEREAL_KITS_MILK = registerItem("cereal_kits_milk",
            new DurabilityFood(new FabricItemSettings().food(ModFoodComponents.CEREAL_KITS_MILK)
                    ,10,20, Items.BOWL));
    public static final Item CEREAL_KITS_STRAWBERRY = registerItem("cereal_kits_strawberry",
            new DurabilityFood(new FabricItemSettings().food(ModFoodComponents.CEREAL_KITS_MILK)
                    ,10,20, Items.BOWL));

    public static final Item CHOCOLATE_STRAWBERRIES = registerItem("chocolate_strawberries", new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));
    public static final Item STRAWBERRY_ICE_CREAM = registerItem("strawberry_ice_cream", new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));
    public static final Item STRAWBERRY_JAM = registerItem("strawberry_jam", new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));
    public static final Item STRAWBERRY_MILK_BUCKET = registerItem("strawberry_milk_bucket", new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));
    public static final Item STRAWBERRY_PARFAIT = registerItem("strawberry_parfait", new Item(new FabricItemSettings().food(ModFoodComponents.CORN)));



    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(FNPlants.MOD_ID, name), item);
    }
    public static void registerModItems()
    {
        FNPlants.LOGGER.info("Registering Mod Items for " + FNPlants.MOD_ID);
    }
}
