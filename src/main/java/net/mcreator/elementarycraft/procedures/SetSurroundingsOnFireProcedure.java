package net.mcreator.elementarycraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.elementarycraft.block.SolarPlasmaBlock;
import net.mcreator.elementarycraft.block.HydrogengasBlock;
import net.mcreator.elementarycraft.block.FusionplasmaBlock;
import net.mcreator.elementarycraft.block.DenseHydrogenBlock;
import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.Map;

@ElementaryCraftModElements.ModElement.Tag
public class SetSurroundingsOnFireProcedure extends ElementaryCraftModElements.ModElement {
	public SetSurroundingsOnFireProcedure(ElementaryCraftModElements instance) {
		super(instance, 134);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure SetSurroundingsOnFire!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure SetSurroundingsOnFire!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure SetSurroundingsOnFire!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure SetSurroundingsOnFire!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putBoolean("fire", (false));
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if ((new Object() {
			public boolean getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "fire"))) {
			if (((!((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == SolarPlasmaBlock.block.getDefaultState()
					.getBlock()))
					&& (!((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == FusionplasmaBlock.block.getDefaultState()
							.getBlock())))) {
				if (((!((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == HydrogengasBlock.block.getDefaultState()
						.getBlock()))
						&& (!((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == DenseHydrogenBlock.block
								.getDefaultState().getBlock())))) {
					world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), Blocks.FIRE.getDefaultState(), 3);
				}
			}
			if (((!((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == SolarPlasmaBlock.block.getDefaultState()
					.getBlock()))
					&& (!((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == FusionplasmaBlock.block.getDefaultState()
							.getBlock())))) {
				if (((!((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == HydrogengasBlock.block.getDefaultState()
						.getBlock()))
						&& (!((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == DenseHydrogenBlock.block
								.getDefaultState().getBlock())))) {
					world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), Blocks.FIRE.getDefaultState(), 3);
				}
			}
			if (((!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == SolarPlasmaBlock.block.getDefaultState()
					.getBlock()))
					&& (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == FusionplasmaBlock.block.getDefaultState()
							.getBlock())))) {
				if (((!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == HydrogengasBlock.block.getDefaultState()
						.getBlock()))
						&& (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == DenseHydrogenBlock.block
								.getDefaultState().getBlock())))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), Blocks.FIRE.getDefaultState(), 3);
				}
			}
			if (((!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == SolarPlasmaBlock.block.getDefaultState()
					.getBlock()))
					&& (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == FusionplasmaBlock.block.getDefaultState()
							.getBlock())))) {
				if (((!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == HydrogengasBlock.block.getDefaultState()
						.getBlock()))
						&& (!((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == DenseHydrogenBlock.block
								.getDefaultState().getBlock())))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), Blocks.FIRE.getDefaultState(), 3);
				}
			}
		}
	}
}
