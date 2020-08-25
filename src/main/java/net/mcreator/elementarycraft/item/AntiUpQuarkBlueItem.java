
package net.mcreator.elementarycraft.item;

@ElementaryCraftModElements.ModElement.Tag
public class AntiUpQuarkBlueItem extends ElementaryCraftModElements.ModElement {

	@ObjectHolder("elementary_craft:anti_up_quark_blue")
	public static final Item block = null;

	public AntiUpQuarkBlueItem(ElementaryCraftModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64));
			setRegistryName("anti_up_quark_blue");
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
