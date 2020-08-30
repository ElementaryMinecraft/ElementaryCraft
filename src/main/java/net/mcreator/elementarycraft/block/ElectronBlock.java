
package net.mcreator.elementarycraft.block;

import net.minecraft.block.material.Material;

@ElementaryCraftModElements.ModElement.Tag
public class ElectronBlock extends ElementaryCraftModElements.ModElement {

	@ObjectHolder("elementary_craft:electron")
	public static final Block block = null;

	public ElectronBlock(ElementaryCraftModElements instance) {
		super(instance, 17);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(ElementaryParticleItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getTranslucent());
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.CLOTH).hardnessAndResistance(1f, 10f).lightValue(0)
							.doesNotBlockMovement());

			setRegistryName("electron");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
