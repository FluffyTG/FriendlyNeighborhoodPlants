package fluff.fluffsstuff.item.custom;

import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class TobaccoStickItem extends Item
{
    public TobaccoStickItem (Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        boolean hasWeakness = user.hasStatusEffect(StatusEffects.WEAKNESS);

        if (!hasWeakness) {
            user.playSound(SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.NEUTRAL, 1.0f, 1.0f);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,5000,0));
            user.getItemCooldownManager().set(this,200);
            user.getStackInHand(hand).damage(1, user,
                    new Consumer<PlayerEntity>() {
                        @Override
                        public void accept(PlayerEntity user) {
                            user.sendToolBreakStatus(user.getActiveHand());
                        }});

        } else if (user.getStatusEffect(StatusEffects.WEAKNESS).getAmplifier() == 0) {
            user.playSound(SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.NEUTRAL, 1.0f, 1.0f);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,10000,1));
            user.getItemCooldownManager().set(this,200);
            user.getStackInHand(hand).damage(1, user,
                    new Consumer<PlayerEntity>() {
                        @Override
                        public void accept(PlayerEntity user) {
                            user.sendToolBreakStatus(user.getActiveHand());
                        }
                    });
        } else if (user.getStatusEffect(StatusEffects.WEAKNESS).getAmplifier() == 1) {
            user.playSound(SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.NEUTRAL, 1.0f, 1.0f);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,15000,2));
            user.getItemCooldownManager().set(this,200);
            user.getStackInHand(hand).damage(1, user,
                    new Consumer<PlayerEntity>() {
                        @Override
                        public void accept(PlayerEntity user) {
                            user.sendToolBreakStatus(user.getActiveHand());
                        }
                    });
        } else if (user.getStatusEffect(StatusEffects.WEAKNESS).getAmplifier() == 2) {
            user.playSound(SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.NEUTRAL, 1.0f, 1.0f);
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS,20000,3));
            user.getItemCooldownManager().set(this,200);
            user.getStackInHand(hand).damage(1, user,
                    new Consumer<PlayerEntity>() {
                        @Override
                        public void accept(PlayerEntity user) {
                            user.sendToolBreakStatus(user.getActiveHand());
                        }
                    });
        }

        return super.use(world, user, hand);
    }
}
