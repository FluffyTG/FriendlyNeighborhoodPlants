package fluff.fluffytgplants.sound;

import fluff.fluffytgplants.FNPlants;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent COUGHING_FIT = registerSoundEvent("coughing_fit");

    private  static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(FNPlants.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        FNPlants.LOGGER.info("Registering Sounds for " + FNPlants.MOD_ID);
    }
}
