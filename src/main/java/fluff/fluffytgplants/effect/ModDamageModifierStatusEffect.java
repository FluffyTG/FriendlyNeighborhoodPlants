package fluff.fluffytgplants.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.DamageModifierStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class ModDamageModifierStatusEffect extends DamageModifierStatusEffect {
    public final double modifier;

    public ModDamageModifierStatusEffect(StatusEffectCategory category, int color, double modifier) {
        super(category, color, modifier);
        this.modifier = modifier;
    }

    @Override
    public double adjustModifierAmount(int amplifier, EntityAttributeModifier modifier) {
        return this.modifier * (double)(amplifier + 1);
    }
}
