package fluff.fluffsstuff.block.custom.ModCrops;

import fluff.fluffsstuff.block.ModBlocks;
import fluff.fluffsstuff.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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

public class CornCropBlock extends CropBlock
{
    public static final int FIRST_STAGE_MAX_AGE = 6;
    public static final int SECOND_STAGE_MAX_AGE = 3;
    public static final int THIRD_STAGE_MAX_AGE = 2;

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 12.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 14.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 12.0, 10.0),
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 12.0, 10.0)};



    public static final IntProperty AGE = IntProperty.of("age", 0, 11);

    public CornCropBlock(Settings settings) {
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
            if (currentAge < this.getMaxAge()) {
                float f = getAvailableMoisture(this, world, pos);
                if (random.nextInt((int)(25.0F / f) + 1) == 0) {
                    if(currentAge < 7 && currentAge >= 3) {  // stage 0-6
                        if (world.getBlockState(pos.up(1)).isOf(Blocks.AIR)) {
                            world.setBlockState(pos.up(1), this.withAge(7), 2);
                        } else if (world.getBlockState(pos.up(1)).isOf(ModBlocks.CORN_CROP)) {

                        }
                    }
                    if(currentAge < 10 && currentAge >= 7) { // stage 7-9
                        if (world.getBlockState(pos.up(1)).isOf(Blocks.AIR)) {
                            world.setBlockState(pos.up(1), this.withAge(10), 2);
                        } else if (world.getBlockState(pos.up(1)).isOf(ModBlocks.CORN_CROP)) {

                        }
                    }
                    if ((currentAge < 6) || ((currentAge > 6) && (currentAge <= 10))) {

                        if (currentAge == 9) {
                            world.setBlockState(pos,this.withAge(currentAge));
                        } else {
                            world.setBlockState(pos, this.withAge(currentAge + 1), 2);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int nextAge = this.getAge(state) + this.getGrowthAmount(world);
        int maxAge = this.getMaxAge();

        boolean onSoil = world.getBlockState(pos.down(1)).isOf(Blocks.FARMLAND);
        boolean cornAbove = world.getBlockState(pos.up(1)).isOf(ModBlocks.CORN_CROP);
        boolean cornAbove2 = world.getBlockState(pos.up(2)).isOf(ModBlocks.CORN_CROP);
        boolean cornBelow = world.getBlockState(pos.down(1)).isOf(ModBlocks.CORN_CROP);
        boolean cornBelow2 = world.getBlockState(pos.down(2)).isOf(ModBlocks.CORN_CROP);

        boolean Stage1hasStage2 = cornAbove && onSoil;
        boolean Stage1hasStage3 = cornAbove && cornAbove2;
        boolean Stage2hasStage3 = cornAbove && cornBelow;
        boolean isStage3 = cornBelow && cornBelow2;


        if (nextAge > maxAge) {
            nextAge = maxAge;
        }

        int currentAge = this.getAge(state);

        if(currentAge < 7 && currentAge >= 3) {  // stage 0-6
            if (world.getBlockState(pos.up(1)).isOf(Blocks.AIR)) {
                world.setBlockState(pos.up(1), this.withAge(7), 2);
            } else if (world.getBlockState(pos.up(1)).isOf(ModBlocks.CORN_CROP)) {

            }
        }
        if(currentAge < 10 && currentAge >= 7) { // stage 7-9
            if (world.getBlockState(pos.up(1)).isOf(Blocks.AIR)) {
                world.setBlockState(pos.up(1), this.withAge(10), 2);
            } else if (world.getBlockState(pos.up(1)).isOf(ModBlocks.CORN_CROP)) {

            }
        }
        if ((currentAge < 6) || ((currentAge > 6) && (currentAge <= 10))) {

            if (currentAge == 9) {
                world.setBlockState(pos,this.withAge(currentAge));
            } else {
                world.setBlockState(pos, this.withAge(currentAge + 1), 2);
            }
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
        return ModItems.TOBACCO_SEEDS;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }
    @Override
    public int getMaxAge() {
        return FIRST_STAGE_MAX_AGE + SECOND_STAGE_MAX_AGE + THIRD_STAGE_MAX_AGE;
    }


    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (this.getAge(state) == 6) {
            java.util.Random cornFlowerRNG = new java.util.Random();
            int cornFlowerCount = 1+cornFlowerRNG.nextInt(2);

            player.giveItemStack(new ItemStack(Items.CORNFLOWER, cornFlowerCount));
            player.playSound(SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.NEUTRAL, 0.5f, 3f);
            world.setBlockState(pos, state.with(AGE, 5), Block.NOTIFY_ALL);
        }
        if (this.getAge(state) == 5 || this.getAge(state) == 9) {
            java.util.Random cornRNG = new java.util.Random();
            java.util.Random cornSeedRNG = new java.util.Random();
            int cornCount = 1+cornRNG.nextInt(2);
            int cornSeedCount = cornSeedRNG.nextInt(2);
            int decrementAge = this.getAge(state) - 1;

            player.giveItemStack(new ItemStack(ModItems.CORN, cornCount));
            player.giveItemStack(new ItemStack(ModItems.CORN_SEEDS, cornSeedCount));
            player.playSound(SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.NEUTRAL, 0.5f, 3f);
            world.setBlockState(pos, state.with(AGE, decrementAge), Block.NOTIFY_ALL);
        }

        return ActionResult.success(world.isClient);
    }

}
