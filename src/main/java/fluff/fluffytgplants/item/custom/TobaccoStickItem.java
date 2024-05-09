package fluff.fluffytgplants.item.custom;

import fluff.fluffytgplants.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class TobaccoStickItem extends Item
{
    public TobaccoStickItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        boolean hasSmoked = user.hasStatusEffect(ModEffects.SMOKED);

        if (!hasSmoked) {
            user.playSound(SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.NEUTRAL, 1.0f, 1.0f);
            user.addStatusEffect(new StatusEffectInstance(ModEffects.SMOKED,5000,0));
            user.getItemCooldownManager().set(this,200);
            user.getStackInHand(hand).damage(1, user,
                    new Consumer<PlayerEntity>() {
                        @Override
                        public void accept(PlayerEntity user) {
                            user.sendToolBreakStatus(user.getActiveHand());
                        }});
        }
        else {
            int currentAmplifier = user.getStatusEffect(ModEffects.SMOKED).getAmplifier();

            if (currentAmplifier < 4) {
                user.playSound(SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                user.addStatusEffect(new StatusEffectInstance(ModEffects.SMOKED,(5000 * (currentAmplifier+1)),(currentAmplifier+1)));
                user.getItemCooldownManager().set(this,200);
                user.getStackInHand(hand).damage(1, user,
                        new Consumer<PlayerEntity>() {
                            @Override
                            public void accept(PlayerEntity user) {
                                user.sendToolBreakStatus(user.getActiveHand());
                            }
                        });
            }
            if (currentAmplifier == 4) {
                user.playSound(SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                user.addStatusEffect(new StatusEffectInstance(ModEffects.FRAIL, 12000, 0));
                user.getItemCooldownManager().set(this, 200);
                user.getStackInHand(hand).damage(1, user,
                        new Consumer<PlayerEntity>() {
                            @Override
                            public void accept(PlayerEntity user) {
                                user.sendToolBreakStatus(user.getActiveHand());
                            }
                        });
            }
        }
        return super.use(world, user, hand);
    }
}
