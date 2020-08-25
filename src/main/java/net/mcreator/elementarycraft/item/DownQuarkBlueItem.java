
package net.mcreator.elementarycraft.item;

@ElementaryCraftModElements.ModElement.Tag
public class DownQuarkBlueItem extends ElementaryCraftModElements.ModElement {

	@ObjectHolder("elementary_craft:down_quark_blue")
	public static final Item block = null;

	public DownQuarkBlueItem(ElementaryCraftModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ElementaryParticleItemGroup.tab).maxStackSize(64));
			setRegistryName("down_quark_blue");
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
