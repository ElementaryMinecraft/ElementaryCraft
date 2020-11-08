package net.mcreator.elementarycraft.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.Map;

@ElementaryCraftModElements.ModElement.Tag
public class EntropyMobSpawnProcedure extends ElementaryCraftModElements.ModElement {
	public EntropyMobSpawnProcedure(ElementaryCraftModElements instance) {
		super(instance, 125);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EntropyMobSpawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("collided", (false));
		entity.getPersistentData().putDouble("slotID", 0);
		for (int index0 = 0; index0 < (int) (125); index0++) {
			{
				final ItemStack _setstack = new ItemStack(Blocks.ALLIUM, (int) (1));
				final int _sltid = (int) ((entity.getPersistentData().getDouble("slotID")));
				_setstack.setCount((int) 1);
				entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable) {
						((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
					}
				});
			}
			entity.getPersistentData().putDouble("slotID", ((entity.getPersistentData().getDouble("slotID")) + 1));
		}
	}
}
