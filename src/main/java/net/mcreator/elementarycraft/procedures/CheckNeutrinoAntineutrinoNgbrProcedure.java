package net.mcreator.elementarycraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;

import net.mcreator.elementarycraft.block.NeutrinoBlock;
import net.mcreator.elementarycraft.block.AntineutrinoBlock;
import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.Map;

@ElementaryCraftModElements.ModElement.Tag
public class CheckNeutrinoAntineutrinoNgbrProcedure extends ElementaryCraftModElements.ModElement {
	public CheckNeutrinoAntineutrinoNgbrProcedure(ElementaryCraftModElements instance) {
		super(instance, 109);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure CheckNeutrinoAntineutrinoNgbr!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure CheckNeutrinoAntineutrinoNgbr!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure CheckNeutrinoAntineutrinoNgbr!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure CheckNeutrinoAntineutrinoNgbr!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == NeutrinoBlock.block.getDefaultState().getBlock())) {
			if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == AntineutrinoBlock.block.getDefaultState()
					.getBlock()) && ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) (x + 1), (int) y, (int) z), "neighbour")) == 0))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 1);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) (x + 1), (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", (-1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == AntineutrinoBlock.block.getDefaultState()
					.getBlock()) && ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) (x - 1), (int) y, (int) z), "neighbour")) == 0))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", (-1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) (x - 1), (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 1);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == AntineutrinoBlock.block.getDefaultState()
					.getBlock()) && ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) (y + 1), (int) z), "neighbour")) == 0))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 2);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", (-2));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == AntineutrinoBlock.block.getDefaultState()
					.getBlock()) && ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) (y - 1), (int) z), "neighbour")) == 0))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", (-2));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 2);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == AntineutrinoBlock.block.getDefaultState()
					.getBlock()) && ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) (z + 1)), "neighbour")) == 0))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 3);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z + 1));
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", (-3));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == AntineutrinoBlock.block.getDefaultState()
					.getBlock()) && ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) (z - 1)), "neighbour")) == 0))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", (-3));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z - 1));
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 3);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AntineutrinoBlock.block.getDefaultState()
				.getBlock())) {
			if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == NeutrinoBlock.block.getDefaultState().getBlock())
					&& ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) (x + 1), (int) y, (int) z), "neighbour")) == 0))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 1);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) (x + 1), (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", (-1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == NeutrinoBlock.block.getDefaultState()
					.getBlock()) && ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) (x - 1), (int) y, (int) z), "neighbour")) == 0))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", (-1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) (x - 1), (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 1);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == NeutrinoBlock.block.getDefaultState()
					.getBlock()) && ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) (y + 1), (int) z), "neighbour")) == 0))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 2);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) (y + 1), (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", (-2));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == NeutrinoBlock.block.getDefaultState()
					.getBlock()) && ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) (y - 1), (int) z), "neighbour")) == 0))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", (-2));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) (y - 1), (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 2);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == NeutrinoBlock.block.getDefaultState()
					.getBlock()) && ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) (z + 1)), "neighbour")) == 0))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 3);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z + 1));
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", (-3));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == NeutrinoBlock.block.getDefaultState()
					.getBlock()) && ((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) (z - 1)), "neighbour")) == 0))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", (-3));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) (z - 1));
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 3);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
	}
}
