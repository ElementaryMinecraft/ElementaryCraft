package net.mcreator.elementarycraft.procedures;

import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.mcreator.elementarycraft.block.StrechedGluonXBlock;
import net.mcreator.elementarycraft.block.StrechedGluonZBlock;

import net.minecraft.tags.BlockTags;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.entity.item.minecart.MinecartEntity;
import net.minecraft.entity.item.ItemEntity;

import net.minecraft.item.ItemStack;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;

import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;

import net.mcreator.elementarycraft.item.GluonItem;
import net.mcreator.elementarycraft.ElementaryCraftMod;
import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.lang.Math;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Comparator;
import java.util.HashSet;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import net.minecraft.client.Minecraft;
import com.sun.corba.se.spi.extension.ZeroPortPolicy;
import com.sun.corba.se.spi.extension.ZeroPortPolicy;
import org.antlr.v4.runtime.atn.EpsilonTransition;
import java.util.ArrayList;

@ElementaryCraftModElements.ModElement.Tag
public class PionMinecartProcedure extends ElementaryCraftModElements.ModElement {
	private static final List<List<MinecartEntity>> pionMinecarts = new ArrayList<>();
	private static final Logger logger = LogManager.getLogger("ElementaryCraftMod");
	private static final int TICKS = 4;

	private final List<MinecartEntity> tempMinecarts = new ArrayList<>();
	private int ticks = 0;
	private static double motionEps = 0.01;
	
