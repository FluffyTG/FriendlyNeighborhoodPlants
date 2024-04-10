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
        FabricItemGroup.builder().displayName(Text.translatable("itemgroup.token"))
                .icon(() -> new ItemStack(ModItems.SMILE_TOKEN)).entries((displayContext, entries) ->
                {
                    entries.add(ModItems.SMILE_TOKEN);
                    entries.add(ModItems.FROWN_TOKEN);

                    entries.add(ModBlocks.TOKEN_BLOCK);
                    entries.add(ModBlocks.SAPPHIRE_GEM);
                    entries.add(ModBlocks.CHARRED_LOG);
                }).build());
    public static void registerItemGroups()
    {
        FluffsStuff.LOGGER.info("Registering Item Groups for " + FluffsStuff.MOD_ID);
}
}
