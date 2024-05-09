package fluff.fluffytgplants;

import fluff.fluffytgplants.block.ModBlocks;
import fluff.fluffytgplants.effect.ModEffects;
import fluff.fluffytgplants.item.ModItemGroups;
import fluff.fluffytgplants.item.ModItems;
import fluff.fluffytgplants.sound.ModSounds;
import fluff.fluffytgplants.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FNPlants implements ModInitializer {
	public static final String MOD_ID = "fluffytgplants";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();
		ModEffects.registerModEffects();
		ModSounds.registerSounds();

		StrippableBlockRegistry.register(ModBlocks.CHARRED_LOG, ModBlocks.CHARRED_LOG_STRIPPED);
		StrippableBlockRegistry.register(ModBlocks.CHARRED_WOOD, ModBlocks.CHARRED_WOOD_STRIPPED);

	}
}