package fluff.fluffsstuff.item;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent COOKIE = new FoodComponent.Builder()
            .hunger(3).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 250, 2), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 350, 4), 0.10f)
            .build();
}
