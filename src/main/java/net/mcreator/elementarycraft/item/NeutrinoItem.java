
package net.mcreator.elementarycraft.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.elementarycraft.itemgroup.ElementaryParticleItemGroup;
import net.mcreator.elementarycraft.ElementaryCraftModElements;

@ElementaryCraftModElements.ModElement.Tag
public class NeutrinoItem extends ElementaryCraftModElements.ModElement {
	@ObjectHolder("elementary_craft:neutrino")
	public static final Item block = null;
	public NeutrinoItem(ElementaryCraftModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ElementaryParticleItemGroup.tab).maxStackSize(64));
			setRegistryName("neutrino");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
