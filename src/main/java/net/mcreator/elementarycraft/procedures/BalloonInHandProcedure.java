package net.mcreator.elementarycraft.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.elementarycraft.item.BalloonItem;
import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.Random;
import java.util.Map;

@ElementaryCraftModElements.ModElement.Tag
public class BalloonInHandProcedure extends ElementaryCraftModElements.ModElement {
	public BalloonInHandProcedure(ElementaryCraftModElements instance) {
		super(instance, 146);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure BalloonInHand!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure BalloonInHand!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(BalloonItem.block, (int) (1)).getItem())) {
			{
				ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY);
				if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			if (((((itemstack)).getDamage()) < 1)) {
				if (entity instanceof PlayerEntity) {
					((PlayerEntity) entity).abilities.isFlying = (false);
					((PlayerEntity) entity).sendPlayerAbilities();
				}
			} else {
				if (entity instanceof PlayerEntity) {
					((PlayerEntity) entity).abilities.isFlying = (true);
					((PlayerEntity) entity).sendPlayerAbilities();
				}
			}
		} else {
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).abilities.isFlying = (false);
				((PlayerEntity) entity).sendPlayerAbilities();
			}
		}
	}
}
