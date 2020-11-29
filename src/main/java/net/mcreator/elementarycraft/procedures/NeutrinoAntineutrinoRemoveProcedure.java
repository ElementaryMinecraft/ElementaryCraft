package net.mcreator.elementarycraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.BlockState;

import net.mcreator.elementarycraft.block.NeutrinoBlock;
import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.Map;
import java.util.HashMap;

@ElementaryCraftModElements.ModElement.Tag
public class NeutrinoAntineutrinoRemoveProcedure extends ElementaryCraftModElements.ModElement {
	public NeutrinoAntineutrinoRemoveProcedure(ElementaryCraftModElements instance) {
		super(instance, 108);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure NeutrinoAntineutrinoRemove!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure NeutrinoAntineutrinoRemove!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure NeutrinoAntineutrinoRemove!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure NeutrinoAntineutrinoRemove!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "neighbour")) != 0)) {
			if ((((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "neighbour")) == 1)
					&& ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)))
							.getMaterial() == net.minecraft.block.material.Material.AIR))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == NeutrinoBlock.block.getDefaultState().getBlock())) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("tickCounter", 0);
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					CheckNeutrinoAntineutrinoNgbrProcedure.executeProcedure($_dependencies);
				}
			} else if ((((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "neighbour")) == (-1))
					&& ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z)))
							.getMaterial() == net.minecraft.block.material.Material.AIR))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == NeutrinoBlock.block.getDefaultState().getBlock())) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("tickCounter", 0);
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					CheckNeutrinoAntineutrinoNgbrProcedure.executeProcedure($_dependencies);
				}
			} else if ((((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "neighbour")) == 2)
					&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z)))
							.getMaterial() == net.minecraft.block.material.Material.AIR))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == NeutrinoBlock.block.getDefaultState().getBlock())) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("tickCounter", 0);
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					CheckNeutrinoAntineutrinoNgbrProcedure.executeProcedure($_dependencies);
				}
			} else if ((((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "neighbour")) == (-2))
					&& ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)))
							.getMaterial() == net.minecraft.block.material.Material.AIR))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == NeutrinoBlock.block.getDefaultState().getBlock())) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("tickCounter", 0);
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					CheckNeutrinoAntineutrinoNgbrProcedure.executeProcedure($_dependencies);
				}
			} else if ((((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "neighbour")) == 3)
					&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
							.getMaterial() == net.minecraft.block.material.Material.AIR))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == NeutrinoBlock.block.getDefaultState().getBlock())) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("tickCounter", 0);
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					CheckNeutrinoAntineutrinoNgbrProcedure.executeProcedure($_dependencies);
				}
			} else if ((((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "neighbour")) == (-3))
					&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1))))
							.getMaterial() == net.minecraft.block.material.Material.AIR))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("neighbour", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == NeutrinoBlock.block.getDefaultState().getBlock())) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("tickCounter", 0);
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("world", world);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					CheckNeutrinoAntineutrinoNgbrProcedure.executeProcedure($_dependencies);
				}
			}
		}
	}
}
