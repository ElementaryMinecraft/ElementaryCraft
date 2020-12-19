package net.mcreator.elementarycraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.IProperty;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.elementarycraft.block.WeakGaugeFieldBlock;
import net.mcreator.elementarycraft.block.UpQuarkFieldBlock;
import net.mcreator.elementarycraft.block.PhotonFieldBlock;
import net.mcreator.elementarycraft.block.NeutrinoQuantumfieldBlock;
import net.mcreator.elementarycraft.block.GluonFieldBlock;
import net.mcreator.elementarycraft.block.ElectronFieldBlock;
import net.mcreator.elementarycraft.block.DownQuarkFieldBlock;
import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.Map;

@ElementaryCraftModElements.ModElement.Tag
public class QFgenerationProcedure extends ElementaryCraftModElements.ModElement {
	public QFgenerationProcedure(ElementaryCraftModElements instance) {
		super(instance, 220);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure QFgeneration!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure QFgeneration!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure QFgeneration!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure QFgeneration!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double xcoord = 0;
		double zcoord = 0;
		double radius = 0;
		double QFtype = 0;
		radius = (double) 5;
		QFtype = (double) (7 * Math.random());
		xcoord = (double) 0;
		for (int index0 = 0; index0 < (int) ((radius)); index0++) {
			zcoord = (double) 0;
			for (int index1 = 0; index1 < (int) ((radius)); index1++) {
				if ((Math.random() < 0.3)) {
					if (((QFtype) < 1)) {
						{
							BlockPos _bp = new BlockPos((int) (x + (xcoord)), (int) y, (int) (z + (zcoord)));
							BlockState _bs = GluonFieldBlock.block.getDefaultState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
								if (_bs.has(_property))
									_bs = _bs.with(_property, (Comparable) entry.getValue());
							}
							world.setBlockState(_bp, _bs, 3);
						}
					} else {
						if (((QFtype) < 2)) {
							{
								BlockPos _bp = new BlockPos((int) (x + (xcoord)), (int) y, (int) (z + (zcoord)));
								BlockState _bs = PhotonFieldBlock.block.getDefaultState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
									if (_bs.has(_property))
										_bs = _bs.with(_property, (Comparable) entry.getValue());
								}
								world.setBlockState(_bp, _bs, 3);
							}
						} else {
							if (((QFtype) < 3)) {
								{
									BlockPos _bp = new BlockPos((int) (x + (xcoord)), (int) y, (int) (z + (zcoord)));
									BlockState _bs = DownQuarkFieldBlock.block.getDefaultState();
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
										if (_bs.has(_property))
											_bs = _bs.with(_property, (Comparable) entry.getValue());
									}
									world.setBlockState(_bp, _bs, 3);
								}
							} else {
								if (((QFtype) < 4)) {
									{
										BlockPos _bp = new BlockPos((int) (x + (xcoord)), (int) y, (int) (z + (zcoord)));
										BlockState _bs = UpQuarkFieldBlock.block.getDefaultState();
										BlockState _bso = world.getBlockState(_bp);
										for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
											IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
											if (_bs.has(_property))
												_bs = _bs.with(_property, (Comparable) entry.getValue());
										}
										world.setBlockState(_bp, _bs, 3);
									}
								} else {
									if (((QFtype) < 5)) {
										{
											BlockPos _bp = new BlockPos((int) (x + (xcoord)), (int) y, (int) (z + (zcoord)));
											BlockState _bs = WeakGaugeFieldBlock.block.getDefaultState();
											BlockState _bso = world.getBlockState(_bp);
											for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
												IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
												if (_bs.has(_property))
													_bs = _bs.with(_property, (Comparable) entry.getValue());
											}
											world.setBlockState(_bp, _bs, 3);
										}
									} else {
										if (((QFtype) < 6)) {
											{
												BlockPos _bp = new BlockPos((int) (x + (xcoord)), (int) y, (int) (z + (zcoord)));
												BlockState _bs = NeutrinoQuantumfieldBlock.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_bs.has(_property))
														_bs = _bs.with(_property, (Comparable) entry.getValue());
												}
												world.setBlockState(_bp, _bs, 3);
											}
										} else {
											{
												BlockPos _bp = new BlockPos((int) (x + (xcoord)), (int) y, (int) (z + (zcoord)));
												BlockState _bs = ElectronFieldBlock.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_bs.has(_property))
														_bs = _bs.with(_property, (Comparable) entry.getValue());
												}
												world.setBlockState(_bp, _bs, 3);
											}
										}
									}
								}
							}
						}
					}
				} else {
					world.setBlockState(new BlockPos((int) (x + (xcoord)), (int) y, (int) (z + (zcoord))), Blocks.AIR.getDefaultState(), 3);
				}
				zcoord = (double) ((zcoord) + 1);
			}
			xcoord = (double) ((xcoord) + 1);
		}
	}
}
