package fluff.fluffsstuff.item.custom;

import fluff.fluffsstuff.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.sound.Sound;
import net.minecraft.client.sound.SoundSystem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;

public class CrushedTobaccoItem extends Item
{
    public CrushedTobaccoItem (Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            BlockState state = context.getWorld().getBlockState(positionClicked);

            if(isHardBlock(state)) {
                foundBlock = true;

                if (player.getStackInHand(Hand.MAIN_HAND).isOf(ModItems.MOIST_TOBACCO_LEAF_CURED)) {
                    player.getStackInHand(Hand.MAIN_HAND).decrement(1);
                    player.playSound(SoundEvents.BLOCK_ANCIENT_DEBRIS_BREAK, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                    player.giveItemStack(ModItems.CRUSHED_TOBACCO.getDefaultStack());
                    player.addExperience(1);
                }

            }
        }


        return ActionResult.SUCCESS;
    }

    private boolean isHardBlock(BlockState state) {
        return state.isOf(Blocks.STONE);
    }

    protected ItemStack fill(ItemStack stack, PlayerEntity player, ItemStack outputStack) {
        player.incrementStat(Stats.USED.getOrCreateStat(this));
        return ItemUsage.exchangeStack(stack, player, outputStack);
    }
}
