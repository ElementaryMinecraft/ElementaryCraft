
package net.mcreator.elementarycraft.item;

@ElementaryCraftModElements.ModElement.Tag
public class DownQuarkGreenItem extends ElementaryCraftModElements.ModElement {

	@ObjectHolder("elementary_craft:down_quark_green")
	public static final Item block = null;

	public DownQuarkGreenItem(ElementaryCraftModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64));
			setRegistryName("down_quark_green");
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