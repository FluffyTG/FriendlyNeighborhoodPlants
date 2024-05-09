package fluff.fluffytgplants.effect;

import fluff.fluffytgplants.FNPlants;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final StatusEffect SMOKED = registerEffect("smoked", new ModStatusEffect(StatusEffectCategory.HARMFUL,323452));
    public static final StatusEffect COUGHING_FIT = registerEffect("coughing_fit", new ModStatusEffect(StatusEffectCategory.HARMFUL,7578689));

    public static final StatusEffect FRAIL = registerEffect("frail", new ModDamageModifierStatusEffect(StatusEffectCategory.HARMFUL, 4837293, -8.0).addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "22653B89-116E-49DC-9B6B-9971489B5BE5", 0.0, EntityAttributeModifier.Operation.ADDITION));


    private static StatusEffect registerEffect (String name, StatusEffect effect)
    {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(FNPlants.MOD_ID, name), effect);
    }
    public static void registerModEffects()
    {
        FNPlants.LOGGER.info("Registering Mod Effects for " + FNPlants.MOD_ID);
    }
}
