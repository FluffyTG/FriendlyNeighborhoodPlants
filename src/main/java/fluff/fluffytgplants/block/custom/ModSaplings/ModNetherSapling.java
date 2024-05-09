package fluff.fluffytgplants.block.custom.ModSaplings;

import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ModNetherSapling extends SaplingBlock {
    public static final IntProperty STAGE = Properties.STAGE;
    protected static final float field_31236 = 6.0f;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 12.0, 14.0);
    private final SaplingGenerator generator;
    private final RegistryKey<ConfiguredFeature<?, ?>> featureKey;


    public ModNetherSapling(SaplingGenerator generator, Settings settings, RegistryKey<ConfiguredFeature<?, ?>> featureKey) {
        super(generator, settings);
        this.generator = generator;
        this.featureKey = featureKey;
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(STAGE, 0));
    }
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.NETHERRACK) || super.canPlantOnTop(floor, world, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return super.canPlaceAt(state, world, pos)
                || (world.getBlockState(pos.down(1)).isOf(Blocks.NETHERRACK))
                || (world.getBlockState(pos.down(1)).isOf(Blocks.BEDROCK))
                || (world.getBlockState(pos.down(1)).isOf(Blocks.WARPED_NYLIUM))
                || (world.getBlockState(pos.down(1)).isOf(Blocks.CRIMSON_NYLIUM));
    }

    @Override
    public BlockState getAppearance(BlockState state, BlockRenderView renderView, BlockPos pos, Direction side, @Nullable BlockState sourceState, @Nullable BlockPos sourcePos) {
        return super.getAppearance(state, renderView, pos, side, sourceState, sourcePos);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (world.getLightLevel(pos.up(5)) <= 9 && random.nextInt(7) == 0) {
            this.generate(world, pos, state, random);
        }
    }
    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return (double)random.nextFloat() < 0.4;
    }

    private Optional<? extends RegistryEntry<ConfiguredFeature<?, ?>>> getFeatureEntry(WorldView world) {
        return world.getRegistryManager().get(RegistryKeys.CONFIGURED_FEATURE).getEntry(this.featureKey);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        this.getFeatureEntry(world).ifPresent(featureEntry -> (featureEntry.value()).generate(world, world.getChunkManager().getChunkGenerator(), random, pos));
    }
}
