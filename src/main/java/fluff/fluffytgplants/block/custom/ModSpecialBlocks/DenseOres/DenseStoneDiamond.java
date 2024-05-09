package fluff.fluffytgplants.block.custom.ModSpecialBlocks.DenseOres;

import fluff.fluffytgplants.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class DenseStoneDiamond extends ExperienceDroppingBlock {
    public DenseStoneDiamond(Settings settings, IntProvider experienceDropped) {
        super(settings, experienceDropped);
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        //randomness value for block coming back
        Random randomChance = new Random();
        int extraChance = randomChance.nextInt(10000);
        if (extraChance % 8 == 0) {
            world.setBlockState(pos, ModBlocks.DENSE_DIAMOND_ORE.getDefaultState(), Block.NOTIFY_ALL);
        }
        else {
            world.setBlockState(pos, Blocks.DIAMOND_ORE.getDefaultState(), Block.NOTIFY_ALL);
        }

        super.onBroken(world, pos, state);
    }

    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        player.incrementStat(Stats.MINED.getOrCreateStat(this));
        player.addExhaustion(0.005f);
        Block.dropStacks(state, world, pos, blockEntity, player, tool);
    }
}
