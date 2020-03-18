package reoseah.skyland.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.IWorld;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;

public class SkyGrassBlock extends Block {
	public static final BooleanProperty SNOWY = Properties.SNOWY;

	public SkyGrassBlock(Block.Settings settings) {
		super(settings);
		this.setDefaultState(this.stateManager.getDefaultState().with(SNOWY, false));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(SNOWY);
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		Block block = ctx.getWorld().getBlockState(ctx.getBlockPos().up()).getBlock();
		return this.getDefaultState().with(SNOWY, block == Blocks.SNOW_BLOCK || block == Blocks.SNOW);
	}

	public BlockState getStateForNeighborUpdate(BlockState state, Direction facing, BlockState neighborState, IWorld world, BlockPos pos, BlockPos neighborPos) {

		if (facing == Direction.UP) {
			Block block = neighborState.getBlock();
			return state.with(SNOWY, block == Blocks.SNOW_BLOCK || block == Blocks.SNOW);
		}
		return state;
	}


	private static boolean canSurvive(BlockState state, WorldView view, BlockPos pos) {
		BlockPos posAbove = pos.up();
		BlockState stateAbove = view.getBlockState(posAbove);
		if (stateAbove.getBlock() == Blocks.SNOW && stateAbove.get(SnowBlock.LAYERS) == 1) {
			return true;
		}
		int i = ChunkLightProvider.getRealisticOpacity(view, state, pos, stateAbove, posAbove, Direction.UP, stateAbove.getOpacity(view, posAbove));
		return i < view.getMaxLightLevel();
	}

	private static boolean canSpread(BlockState state, WorldView view, BlockPos pos) {
		BlockPos blockPos = pos.up();
		return canSurvive(state, view, pos) && !view.getFluidState(blockPos).matches(FluidTags.WATER);
	}

	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (!canSurvive(state, world, pos)) {
			world.setBlockState(pos, SkyBlocks.SKY_SILT.getDefaultState());
			return;
		}
		if (world.getLightLevel(pos.up()) >= 9) {
			for (int i = 0; i < 4; ++i) {
				BlockPos neighborPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
				if (world.getBlockState(neighborPos).getBlock() == SkyBlocks.SKY_SILT
						&& canSpread(this.getDefaultState(), world, neighborPos)) {
					boolean snowy = world.getBlockState(neighborPos.up()).getBlock() == Blocks.SNOW;
					world.setBlockState(neighborPos, this.getDefaultState().with(SNOWY, snowy));
				}
			}
		}
	}
}