package net.mcreator.elementarycraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;

import net.mcreator.elementarycraft.block.PhotonFieldBlock;
import net.mcreator.elementarycraft.block.PhotonFarmZBlock;
import net.mcreator.elementarycraft.block.PhotonFarmYBlock;
import net.mcreator.elementarycraft.block.PhotonFarmXBlock;
import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.Map;

@ElementaryCraftModElements.ModElement.Tag
public class AddPhotonFarmProcedure extends ElementaryCraftModElements.ModElement {
	public AddPhotonFarmProcedure(ElementaryCraftModElements instance) {
		super(instance, 166);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure AddPhotonFarm!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure AddPhotonFarm!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure AddPhotonFarm!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure AddPhotonFarm!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()))) {
			if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.AIR)
					&& ((world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) z))).getBlock() == PhotonFieldBlock.block.getDefaultState()
							.getBlock()))) {
				if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:photon_farm_blocks").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock())))) {
					world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), PhotonFarmXBlock.block.getDefaultState(), 3);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.AIR)
					&& ((world.getBlockState(new BlockPos((int) (x - 2), (int) y, (int) z))).getBlock() == PhotonFieldBlock.block.getDefaultState()
							.getBlock()))) {
				if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:photon_farm_blocks").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock())))) {
					world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), PhotonFarmXBlock.block.getDefaultState(), 3);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.AIR)
					&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getBlock() == PhotonFieldBlock.block.getDefaultState()
							.getBlock()))) {
				if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:photon_farm_blocks").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock())))) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), PhotonFarmYBlock.block.getDefaultState(), 3);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.AIR)
					&& ((world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock() == PhotonFieldBlock.block.getDefaultState()
							.getBlock()))) {
				if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:photon_farm_blocks").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())))) {
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), PhotonFarmYBlock.block.getDefaultState(), 3);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == net.minecraft.block.material.Material.AIR)
					&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 2)))).getBlock() == PhotonFieldBlock.block.getDefaultState()
							.getBlock()))) {
				if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:photon_farm_blocks").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock())))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), PhotonFarmZBlock.block.getDefaultState(), 3);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == net.minecraft.block.material.Material.AIR)
					&& ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 2)))).getBlock() == PhotonFieldBlock.block.getDefaultState()
							.getBlock()))) {
				if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:photon_farm_blocks").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock())))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), PhotonFarmZBlock.block.getDefaultState(), 3);
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == PhotonFieldBlock.block.getDefaultState()
				.getBlock())) {
			if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.AIR)
					&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((world.getBlockState(new BlockPos((int) (x + 2), (int) y, (int) z))).getBlock())))) {
				if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:photon_farm_blocks").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock())))) {
					world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), PhotonFarmXBlock.block.getDefaultState(), 3);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getMaterial() == net.minecraft.block.material.Material.AIR)
					&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((world.getBlockState(new BlockPos((int) (x - 2), (int) y, (int) z))).getBlock())))) {
				if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:photon_farm_blocks").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock())))) {
					world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), PhotonFarmXBlock.block.getDefaultState(), 3);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.AIR)
					&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((world.getBlockState(new BlockPos((int) x, (int) (y + 2), (int) z))).getBlock())))) {
				if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:photon_farm_blocks").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock())))) {
					world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), PhotonFarmYBlock.block.getDefaultState(), 3);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getMaterial() == net.minecraft.block.material.Material.AIR)
					&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 2), (int) z))).getBlock())))) {
				if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:photon_farm_blocks").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock())))) {
					world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), PhotonFarmYBlock.block.getDefaultState(), 3);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getMaterial() == net.minecraft.block.material.Material.AIR)
					&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 2)))).getBlock())))) {
				if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:photon_farm_blocks").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock())))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), PhotonFarmZBlock.block.getDefaultState(), 3);
				}
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getMaterial() == net.minecraft.block.material.Material.AIR)
					&& (BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:charged").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 2)))).getBlock())))) {
				if ((!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("forge:photon_farm_blocks").toLowerCase(java.util.Locale.ENGLISH)))
						.contains((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock())))) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), PhotonFarmZBlock.block.getDefaultState(), 3);
				}
			}
		}
	}
}