	public PionMinecartProcedure(ElementaryCraftModElements instance) {
		super(instance, 85);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PionMinecart!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PionMinecart!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PionMinecart!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PionMinecart!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		
		if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
	
			List<MinecartEntity> minecarts1 = world.getEntitiesWithinAABB(MinecartEntity.class, new AxisAlignedBB(x - 1, y, z, x + 2, y + 1, z + 1), null);
			List<MinecartEntity> minecarts2 = new ArrayList<>();
			List<MinecartEntity> minecarts3 = new ArrayList<>();
			if (minecarts1.size() == 2) {
				for (int i = 0; i < 2; i++) {
					if ((Math.abs(minecarts1.get(i).getMotion().x) > motionEps && Math.abs(minecarts1.get(i).getMotion().y) > motionEps && Math.abs(minecarts1.get(i).getMotion().z) > motionEps) || (Math.abs(minecarts1.get(i).getPosition().getX() - x) != 1.0)) {
						System.err.println("al in beweging");
						return;
					}
					if (!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("minecraft:rails").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (x - 1), (int) (y), (int) (z)))).getBlock()))) {
						System.err.println("niet op rails - links");
						return;
					}
					if (!(BlockTags.getCollection().getOrCreate(new ResourceLocation(("minecraft:rails").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (x + 1), (int) (y), (int) (z)))).getBlock()))) {
						System.err.println("niet op rails - rechts");
						return;
					}
								
				}
				if ((minecarts1.get(0).getPosition().getX() - x) != -(minecarts1.get(1).getPosition().getX() - x)) {
					System.err.println("verkeerd geplaatst");
					return;
				}
				for (int i = 0; i < 2; i++) {
					if (minecarts1.get(i).getPosition().getX() - x < 0) {
						world.getWorld().getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vec3d(minecarts1.get(i).getPosition().getX() + 0.5, minecarts1.get(i).getPosition().getY()+0.5, minecarts1.get(i).getPosition().getZ()+0.5), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							"summon minecraft:minecart ~ ~ ~ {CustomDisplayTile:1b,DisplayState:{Name:\"elementary_craft:gluon_minecart_back\"},DisplayOffset:1,Motion:[-0.2,0.0,0.0]}");
					} else {
						world.getWorld().getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vec3d(minecarts1.get(i).getPosition().getX() + 0.5, minecarts1.get(i).getPosition().getY()+0.5, minecarts1.get(i).getPosition().getZ()+0.5), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							"summon minecraft:minecart ~ ~ ~ {CustomDisplayTile:1b,DisplayState:{Name:\"elementary_craft:gluon_minecart_front\"},DisplayOffset:1,Motion:[0.2,0.0,0.0]}");
					}
					minecarts1.get(i).remove();
				}
				minecarts2 = world.getEntitiesWithinAABB(MinecartEntity.class, new AxisAlignedBB(x - 1, y, z, x + 2, y + 1, z + 1), null);
			} else {
				minecarts1 = world.getEntitiesWithinAABB(MinecartEntity.class, new AxisAlignedBB(x, y, z - 1, x + 1, y + 1, z + 2), null);
				if (minecarts1.size() == 2) {
					for (int i = 0; i < 2; i++) {
						if ((Math.abs(minecarts1.get(i).getMotion().x) > motionEps && Math.abs(minecarts1.get(i).getMotion().y) > motionEps && Math.abs(minecarts1.get(i).getMotion().z) > motionEps) || (Math.abs(minecarts1.get(i).getPosition().getZ() - z) != 1.0)) {
							return;
						}
					}
					if ((minecarts1.get(0).getPosition().getZ() - z) != -(minecarts1.get(1).getPosition().getZ() - z)) {
						return;
					}
					for (int i = 0; i < 2; i++) {
						if (minecarts1.get(i).getPosition().getZ() - z < 0) {
							world.getWorld().getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vec3d(minecarts1.get(i).getPosition().getX()+0.5, minecarts1.get(i).getPosition().getY()+0.5, minecarts1.get(i).getPosition().getZ() + 0.5), Vec2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							"summon minecraft:minecart ~ ~ ~ {CustomDisplayTile:1b,DisplayState:{Name:\"elementary_craft:gluon_minecart_back\"},DisplayOffset:1,Motion:[0.0,0.0,-0.2]}");
	
						} else {
							world.getWorld().getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vec3d(minecarts1.get(i).getPosition().getX()+0.5, minecarts1.get(i).getPosition().getY()+0.5, minecarts1.get(i).getPosition().getZ() + 0.5), Vec2f.ZERO, (ServerWorld) world, 4, "",
										new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							"summon minecraft:minecart ~ ~ ~ {CustomDisplayTile:1b,DisplayState:{Name:\"elementary_craft:gluon_minecart_front\"},DisplayOffset:1,Motion:[0.0,0.0,0.2]}");
						}
						minecarts1.get(i).remove();
					}
					minecarts2 = world.getEntitiesWithinAABB(MinecartEntity.class, new AxisAlignedBB(x, y, z - 1, x + 1, y + 1, z + 2), null);		
				} else {
					System.err.println("minecart niet gevonden");
					return;
				}
			}
			for (int i = 0; i < minecarts2.size(); i++) {
				if ((minecarts2.get(i).getMotion().z == 0.0) ^ (minecarts2.get(i).getMotion().x == 0.0)) {
					minecarts3.add(minecarts2.get(i));	
				}
			}
			if (minecarts3.size() != 2) {
				System.err.println("minecart te weinig: slechts " + minecarts3.size() + " minecarts");
				return;
			}
			
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
			pionMinecarts.add(minecarts3);
		}
	}

	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END && !pionMinecarts.isEmpty()) {
			if (ticks > 0) {
				tempMinecarts.clear();
				System.err.println("Skipping 1 tick (" + ticks + ")");
			} else {
				System.err.println("Er zijn " + pionMinecarts.size() + " groepen in het spel in het spel.");
				if (pionMinecarts.size() == 1) {System.err.println("met een subgroep van " + pionMinecarts.get(0).size() + " minecarts.");}
				for (int i = pionMinecarts.size() - 1; i > -1; i--) {
					boolean removeBool = false;
					int mineY = (int) Math.round(pionMinecarts.get(i).get(1).getPosition().getY() + 1);
					if (pionMinecarts.get(i).get(0).getPosition().getX() == pionMinecarts.get(i).get(1).getPosition().getX()) {
						int minZ = 0;
						int maxZ = 0;
						int mineX = (int) (Math.round(pionMinecarts.get(i).get(0).getPosition().getX() - 0.5));
						if (pionMinecarts.get(i).get(0).getPosition().getZ() < pionMinecarts.get(i).get(1).getPosition().getZ()) {
							minZ = (int) (Math.round(pionMinecarts.get(i).get(0).getPosition().getZ() - 1.5));
							maxZ = (int) (Math.round(pionMinecarts.get(i).get(1).getPosition().getZ() - 0.5));
						} else {
							minZ = (int) (Math.round(pionMinecarts.get(i).get(1).getPosition().getZ() - 1.5));
							maxZ = (int) (Math.round(pionMinecarts.get(i).get(0).getPosition().getZ() - 0.5));
						}
						for (int j = minZ + 2; j < maxZ; j++) {
							if ((pionMinecarts.get(i).get(1).world.getBlockState(new BlockPos(mineX, mineY, j))).getMaterial()
							 != net.minecraft.block.material.Material.AIR) {
							 	if ((pionMinecarts.get(i).get(1).world.getBlockState(new BlockPos(mineX, mineY, j))).getBlock() !=
							 		StrechedGluonZBlock.block.getDefaultState().getBlock()) {
								removeBool = true;
								}
							} else {
								pionMinecarts.get(i).get(1).world.setBlockState(new BlockPos(mineX, mineY, j), StrechedGluonZBlock.block.getDefaultState(), 3);
							}
						}
					} else if (pionMinecarts.get(i).get(0).getPosition().getZ() == pionMinecarts.get(i).get(1).getPosition().getZ()) {
						int minX = 0;
						int maxX = 0;
						int mineZ = (int) (Math.round(pionMinecarts.get(i).get(0).getPosition().getZ() - 0.5));
						if (pionMinecarts.get(i).get(0).getPosition().getX() < pionMinecarts.get(i).get(1).getPosition().getX()) {
							minX = (int) (Math.round(pionMinecarts.get(i).get(0).getPosition().getX() - 1.5));
							maxX = (int) (Math.round(pionMinecarts.get(i).get(1).getPosition().getX() - 0.5));
						} else {
							minX = (int) (Math.round(pionMinecarts.get(i).get(1).getPosition().getX() - 1.5));
							maxX = (int) (Math.round(pionMinecarts.get(i).get(0).getPosition().getX() - 0.5));
						}
						for (int j = minX + 2; j < maxX; j++) {
							if ((pionMinecarts.get(i).get(1).world.getBlockState(new BlockPos(j, mineY, mineZ))).getMaterial()
							 != net.minecraft.block.material.Material.AIR) {
							 	if ((pionMinecarts.get(i).get(1).world.getBlockState(new BlockPos(j, mineY, mineZ))).getBlock() !=
							 		StrechedGluonXBlock.block.getDefaultState().getBlock()) {
								removeBool = true;
								}
							} else {
								pionMinecarts.get(i).get(1).world.setBlockState(new BlockPos(j, mineY, mineZ), StrechedGluonXBlock.block.getDefaultState(), 3);
							}
						}						
					}
					if (
						(Math.abs(pionMinecarts.get(i).get(0).getMotion().x) < motionEps && Math.abs(pionMinecarts.get(i).get(0).getMotion().y) < motionEps && Math.abs(pionMinecarts.get(i).get(0).getMotion().z) < motionEps) ||
						(Math.abs(pionMinecarts.get(i).get(1).getMotion().x) < motionEps && Math.abs(pionMinecarts.get(i).get(1).getMotion().y) < motionEps && Math.abs(pionMinecarts.get(i).get(1).getMotion().z) < motionEps) ||
						(Math.abs(pionMinecarts.get(i).get(0).getMotion().x) > motionEps && Math.abs(pionMinecarts.get(i).get(0).getMotion().y) > motionEps) ||
						(Math.abs(pionMinecarts.get(i).get(1).getMotion().x) > motionEps && Math.abs(pionMinecarts.get(i).get(1).getMotion().y) > motionEps) ||
						(Math.abs(pionMinecarts.get(i).get(0).getMotion().z) > motionEps && Math.abs(pionMinecarts.get(i).get(0).getMotion().y) > motionEps) ||
						(Math.abs(pionMinecarts.get(i).get(1).getMotion().z) > motionEps && Math.abs(pionMinecarts.get(i).get(1).getMotion().y) > motionEps) ||
						(Math.abs(pionMinecarts.get(i).get(0).getMotion().x) > motionEps && Math.abs(pionMinecarts.get(i).get(0).getMotion().z) > motionEps) ||
						(Math.abs(pionMinecarts.get(i).get(1).getMotion().x) > motionEps && Math.abs(pionMinecarts.get(i).get(1).getMotion().z) > motionEps) ||
						(pionMinecarts.get(i).get(0).getMotion().x * pionMinecarts.get(i).get(1).getMotion().x > 0.0) || 
						(pionMinecarts.get(i).get(0).getMotion().z * pionMinecarts.get(i).get(1).getMotion().z > 0.0) ||
						(pionMinecarts.get(i).get(0).getMotion().y != 0.0 || pionMinecarts.get(i).get(1).getMotion().y != 0.0) ||
						(pionMinecarts.get(i).get(0).getPosition().getY() != pionMinecarts.get(i).get(1).getPosition().getY()) ||
						((pionMinecarts.get(i).get(0).getPosition().getX() != pionMinecarts.get(i).get(1).getPosition().getX()) &&
						(pionMinecarts.get(i).get(0).getPosition().getZ() != pionMinecarts.get(i).get(1).getPosition().getZ()) || removeBool)
					   ) {
					   	int kmax = 1;
					   	if (Math.abs(pionMinecarts.get(i).get(0).getMotion().x) > 0.4 || Math.abs(pionMinecarts.get(i).get(0).getMotion().y) > 0.4 ||
					   		Math.abs(pionMinecarts.get(i).get(0).getMotion().z) > 0.4 || Math.abs(pionMinecarts.get(i).get(1).getMotion().x) > 0.4 ||
					   		Math.abs(pionMinecarts.get(i).get(1).getMotion().y) > 0.4 || Math.abs(pionMinecarts.get(i).get(1).getMotion().z) > 0.4) {
					   			kmax = 2;
					   		}
						if ((Math.abs(pionMinecarts.get(i).get(0).getPosition().getZ() - pionMinecarts.get(i).get(1).getPosition().getZ()))
							> (Math.abs(pionMinecarts.get(i).get(0).getPosition().getX() - pionMinecarts.get(i).get(1).getPosition().getX()))) {
							int minZ = 0;
							int maxZ = 0;
							int mineX = (int) (Math.round((pionMinecarts.get(i).get(0).getPosition().getX() + pionMinecarts.get(i).get(1).getPosition().getX())/2 - 0.5));
							if (pionMinecarts.get(i).get(0).getPosition().getZ() < pionMinecarts.get(i).get(1).getPosition().getZ()) {
								minZ = (int) (Math.round(pionMinecarts.get(i).get(0).getPosition().getZ() - 1.5));
								maxZ = (int) (Math.round(pionMinecarts.get(i).get(1).getPosition().getZ() - 0.5));
							} else {
								minZ = (int) (Math.round(pionMinecarts.get(i).get(1).getPosition().getZ() - 1.5));
								maxZ = (int) (Math.round(pionMinecarts.get(i).get(0).getPosition().getZ() - 0.5));
							}
							
							for (int j = minZ - kmax; j < maxZ + 1 + kmax; j++) {
								for (int k1 = -kmax; k1 < kmax + 1; k1++) {
									for (int k2 = -kmax; k2 < kmax + 1; k2++) {
										if ((pionMinecarts.get(i).get(1).world.getBlockState(new BlockPos(mineX + k1, mineY + k2, j))).getBlock() ==
										 	StrechedGluonZBlock.block.getDefaultState().getBlock()) {
										 	pionMinecarts.get(i).get(1).world.setBlockState(new BlockPos(mineX + k1, mineY + k2, j), Blocks.AIR.getDefaultState(), 3);
										 	}
									}
								}
							}
						} else {
							int minX = 0;
							int maxX = 0;
							int mineZ = (int) (Math.round((pionMinecarts.get(i).get(0).getPosition().getZ() + pionMinecarts.get(i).get(1).getPosition().getZ())/2 - 0.5));
							if (pionMinecarts.get(i).get(0).getPosition().getX() < pionMinecarts.get(i).get(1).getPosition().getX()) {
								minX = (int) (Math.round(pionMinecarts.get(i).get(0).getPosition().getX() - 1.5));
								maxX = (int) (Math.round(pionMinecarts.get(i).get(1).getPosition().getX() - 0.5));
							} else {
								minX = (int) (Math.round(pionMinecarts.get(i).get(1).getPosition().getX() - 1.5));
								maxX = (int) (Math.round(pionMinecarts.get(i).get(0).getPosition().getX() - 0.5));
							}
							for (int j = minX - kmax; j < maxX + 1 + kmax; j++) {
								for (int k1 = -kmax; k1 < kmax + 1; k1++) {
									for (int k2 = -kmax; k2 < kmax + 1; k2++) {
										if ((pionMinecarts.get(i).get(1).world.getBlockState(new BlockPos(j, mineY + k1, mineZ + k2))).getBlock() ==
										 	StrechedGluonXBlock.block.getDefaultState().getBlock()) {
										 	pionMinecarts.get(i).get(1).world.setBlockState(new BlockPos(j, mineY + k1, mineZ + k2), Blocks.AIR.getDefaultState(), 3);
										}
									}
								}
							}
						}
						for (int j = 1; j > -1; j--) {
							pionMinecarts.get(i).get(j).world.getWorld().getServer().getCommandManager().handleCommand(
								new CommandSource(ICommandSource.DUMMY, new Vec3d(pionMinecarts.get(i).get(j).getPosition().getX()+0.5, pionMinecarts.get(i).get(j).getPosition().getY()+0.5, pionMinecarts.get(i).get(j).getPosition().getZ() + 0.5), Vec2f.ZERO, (ServerWorld) pionMinecarts.get(i).get(j).world, 4, "",
									new StringTextComponent(""), pionMinecarts.get(i).get(j).world.getWorld().getServer(), null).withFeedbackDisabled(),
									"summon minecraft:minecart ~ ~ ~ {Motion:[" + pionMinecarts.get(i).get(j).getMotion().x + "," + pionMinecarts.get(i).get(j).getMotion().y + "," + pionMinecarts.get(i).get(j).getMotion().z + "]}");
							System.err.println("summon minecraft:minecart ~ ~ ~ {Motion:[" + pionMinecarts.get(i).get(j).getMotion().x + "," + pionMinecarts.get(i).get(j).getMotion().y + "," + pionMinecarts.get(i).get(j).getMotion().z + "]}");
							pionMinecarts.get(i).get(j).remove();
						}
						System.err.println("Minecarts verwijderd");
						pionMinecarts.remove(i);						
					}
				}
				pionMinecarts.forEach(minecarts -> {
						minecarts.forEach(minecart -> {
						if (tempMinecarts.contains(minecart)) {
							return;
						}
						ItemEntity entityToSpawn = new ItemEntity(
							minecart.world.getWorld(),
							minecart.getPosition().getX(),
							minecart.getPosition().getY(),
							minecart.getPosition().getZ(),
							new ItemStack(GluonItem.block, (int) (1))
						);
						entityToSpawn.setPickupDelay(10);
						minecart.world.addEntity(entityToSpawn);
						tempMinecarts.add(minecart);
						System.err.println("Spawning gluon (" + ticks + ") for minecart " + minecart);
					});
				});
			}
			ticks = (ticks + 1) % TICKS;
		}
	}
}
