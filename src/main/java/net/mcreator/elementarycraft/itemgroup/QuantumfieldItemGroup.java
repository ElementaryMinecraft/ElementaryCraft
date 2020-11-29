
package net.mcreator.elementarycraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.elementarycraft.block.PhotonFieldBlock;
import net.mcreator.elementarycraft.ElementaryCraftModElements;

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
				return new ItemStack(PhotonFieldBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
