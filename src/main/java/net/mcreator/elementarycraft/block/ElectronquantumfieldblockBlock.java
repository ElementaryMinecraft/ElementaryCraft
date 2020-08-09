
package net.mcreator.elementarycraft.block;

import net.minecraft.block.material.Material;

@ElementaryCraftModElements.ModElement.Tag
public class ElectronquantumfieldblockBlock extends ElementaryCraftModElements.ModElement {

	@ObjectHolder("elementary_craft:electronquantumfieldblock")
	public static final Block block = null;

	public ElectronquantumfieldblockBlock(ElementaryCraftModElements instance) {
		super(instance, 3);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(1f, 10f).lightValue(0));

			setRegistryName("electronquantumfieldblock");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity entity, Hand hand,
				BlockRayTraceResult hit) {
			super.onBlockActivated(state, world, pos, entity, hand, hit);

			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();

			Direction direction = hit.getFace();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);

				ElectronquantumfieldBlockDropProcedure.executeProcedure($_dependencies);
			}

			return ActionResultType.SUCCESS;
		}

	}

}
