package fluff.fluffytgplants.block.custom.ModCrops;

import fluff.fluffytgplants.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public class StrawberryCropBlock extends CropBlock
{
    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = Properties.AGE_5;

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 4.0, 13.0),
            Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 6.0, 13.0),
            Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 10.0, 13.0),
            Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 14.0, 13.0),
            Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 14.0, 13.0),
            Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 14.0, 13.0)};

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[this.getAge(state)];
    }

    public StrawberryCropBlock(Settings settings) {
        super(settings);
    }


    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.STRAWBERRY_SEEDS;
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
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder)
    {
        builder.add(AGE);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (this.getAge(state) == 5) {
            Random harvestRNG = new Random();
            Random seedRNG = new Random();
            int harvestCount = 1+harvestRNG.nextInt(2);
            int seedCount = seedRNG.nextInt(2);

            for (int i = 1; i <= harvestCount; i++) {
                Block.dropStack(world, pos, ModItems.STRAWBERRY.getDefaultStack());
            }
            for (int i = 0; i <= seedCount; i++) {
                Block.dropStack(world, pos, ModItems.STRAWBERRY_SEEDS.getDefaultStack());
            }

            player.playSound(SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.NEUTRAL, 0.5f, 3f);
            world.setBlockState(pos, state.with(AGE, 3), Block.NOTIFY_ALL);

            return ActionResult.success(world.isClient);
        }

        return ActionResult.FAIL;
    }
}
