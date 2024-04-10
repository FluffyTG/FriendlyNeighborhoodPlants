package fluff.fluffsstuff.block;

import fluff.fluffsstuff.FluffsStuff;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static net.minecraft.item.Items.register;

public class ModBlocks
{
    public static  final Block TOKEN_BLOCK = registerBlock("token_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static  final Block SAPPHIRE_GEM = registerBlock("sapphire_gem",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE)));
    public static final Block CHARRED_LOG = registerBlock("charred_log",
            new PillarBlock(AbstractBlock.Settings.create().strength(4.0f).sounds(BlockSoundGroup.WOOD)));
    public static final Block CHARRED_LOG_STRIPPED = registerBlock("charred_log_stripped",
            new PillarBlock(AbstractBlock.Settings.create().strength(4.0f).sounds(BlockSoundGroup.WOOD)));
    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(FluffsStuff.MOD_ID, name), block);
    }
    private  static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(Registries.ITEM, new Identifier(FluffsStuff.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks()
        {
            FluffsStuff.LOGGER.info("Registering Blocks for " + FluffsStuff.MOD_ID);
        }
}
