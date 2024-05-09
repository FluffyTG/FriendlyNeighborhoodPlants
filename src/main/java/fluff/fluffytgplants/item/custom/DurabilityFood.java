package fluff.fluffytgplants.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DurabilityFood extends Item {
    public int minSpeed;
    public int maxSpeed;
    public Item remainder;
    public boolean hasDurability;
    public DurabilityFood(Settings settings, int minSpeed, int maxSpeed, Item remainder) {
        super(settings);
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.remainder = remainder;
        this.hasDurability = hasDurability;
    }
    public int getMaxUseTime(ItemStack stack) {
        if (stack.getItem().isFood()) {
            return this.getFoodComponent().isSnack() ? minSpeed : maxSpeed;
        }
        return 0;
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (stack.getMaxDamage() > 0) {
            int currentDamage = stack.getDamage();
            if (currentDamage < stack.getMaxDamage()) {
                user.setStackInHand(user.getActiveHand(), new ItemStack(this));
                user.getStackInHand(user.getActiveHand()).setDamage(currentDamage + 1);
                user.eatFood(world, stack);
            } else {
                user.sendToolBreakStatus(user.getActiveHand());
                if (remainder != null) user.setStackInHand(user.getActiveHand(), new ItemStack(remainder));
                user.eatFood(world, stack);
            }
        } else {
            user.eatFood(world, stack);
            user.dropStack(new ItemStack(remainder));
        }
        return stack;
    }

}
