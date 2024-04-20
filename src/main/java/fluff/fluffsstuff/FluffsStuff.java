package fluff.fluffsstuff;

import fluff.fluffsstuff.block.ModBlocks;
import fluff.fluffsstuff.item.ModItemGroups;
import fluff.fluffsstuff.item.ModItems;
import fluff.fluffsstuff.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FluffsStuff implements ModInitializer {
	public static final String MOD_ID = "fluffsstuff";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();

		StrippableBlockRegistry.register(ModBlocks.CHARRED_LOG, ModBlocks.CHARRED_LOG_STRIPPED);
		StrippableBlockRegistry.register(ModBlocks.CHARRED_WOOD, ModBlocks.CHARRED_WOOD_STRIPPED);

	}
}