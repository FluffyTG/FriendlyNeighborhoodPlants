package fluff.fluffsstuff.block.custom.ModCrops;

import fluff.fluffsstuff.block.ModBlocks;
import fluff.fluffsstuff.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class HopsCropBlock extends CropBlock
{
    public static final int PROGRESSION_AGE = 3;
    public static  final int MAX_AGE = 8;

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 12.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 14.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0)};



    public static final IntProperty AGE = IntProperty.of("age", 0, 8);

    public HopsCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[this.getAge(state)];
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getBaseLightLevel(pos, 0) >= 9) {
            int currentAge = this.getAge(state);
            if (currentAge <= this.getMaxAge()) {
                float f = getAvailableMoisture(this, world, pos);
                if (random.nextInt((int)(25.0F / f) + 1) == 0) {
                    if(currentAge == MAX_AGE) {
                        if (world.getBlockState(pos.up(1)).isOf(ModBlocks.TRELLIS)) {
                            world.setBlockState(pos.up(1), this.withAge(0), 2);
                        }
                        if (world.getBlockState(pos.up(1)).isOf(ModBlocks.HOPS_CROP)){
                            world.setBlockState(pos.up(1), this.withAge(currentAge+1), 2);
                        }
                    }
                    if(currentAge >= PROGRESSION_AGE) {
                        if (world.getBlockState(pos.up(1)).isOf(ModBlocks.TRELLIS)) {
                            world.setBlockState(pos.up(1), this.withAge(0), 2);
                        } else {
                            world.setBlockState(pos, this.withAge(currentAge + 1), 2);
                        }
                    }
                    else {
                        world.setBlockState(pos, this.withAge(currentAge + 1), 2);
                    }
                }
            }
        }
    }

    @Override
    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int currentAge = this.getAge(state);
        int nextAge = this.getAge(state) + this.getGrowthAmount(world);
        int maxAge = this.getMaxAge();
        if (nextAge > maxAge) {
            nextAge = maxAge;
        }

        if(currentAge >= PROGRESSION_AGE) {
            if (world.getBlockState(pos.up(1)).isOf(ModBlocks.TRELLIS)) {
                world.setBlockState(pos.up(1), this.withAge(nextAge), 2);
            } if (world.getBlockState(pos.up(1)).isOf(ModBlocks.HOPS_CROP)) {
                world.setBlockState(pos, this.withAge(nextAge), 2);
            } else {
                world.setBlockState(pos, this.withAge(nextAge), 2);
            }
        } else {
            world.setBlockState(pos, this.withAge(nextAge), 2);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(AGE);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return super.canPlaceAt(state, world, pos) || (world.getBlockState(pos.down(1)).isOf(this) &&
                world.getBlockState(pos.down(1)).get(AGE) >= 3);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.HOPS_SEEDS;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }
    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (this.getAge(state) == 8) {
            java.util.Random harvestRNG = new java.util.Random();
            java.util.Random seedRNG = new java.util.Random();
            int harvestCount = 1+harvestRNG.nextInt(2);
            int seedCount = seedRNG.nextInt(2);

            player.giveItemStack(new ItemStack(ModItems.HOPS, harvestCount));
            player.giveItemStack(new ItemStack(ModItems.HOPS_SEEDS, seedCount));
            player.playSound(SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.NEUTRAL, 0.5f, 3f);
            world.setBlockState(pos, state.with(AGE, 3), Block.NOTIFY_ALL);
        }

        return ActionResult.success(world.isClient);
    }
}
