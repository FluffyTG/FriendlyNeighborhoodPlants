package fluff.fluffsstuff;

import fluff.fluffsstuff.block.ModBlocks;
import fluff.fluffsstuff.item.ModItemGroups;
import fluff.fluffsstuff.item.ModItems;
import net.fabricmc.api.ModInitializer;

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
	}
}