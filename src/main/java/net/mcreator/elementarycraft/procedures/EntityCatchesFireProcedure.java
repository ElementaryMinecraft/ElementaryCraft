package net.mcreator.elementarycraft.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.Map;

@ElementaryCraftModElements.ModElement.Tag
public class EntityCatchesFireProcedure extends ElementaryCraftModElements.ModElement {
	public EntityCatchesFireProcedure(ElementaryCraftModElements instance) {
		super(instance, 133);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EntityCatchesFire!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 10);
	}
}
