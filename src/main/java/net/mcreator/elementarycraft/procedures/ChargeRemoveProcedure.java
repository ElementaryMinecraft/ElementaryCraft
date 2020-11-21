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
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure ChargeRemove!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure ChargeRemove!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure ChargeRemove!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure ChargeRemove!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double kc = 0;
		double ix = 0;
		double iy = 0;
		double iz = 0;
		double ni = 0;
		double qc = 0;
		double dE = 0;
		double rEx = 0;
		double rEy = 0;
		double rEz = 0;
		double rx = 0;
		double ry = 0;
		double rz = 0;
		double nn = 0;
		double Em = 0;
		kc = (double) 2;
		Em = (double) 0.4;
		qc = (double) (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "charge"));
		ni = (double) 4;
		nn = (double) (((ni) * 2) + 1);
		rEx = (double) 0;
		rEy = (double) 0;
		rEz = (double) 0;
		ix = (double) (ni);
		for (int index0 = 0; index0 < (int) ((nn)); index0++) {
			iy = (double) (ni);
			for (int index1 = 0; index1 < (int) ((nn)); index1++) {
				iz = (double) (ni);
				for (int index2 = 0; index2 < (int) ((nn)); index2++) {
					if ((((iz) != 0) || (((iy) != 0) || ((ix) != 0)))) {
						if ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (x + (ix)), (int) (y + (iy)), (int) (z + (iz))))).getBlock()))) {
							rx = (double) (x + (ix));
							ry = (double) (y + (iy));
							rz = (double) (z + (iz));
							dE = (double) (((kc) * ((qc) * (new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) (rx), (int) (ry), (int) (rz)), "charge"))))
									/ Math.pow(((Math.pow((ix), 2) + Math.pow((iy), 2)) + Math.pow((iz), 2)), 1.5));
							rEx = (double) ((new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) (rx), (int) (ry), (int) (rz)), "ex")) - ((dE) * (ix)));
							rEy = (double) ((new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) (rx), (int) (ry), (int) (rz)), "ey")) - ((dE) * (iy)));
							rEz = (double) ((new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) (rx), (int) (ry), (int) (rz)), "ez")) - ((dE) * (iz)));
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) (rx), (int) (ry), (int) (rz));
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("ex", (rEx));
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) (rx), (int) (ry), (int) (rz));
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("ey", (rEy));
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) (rx), (int) (ry), (int) (rz));
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("ez", (rEz));
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
							if (((Math.abs((rEx)) >= (Em)) || ((Math.abs((rEy)) >= (Em)) || (Math.abs((rEz)) >= (Em))))) {
								if (!world.getWorld().isRemote) {
									BlockPos _bp = new BlockPos((int) (rx), (int) (ry), (int) (rz));
									TileEntity _tileEntity = world.getTileEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_tileEntity != null)
										_tileEntity.getTileData().putBoolean("move", (true));
									world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
								}
							} else {
								if (!world.getWorld().isRemote) {
									BlockPos _bp = new BlockPos((int) (rx), (int) (ry), (int) (rz));
									TileEntity _tileEntity = world.getTileEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_tileEntity != null)
										_tileEntity.getTileData().putBoolean("move", (false));
									world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
								}
							}
						}
					}
					iz = (double) ((iz) - 1);
				}
				iy = (double) ((iy) - 1);
			}
			ix = (double) ((ix) - 1);
		}
	}
}
