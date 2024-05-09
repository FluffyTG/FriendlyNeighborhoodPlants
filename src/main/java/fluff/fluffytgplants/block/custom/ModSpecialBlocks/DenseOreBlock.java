package fluff.fluffytgplants.block.custom.ModSpecialBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class DenseOreBlock extends ExperienceDroppingBlock {
    public DenseOreBlock(Settings settings, IntProvider experienceDropped) {
        super(settings);
        this.experienceDropped = experienceDropped;
    }
    public final IntProvider experienceDropped;


    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        super.onBroken(world, pos, state);
    }

    @Override
    public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
        return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
    }
}
