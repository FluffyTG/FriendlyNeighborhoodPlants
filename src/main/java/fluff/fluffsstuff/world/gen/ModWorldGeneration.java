package fluff.fluffsstuff.world.gen;

import fluff.fluffsstuff.world.ModOrePlacement;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();
        ModTreeGeneration.generateTrees();
    }
}
