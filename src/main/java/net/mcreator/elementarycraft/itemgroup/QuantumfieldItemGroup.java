
package net.mcreator.elementarycraft.itemgroup;

@ElementaryCraftModElements.ModElement.Tag
public class QuantumfieldItemGroup extends ElementaryCraftModElements.ModElement {

	public QuantumfieldItemGroup(ElementaryCraftModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabquantumfield") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.LAVA, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;

}
