package reoseah.caelum.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import reoseah.caelum.registry.CaelumBlocks;

public class SkyrootSaplingBlock extends SaplingBlock {
	public SkyrootSaplingBlock(SaplingGenerator generator, Block.Settings settings) {
		super(generator, settings);
	}

	@Override
	protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
		return floor.isIn(CaelumBlocks.SOILS);
	}
}
