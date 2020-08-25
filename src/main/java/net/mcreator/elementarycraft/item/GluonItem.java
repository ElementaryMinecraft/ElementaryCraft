
package net.mcreator.elementarycraft.item;

@ElementaryCraftModElements.ModElement.Tag
public class GluonItem extends ElementaryCraftModElements.ModElement {

	@ObjectHolder("elementary_craft:gluon")
	public static final Item block = null;

	public GluonItem(ElementaryCraftModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ElementaryParticleItemGroup.tab).maxStackSize(64));
			setRegistryName("gluon");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("a gluon is the exchange particle for the strong force between quarks"));
		}

	}

}
