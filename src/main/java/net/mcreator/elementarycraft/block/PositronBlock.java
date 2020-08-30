
package net.mcreator.elementarycraft.block;

import net.minecraft.block.material.Material;

@ElementaryCraftModElements.ModElement.Tag
public class PositronBlock extends ElementaryCraftModElements.ModElement {

	@ObjectHolder("elementary_craft:positron")
	public static final Block block = null;

	public PositronBlock(ElementaryCraftModElements instance) {
		super(instance, 18);

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

					Block.Properties.create(Material.ROCK).sound(SoundType.CLOTH).hardnessAndResistance(1f, 10f).lightValue(0).doesNotBlockMovement()
							.notSolid());

			setRegistryName("positron");
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
			return VoxelShapes.create(0D, 0D, 0.4D, 1D, 0D, 0.6D);
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
