package fluff.fluffytgplants.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent COOKIE = new FoodComponent.Builder()
            .hunger(3).saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 250, 2), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 350, 4), 0.10f)
            .build();
    public static final FoodComponent TOMATO = new FoodComponent.Builder()
            .hunger(1).saturationModifier(0.2f)
            .build();

    public static final FoodComponent TOMATO_SOUP = new FoodComponent.Builder()
            .hunger(3).saturationModifier(0.6f)
            .build();
    public static final FoodComponent TOMATO_PUREE = new FoodComponent.Builder()
            .hunger(5).saturationModifier(0.4f)
            .build();
    public static final FoodComponent FRIED_TOMATO = new FoodComponent.Builder()
            .hunger(2).saturationModifier(0.3f)
            .build();
    public static final FoodComponent TOMATO_SALAD = new FoodComponent.Builder()
            .hunger(3).saturationModifier(0.4f)
            .build();

    public static final FoodComponent FUFU = new FoodComponent.Builder()
            .hunger(6).saturationModifier(0.8f)
            .build();
    public static final FoodComponent CREAMED_CORN = new FoodComponent.Builder()
            .hunger(5).saturationModifier(0.6f)
            .build();
    public static final FoodComponent CHILI_LIME_CORN = new FoodComponent.Builder()
            .hunger(4).saturationModifier(0.2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 30, 0),0.45f)
            .build();
    public static final FoodComponent GRITS = new FoodComponent.Builder()
            .hunger(3).saturationModifier(0.5f)
            .build();
    public static final FoodComponent CEREAL_KITS_MILK = new FoodComponent.Builder()
            .hunger(7).saturationModifier(0.25f)
            .build();
    public static final FoodComponent CEREAL_KITS_BOWL = new FoodComponent.Builder()
            .hunger(5).saturationModifier(0.2f)
            .build();
    public static final FoodComponent CEREAL_KITS_STRAWBERRY = new FoodComponent.Builder()
            .hunger(6).saturationModifier(0.5f)
            .build();
    public static final FoodComponent CORN = new FoodComponent.Builder()
            .hunger(3).saturationModifier(0.4f)
            .build();
    public static final FoodComponent STRAWBERRY = new FoodComponent.Builder()
            .hunger(2).saturationModifier(0.3f)
            .build();
    public static final FoodComponent HOPS = new FoodComponent.Builder()
            .hunger(1).saturationModifier(0.2f)
            .build();
    public static final FoodComponent ONION = new FoodComponent.Builder()
            .hunger(1).saturationModifier(0.2f)
            .build();
}
