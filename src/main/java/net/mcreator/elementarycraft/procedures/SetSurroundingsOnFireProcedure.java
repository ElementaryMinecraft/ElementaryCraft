package net.mcreator.elementarycraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.elementarycraft.block.SolarPlasmaBlock;
import net.mcreator.elementarycraft.block.FusionplasmaBlock;
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
		double dx = 0;
		double dy = 0;
		double dz = 0;
		double xdx = 0;
		double ydy = 0;
		double zdz = 0;
		double lavadist = 0;
		double firedist = 0;
		lavadist = (double) 3;
		dx = (double) ((-1) * (lavadist));
		while (((dx) <= (lavadist))) {
			dy = (double) ((-1) * (lavadist));
			while (((dy) <= (lavadist))) {
				dz = (double) ((-1) * (lavadist));
				while (((dz) <= (lavadist))) {
					if ((Math.sqrt((Math.pow((dx), 2) + (Math.pow((dy), 2) + Math.pow((dz), 2)))) <= (lavadist))) {
						xdx = (double) (x + (dx));
						ydy = (double) (y + (dy));
						zdz = (double) (z + (dz));
						if ((((world.getBlockState(new BlockPos((int) (xdx), (int) (ydy), (int) (zdz))))
								.getMaterial() == net.minecraft.block.material.Material.ROCK)
								|| ((world.getBlockState(new BlockPos((int) (xdx), (int) (ydy), (int) (zdz))))
										.getMaterial() == net.minecraft.block.material.Material.EARTH))) {
							{
								BlockPos _bp = new BlockPos((int) (xdx), (int) (ydy), (int) (zdz));
								BlockState _bs = Blocks.LAVA.getDefaultState();
								world.setBlockState(_bp, _bs, 3);
							}
						}
						if ((((world.getBlockState(new BlockPos((int) (xdx), (int) (ydy), (int) (zdz))))
								.getMaterial() == net.minecraft.block.material.Material.SAND)
								|| ((world.getBlockState(new BlockPos((int) (xdx), (int) (ydy), (int) (zdz))))
										.getMaterial() == net.minecraft.block.material.Material.IRON))) {
							{
								BlockPos _bp = new BlockPos((int) (xdx), (int) (ydy), (int) (zdz));
								BlockState _bs = Blocks.LAVA.getDefaultState();
								world.setBlockState(_bp, _bs, 3);
							}
						}
						if ((((world.getBlockState(new BlockPos((int) (xdx), (int) (ydy), (int) (zdz))))
								.getMaterial() == net.minecraft.block.material.Material.GLASS)
								|| ((world.getBlockState(new BlockPos((int) (xdx), (int) (ydy), (int) (zdz))))
										.getMaterial() == net.minecraft.block.material.Material.ORGANIC))) {
							{
								BlockPos _bp = new BlockPos((int) (xdx), (int) (ydy), (int) (zdz));
								BlockState _bs = Blocks.LAVA.getDefaultState();
								world.setBlockState(_bp, _bs, 3);
							}
						}
					}
					dz = (double) ((dz) + 1);
				}
				dy = (double) ((dy) + 1);
			}
			dx = (double) ((dx) + 1);
		}
		firedist = (double) 5;
		dx = (double) ((-1) * (firedist));
		while (((dx) <= (firedist))) {
			dy = (double) ((-1) * (firedist));
			while (((dy) <= (firedist))) {
				dz = (double) ((-1) * (firedist));
				while (((dz) <= (firedist))) {
					if ((Math.sqrt((Math.pow((dx), 2) + (Math.pow((dy), 2) + Math.pow((dz), 2)))) <= (firedist))) {
						xdx = (double) (x + (dx));
						ydy = (double) (y + (dy));
						zdz = (double) (z + (dz));
						if ((world.getBlockState(new BlockPos((int) (xdx), (int) (ydy), (int) (zdz))).isSolid())) {
							if (((!(world.getBlockState(new BlockPos((int) (xdx), (int) ((ydy) + 1), (int) (zdz))).isSolid()))
									&& (!(/* @BlockState */(world.getFluidState(new BlockPos((int) (xdx), (int) ((ydy) + 1), (int) (zdz)))
											.getBlockState()).getBlock() instanceof FlowingFluidBlock)))) {
								if (((!((world.getBlockState(new BlockPos((int) (xdx), (int) (ydy), (int) (zdz))))
										.getBlock() == SolarPlasmaBlock.block.getDefaultState().getBlock()))
										&& (!((world.getBlockState(new BlockPos((int) (xdx), (int) (ydy), (int) (zdz))))
												.getBlock() == FusionplasmaBlock.block.getDefaultState().getBlock())))) {
									{
										BlockPos _bp = new BlockPos((int) (xdx), (int) ((ydy) + 1), (int) (zdz));
										BlockState _bs = Blocks.FIRE.getDefaultState();
										world.setBlockState(_bp, _bs, 3);
									}
								}
							}
						}
					}
					dz = (double) ((dz) + 1);
				}
				dy = (double) ((dy) + 1);
			}
			dx = (double) ((dx) + 1);
		}
	}
}
