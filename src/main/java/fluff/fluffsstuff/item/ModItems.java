package fluff.fluffsstuff.item;

import fluff.fluffsstuff.FluffsStuff;
import fluff.fluffsstuff.block.ModBlocks;
import fluff.fluffsstuff.item.custom.MoistTobaccoItem;
import fluff.fluffsstuff.item.custom.DriedTobaccoLeafItem;
import fluff.fluffsstuff.item.custom.TobaccoStickItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems
{
    public static final Item SMILE_TOKEN = registerItem("smiletoken", new Item(new FabricItemSettings()));
    public static final Item FROWN_TOKEN = registerItem("frowntoken", new Item(new FabricItemSettings()));
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new FabricItemSettings()));
    public static final Item SAPPHIRE_HEAD_PICK = registerItem("sapphire_head_pick", new Item(new FabricItemSettings()));
    public static final Item TOBACCO_SEEDS = registerItem("tobacco_seeds", new AliasedBlockItem(ModBlocks.TOBACCO_CROP, new FabricItemSettings()));
    public static final Item TOBACCO_LEAF = registerItem("tobacco_leaf", new Item(new FabricItemSettings()));
    public static final Item TOBACCO_LEAF_CURED = registerItem("tobacco_leaf_cured", new DriedTobaccoLeafItem(new FabricItemSettings()));
    public static final Item MOIST_TOBACCO_LEAF_CURED = registerItem("moist_tobacco_leaf_cured", new MoistTobaccoItem(new FabricItemSettings()));
    public static final Item CRUSHED_TOBACCO = registerItem("crushed_tobacco", new Item(new FabricItemSettings()));

    public static final Item CANNABIS_SEEDS = registerItem("cannabis_seeds", new AliasedBlockItem(ModBlocks.CANNABIS_CROP, new FabricItemSettings()));
    public static final Item CANNABIS = registerItem("cannabis", new Item(new FabricItemSettings()));
    public static final Item COOKIE = registerItem("cookie", new Item(new FabricItemSettings().food(ModFoodComponents.COOKIE)));
    public static final Item TOBACCO_STICK = registerItem("tobacco_stick", new TobaccoStickItem(new FabricItemSettings().maxDamage(3)));

    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds", new AliasedBlockItem(ModBlocks.TOMATO_CROP, new FabricItemSettings()));
    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings()));

    public static final Item CORN_SEEDS = registerItem("corn_seeds", new AliasedBlockItem(ModBlocks.CORN_CROP, new FabricItemSettings()));
    public static final Item CORN = registerItem("corn", new Item(new FabricItemSettings()));

    public static final Item SAPPHIRE_TEMP_PICK = registerItem("sapphire_temppick",
            new PickaxeItem(ModToolMaterial.SAPPHIRE, 2, 2f, new FabricItemSettings()));


    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(FluffsStuff.MOD_ID, name), item);
    }
    public static void registerModItems()
    {
        FluffsStuff.LOGGER.info("Registering Mod Items for " + FluffsStuff.MOD_ID);
    }
}
