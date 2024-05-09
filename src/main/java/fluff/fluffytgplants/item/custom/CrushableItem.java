package fluff.fluffytgplants.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class CrushableItem
        extends Item
{
    private final Item output;
    private final int outputAmount;
    private final int experience;
    public CrushableItem(Item output, int outputAmount, int experience, Item.Settings settings) {
        super(settings);
        this.output = output;
        this.outputAmount = outputAmount;
        this.experience = experience;
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            BlockState state = context.getWorld().getBlockState(positionClicked);

            if(isHardBlock(state)) {

                assert player != null;
                if (player.getStackInHand(Hand.MAIN_HAND).isOf(this)) {

                    player.getStackInHand(Hand.MAIN_HAND).decrement(1);
                    player.playSound(SoundEvents.BLOCK_ANCIENT_DEBRIS_BREAK, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                    player.giveItemStack(new ItemStack(this.getOutput(), getOutputAmount()));

                    Random experienceRandom = new Random();
                    int expAmt = experienceRandom.nextInt(getExperience() + 1);

                    player.addExperience(expAmt);

                    return ActionResult.SUCCESS;

                }

            }
        }


        return ActionResult.FAIL;
    }

    private boolean isHardBlock(BlockState state) {
        return state.isOf(Blocks.STONE);
    }

    public Item getOutput() {
        return this.output;
    }
    public int getOutputAmount() {
        return this.outputAmount;
    }
    public int getExperience() {
        return this.experience;
    }
    public ItemStack getItemStack() {
        return this.output.getDefaultStack();
    }
}
