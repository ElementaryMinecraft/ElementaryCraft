package net.mcreator.elementarycraft.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.entity.item.minecart.MinecartEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;

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

@ElementaryCraftModElements.ModElement.Tag
public class PionMinecartProcedure extends ElementaryCraftModElements.ModElement {
	private static final Set<MinecartEntity> pionMinecarts = new HashSet<>();
	private static final Logger logger = LogManager.getLogger("ElementaryCraftMod");
	private static final int TICKS = 5;

	private final Set<MinecartEntity> tempMinecarts = new HashSet<>();
	private int ticks = 0;

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

		List<MinecartEntity> minecarts = world.getEntitiesWithinAABB(MinecartEntity.class, new AxisAlignedBB(x - 1, y, z, x + 2, y + 1, z + 1), null);
		if (minecarts.isEmpty()) {
			minecarts = world.getEntitiesWithinAABB(MinecartEntity.class, new AxisAlignedBB(x, y, z - 1, x + 1, y + 1, z + 2), null);
		}
		if (minecarts.isEmpty()) {
			return;
		}

		pionMinecarts.addAll(minecarts);
	}

	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END && !pionMinecarts.isEmpty()) {
			if (ticks > 0) {
				tempMinecarts.clear();
				System.err.println("Skipping 1 tick (" + ticks + ")");
			} else {
				pionMinecarts.forEach(minecart -> {
					if ((Math.abs(minecart.getMotion().x) < 0.00001 && Math.abs(minecart.getMotion().y) < 0.00001 && Math.abs(minecart.getMotion().z) < 0.00001) || tempMinecarts.contains(minecart)) {
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
				pionMinecarts.removeIf(minecart -> Math.abs(minecart.getMotion().x) < 0.00001 && Math.abs(minecart.getMotion().y) < 0.00001 && Math.abs(minecart.getMotion().z) < 0.00001);
			}
			ticks = (ticks + 1) % TICKS;
		}
	}
}
