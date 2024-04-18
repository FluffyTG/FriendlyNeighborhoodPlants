package fluff.fluffsstuff.item;

import fluff.fluffsstuff.FluffsStuff;
import fluff.fluffsstuff.block.ModBlocks;
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
        new Identifier(FluffsStuff.MOD_ID, "smiletoken"),
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

                    entries.add(ModItems.TOBACCO_SEEDS);
                    entries.add(ModItems.TOBACCO_LEAF);
                    entries.add(ModItems.TOBACCO_LEAF_CURED);
                    entries.add(ModItems.MOIST_TOBACCO_LEAF_CURED);
                    entries.add(ModItems.CRUSHED_TOBACCO);
                    entries.add(ModItems.TOBACCO_STICK);

                    entries.add(ModItems.CANNABIS_SEEDS);
                    entries.add(ModItems.CANNABIS);
                    entries.add(ModItems.COOKIE);

                    entries.add(ModItems.TOMATO_SEEDS);
                    entries.add(ModItems.TOMATO);

                    entries.add(ModItems.CORN_SEEDS);
                    entries.add(ModItems.CORN);

                    entries.add(ModItems.SAPPHIRE_HEAD_PICK);
                    entries.add(ModItems.SAPPHIRE_TEMP_PICK);



                    entries.add(ModBlocks.CHARRED_LOG);
                    entries.add(ModBlocks.CHARRED_LOG_STRIPPED);
                }).build());
    public static void registerItemGroups()
    {
        FluffsStuff.LOGGER.info("Registering Item Groups for " + FluffsStuff.MOD_ID);
}
}
