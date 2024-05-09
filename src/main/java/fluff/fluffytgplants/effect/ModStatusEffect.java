package fluff.fluffytgplants.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.Random;

public class ModStatusEffect extends StatusEffect {
    protected ModStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        if (this == ModEffects.SMOKED) {
            int i = 25 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            }
        }
        if (this == ModEffects.COUGHING_FIT) {
            int i = 25 >> amplifier;
            if (i > 0) {
                return duration % i == 0;
            }
        }
        return this == StatusEffects.HUNGER;
    }

    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
         if (this == ModEffects.COUGHING_FIT) {
             Random randomCough = new Random();
             int coughChance = randomCough.nextInt(200);
             float pitch = randomCough.nextFloat(2);
             if (coughChance <= (2 * (amplifier + 1))) {
                 this.coughHit(entity);
                 return;
             }
        }
        if (this == ModEffects.SMOKED) {
            if (amplifier == 0) {
                entity.addStatusEffect(new StatusEffectInstance(ModEffects.COUGHING_FIT, 300, 0));
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 300, 0));
            }
            else if (amplifier == 1) {
                entity.addStatusEffect(new StatusEffectInstance(ModEffects.COUGHING_FIT, 300, 1));
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 12000, 1));
            }
            else if (amplifier >= 2) {
                entity.addStatusEffect(new StatusEffectInstance(ModEffects.COUGHING_FIT, 300, amplifier));
                if (amplifier > 4) entity.addStatusEffect(new StatusEffectInstance(ModEffects.FRAIL, 300, amplifier-2));
            }
        }
    }

    public void coughHit (LivingEntity entity) {
        //if (ModSounds.COUGHING_FIT != null) entity.playSound(ModSounds.COUGHING_FIT, 1,0);
        entity.damage(entity.getDamageSources().magic(),2f);
    }


}
