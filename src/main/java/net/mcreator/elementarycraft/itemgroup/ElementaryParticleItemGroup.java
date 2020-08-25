
package net.mcreator.elementarycraft.itemgroup;

@ElementaryCraftModElements.ModElement.Tag
public class ElementaryParticleItemGroup extends ElementaryCraftModElements.ModElement {

	public ElementaryParticleItemGroup(ElementaryCraftModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabelementary_particle") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.BUBBLE_COLUMN, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;

}
