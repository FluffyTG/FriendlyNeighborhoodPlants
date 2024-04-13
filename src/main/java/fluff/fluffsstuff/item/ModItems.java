package fluff.fluffsstuff.item;

import fluff.fluffsstuff.FluffsStuff;
import fluff.fluffsstuff.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
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
    public static final Item TOBACCO_LEAF_CURED = registerItem("tobacco_leaf_cured", new Item(new FabricItemSettings()));

    public static final Item CANNABIS_SEEDS = registerItem("cannabis_seeds", new AliasedBlockItem(ModBlocks.CANNABIS_CROP, new FabricItemSettings()));
    public static final Item CANNABIS = registerItem("cannabis", new Item(new FabricItemSettings()));


    public static final Item SAPPHIRE_TEMP_PICK = registerItem("sapphire_temppick",
            new PickaxeItem(ModToolMaterial.SAPPHIRE, 2, 2f, new FabricItemSettings()));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(SMILE_TOKEN);
        entries.add(FROWN_TOKEN);
        entries.add(SAPPHIRE);
        entries.add(SAPPHIRE_HEAD_PICK);
        entries.add(TOBACCO_LEAF);
        entries.add(TOBACCO_LEAF_CURED);
        entries.add(TOBACCO_SEEDS);
        entries.add(CANNABIS_SEEDS);
        entries.add(CANNABIS);
    }


    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(FluffsStuff.MOD_ID, name), item);
    }
    public static void registerModItems()
    {
        FluffsStuff.LOGGER.info("Registering Mod Items for " + FluffsStuff.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
