package net.mcreator.elementarycraft.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.Map;

@ElementaryCraftModElements.ModElement.Tag
public class EntropyMobSpawnProcedure extends ElementaryCraftModElements.ModElement {
	public EntropyMobSpawnProcedure(ElementaryCraftModElements instance) {
		super(instance, 125);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EntropyMobSpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("collided", (false));
	}
}
