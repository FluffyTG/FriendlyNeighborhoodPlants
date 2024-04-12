package fluff.fluffsstuff;

import fluff.fluffsstuff.datagen.ModLootTableProvider;
import fluff.fluffsstuff.datagen.ModModelProvider;
import fluff.fluffsstuff.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class FluffsStuffDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
