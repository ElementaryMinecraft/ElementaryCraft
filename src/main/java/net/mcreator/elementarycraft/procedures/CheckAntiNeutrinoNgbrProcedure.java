package net.mcreator.elementarycraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;

import net.mcreator.elementarycraft.block.AntineutrinoBlock;
import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.Map;

@ElementaryCraftModElements.ModElement.Tag
public class CheckAntiNeutrinoNgbrProcedure extends ElementaryCraftModElements.ModElement {
	public CheckAntiNeutrinoNgbrProcedure(ElementaryCraftModElements instance) {
		super(instance, 69);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure CheckAntiNeutrinoNgbr!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure CheckAntiNeutrinoNgbr!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure CheckAntiNeutrinoNgbr!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure CheckAntiNeutrinoNgbr!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == AntineutrinoBlock.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == AntineutrinoBlock.block.getDefaultState()
						.getBlock()))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("antineutrinoNgbr", (true));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == AntineutrinoBlock.block.getDefaultState()
				.getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == AntineutrinoBlock.block.getDefaultState()
						.getBlock()))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("antineutrinoNgbr", (true));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == AntineutrinoBlock.block.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == AntineutrinoBlock.block.getDefaultState()
						.getBlock()))) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("antineutrinoNgbr", (true));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}