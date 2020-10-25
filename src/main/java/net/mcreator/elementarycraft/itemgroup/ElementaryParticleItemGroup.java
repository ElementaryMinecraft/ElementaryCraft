
package net.mcreator.elementarycraft.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
<<<<<<< HEAD

import net.mcreator.elementarycraft.item.PhotonItem;
import net.mcreator.elementarycraft.ElementaryCraftModElements;

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
				return new ItemStack(PhotonItem.block, (int) (1));
=======
import net.minecraft.block.Blocks;

import net.mcreator.elementarycraft.ElementaryCraftModElements;

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
>>>>>>> branch 'textures' of https://github.com/ElementaryMinecraft/ElementaryCraft.git
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
