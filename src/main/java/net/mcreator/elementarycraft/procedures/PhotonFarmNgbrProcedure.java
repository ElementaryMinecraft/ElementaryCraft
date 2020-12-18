package net.mcreator.elementarycraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.Blocks;

import net.mcreator.elementarycraft.block.PhotonFieldBlock;
import net.mcreator.elementarycraft.block.PhotonFarmZBlock;
import net.mcreator.elementarycraft.block.PhotonFarmYBlock;
import net.mcreator.elementarycraft.block.PhotonFarmXBlock;
import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.Map;

@ElementaryCraftModElements.ModElement.Tag
public class PhotonFarmNgbrProcedure extends ElementaryCraftModElements.ModElement {
	public PhotonFarmNgbrProcedure(ElementaryCraftModElements instance) {
		super(instance, 163);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure PhotonFarmNgbr!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure PhotonFarmNgbr!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure PhotonFarmNgbr!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PhotonFarmNgbr!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == PhotonFarmXBlock.block.getDefaultState().getBlock())) {
			if ((!((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == PhotonFieldBlock.block.getDefaultState()
					.getBlock())
					&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock())))
					|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == PhotonFieldBlock.block.getDefaultState()
							.getBlock())
							&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
									.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock())))))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == PhotonFarmYBlock.block.getDefaultState()
				.getBlock())) {
			if ((!((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == PhotonFieldBlock.block.getDefaultState()
					.getBlock())
					&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())))
					|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == PhotonFieldBlock.block.getDefaultState()
							.getBlock())
							&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
									.contains((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock())))))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == PhotonFarmZBlock.block.getDefaultState()
				.getBlock())) {
			if ((!((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == PhotonFieldBlock.block.getDefaultState()
					.getBlock())
					&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock())))
					|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == PhotonFieldBlock.block.getDefaultState()
							.getBlock())
							&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
									.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock())))))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			}
		}
		if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:photon_farm_blocks").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())))) {
			if (((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == PhotonFieldBlock.block.getDefaultState()
					.getBlock())
					&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock())))
					|| (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == PhotonFieldBlock.block.getDefaultState()
							.getBlock())
							&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
									.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()))))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PhotonFarmXBlock.block.getDefaultState(), 3);
			} else if (((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == PhotonFieldBlock.block.getDefaultState()
					.getBlock())
					&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())))
					|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == PhotonFieldBlock.block.getDefaultState()
							.getBlock())
							&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
									.contains((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock()))))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PhotonFarmYBlock.block.getDefaultState(), 3);
			} else if (((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == PhotonFieldBlock.block.getDefaultState()
					.getBlock())
					&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock())))
					|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == PhotonFieldBlock.block.getDefaultState()
							.getBlock())
							&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
									.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock()))))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), PhotonFarmZBlock.block.getDefaultState(), 3);
			}
		}
	}
}
