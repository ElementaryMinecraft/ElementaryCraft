package net.mcreator.elementarycraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.BlockState;

import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.Map;

@ElementaryCraftModElements.ModElement.Tag
public class ChargeRemoveProcedure extends ElementaryCraftModElements.ModElement {
	public ChargeRemoveProcedure(ElementaryCraftModElements instance) {
		super(instance, 92);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ChargeRemove!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ChargeRemove!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ChargeRemove!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ChargeRemove!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean qremote = false;
		double kc = 0;
		double ix = 0;
		double iy = 0;
		double iz = 0;
		double ni = 0;
		double distance = 0;
		double qc = 0;
		double dE = 0;
		kc = (double) 2;
		qc = (double) (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "charge"));
		dE = (double) 0;
		ni = (double) 4;
		ix = (double) 0;
		iy = (double) 0;
		iz = (double) 0;
		ix = (double) ((ni) * (-1));
		for (int index0 = 0; index0 < (int) ((((ni) * 2) + 1)); index0++) {
			iy = (double) ((ni) * (-1));
			for (int index1 = 0; index1 < (int) ((((ni) * 2) + 1)); index1++) {
				iz = (double) ((ni) * (-1));
				for (int index2 = 0; index2 < (int) ((((ni) * 2) + 1)); index2++) {
					if ((((iz) != 0) || (((iy) != 0) || ((ix) != 0)))) {
						if ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (x + (ix)), (int) (y + (iy)), (int) (z + (iz))))).getBlock()))) {
							distance = (double) Math.pow(((Math.pow((ix), 2) + Math.pow((iy), 2)) + Math.pow((iz), 2)), 0.5);
							dE = (double) ((kc) / Math.pow((distance), 2));
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) (x + (ix)), (int) (y + (iy)), (int) (z + (iz)));
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("ex", ((new Object() {
										public double getValue(BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(new BlockPos((int) (x + (ix)), (int) (y + (iy)), (int) (z + (iz))), "ex"))
											- (((dE) * (qc)) * ((ix) / (distance)))));
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) (x + (ix)), (int) (y + (iy)), (int) (z + (iz)));
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("ey", ((new Object() {
										public double getValue(BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(new BlockPos((int) (x + (ix)), (int) (y + (iy)), (int) (z + (iz))), "ey"))
											- (((dE) * (qc)) * ((iy) / (distance)))));
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) (x + (ix)), (int) (y + (iy)), (int) (z + (iz)));
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("ez", ((new Object() {
										public double getValue(BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(new BlockPos((int) (x + (ix)), (int) (y + (iy)), (int) (z + (iz))), "ez"))
											- (((dE) * (qc)) * ((iz) / (distance)))));
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						}
					}
					iz = (double) ((iz) + 1);
				}
				iy = (double) ((iy) + 1);
			}
			ix = (double) ((ix) + 1);
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("ex", 0);
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("ey", 0);
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("ez", 0);
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
	}
}
