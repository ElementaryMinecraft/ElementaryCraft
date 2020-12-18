package net.mcreator.elementarycraft.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tags.ItemTags;
import net.minecraft.state.IProperty;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.function.Function;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
import java.util.Comparator;

@ElementaryCraftModElements.ModElement.Tag
public class EntropyMobCollidesWithPlayerProcedure extends ElementaryCraftModElements.ModElement {
	public EntropyMobCollidesWithPlayerProcedure(ElementaryCraftModElements instance) {
		super(instance, 168);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EntropyMobCollidesWithPlayer!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure EntropyMobCollidesWithPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure EntropyMobCollidesWithPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure EntropyMobCollidesWithPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure EntropyMobCollidesWithPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(entity.getPersistentData().getBoolean("collided")))) {
			entity.getPersistentData().putBoolean("collided", (true));
			entity.getPersistentData().putDouble("slotID", 0);
			for (int index0 = 0; index0 < (int) (125); index0++) {
				{
					final ItemStack _setstack = new ItemStack(Blocks.ALLIUM, (int) (1));
					final int _sltid = (int) ((entity.getPersistentData().getDouble("slotID")));
					_setstack.setCount((int) 1);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable) {
							((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
						}
					});
				}
				entity.getPersistentData().putDouble("slotID", ((entity.getPersistentData().getDouble("slotID")) + 1));
			}
			entity.getPersistentData().putDouble("slotID", 0);
			entity.getPersistentData().putDouble("radius", 2);
			entity.getPersistentData().putDouble("xcoord", (entity.getPersistentData().getDouble("radius")));
			for (int index1 = 0; index1 < (int) ((((entity.getPersistentData().getDouble("radius")) * 2) + 1)); index1++) {
				entity.getPersistentData().putDouble("ycoord", (entity.getPersistentData().getDouble("radius")));
				for (int index2 = 0; index2 < (int) ((((entity.getPersistentData().getDouble("radius")) * 2) + 1)); index2++) {
					entity.getPersistentData().putDouble("zcoord", (entity.getPersistentData().getDouble("radius")));
					for (int index3 = 0; index3 < (int) ((((entity.getPersistentData().getDouble("radius")) * 2) + 1)); index3++) {
						{
							final ItemStack _setstack = (new ItemStack(
									(world.getBlockState(new BlockPos((int) (x + (entity.getPersistentData().getDouble("xcoord"))),
											(int) (y + (entity.getPersistentData().getDouble("ycoord"))),
											(int) (z + (entity.getPersistentData().getDouble("zcoord")))))).getBlock()));
							final int _sltid = (int) ((entity.getPersistentData().getDouble("slotID")));
							_setstack.setCount((int) 1);
							entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
								}
							});
						}
						entity.getPersistentData().putDouble("slotID", ((entity.getPersistentData().getDouble("slotID")) + 1));
						entity.getPersistentData().putDouble("zcoord", ((entity.getPersistentData().getDouble("zcoord")) - 1));
					}
					entity.getPersistentData().putDouble("ycoord", ((entity.getPersistentData().getDouble("ycoord")) - 1));
				}
				entity.getPersistentData().putDouble("xcoord", ((entity.getPersistentData().getDouble("xcoord")) - 1));
			}
			entity.getPersistentData().putDouble("xcoord", (entity.getPersistentData().getDouble("radius")));
			for (int index4 = 0; index4 < (int) ((((entity.getPersistentData().getDouble("radius")) * 2) + 1)); index4++) {
				entity.getPersistentData().putDouble("ycoord", (entity.getPersistentData().getDouble("radius")));
				for (int index5 = 0; index5 < (int) ((((entity.getPersistentData().getDouble("radius")) * 2) + 1)); index5++) {
					entity.getPersistentData().putDouble("zcoord", (entity.getPersistentData().getDouble("radius")));
					for (int index6 = 0; index6 < (int) ((((entity.getPersistentData().getDouble("radius")) * 2) + 1)); index6++) {
						entity.getPersistentData().putDouble("slotID",
								Math.floor((Math.random() * ((((entity.getPersistentData().getDouble("radius")) * 2) + 1)
										* ((((entity.getPersistentData().getDouble("radius")) * 2) + 1)
												* (((entity.getPersistentData().getDouble("radius")) * 2) + 1))))));
						entity.getPersistentData().putDouble("iterations", 0);
						while (((ItemTags.getCollection().getOrCreate(new ResourceLocation(("small_flowers").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((new Object() {
									public ItemStack getItemStack(int sltid, Entity entity) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).copy());
										});
										return _retval.get();
									}
								}.getItemStack((int) ((entity.getPersistentData().getDouble("slotID"))), entity)).getItem()))
								&& ((entity.getPersistentData().getDouble("iterations")) < 2000))) {
							entity.getPersistentData().putDouble("slotID",
									Math.floor((Math.random() * ((((entity.getPersistentData().getDouble("radius")) * 2) + 1)
											* ((((entity.getPersistentData().getDouble("radius")) * 2) + 1)
													* (((entity.getPersistentData().getDouble("radius")) * 2) + 1))))));
							entity.getPersistentData().putDouble("iterations", ((entity.getPersistentData().getDouble("iterations")) + 1));
						}
						if ((!(((Entity) world
								.getEntitiesWithinAABB(PlayerEntity.class,
										new AxisAlignedBB((x + (entity.getPersistentData().getDouble("xcoord"))) - (2 / 2d),
												(y + (entity.getPersistentData().getDouble("ycoord"))) - (2 / 2d),
												(z + (entity.getPersistentData().getDouble("zcoord"))) - (2 / 2d),
												(x + (entity.getPersistentData().getDouble("xcoord"))) + (2 / 2d),
												(y + (entity.getPersistentData().getDouble("ycoord"))) + (2 / 2d),
												(z + (entity.getPersistentData().getDouble("zcoord"))) + (2 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((x + (entity.getPersistentData().getDouble("xcoord"))),
										(y + (entity.getPersistentData().getDouble("ycoord"))),
										(z + (entity.getPersistentData().getDouble("zcoord")))))
								.findFirst().orElse(null)) != null))) {
							{
								BlockPos _bp = new BlockPos((int) (x + (entity.getPersistentData().getDouble("xcoord"))),
										(int) (y + (entity.getPersistentData().getDouble("ycoord"))),
										(int) (z + (entity.getPersistentData().getDouble("zcoord"))));
								BlockState _bs = /* @BlockState */(new Object() {
									public BlockState toBlock(ItemStack _stk) {
										if (_stk.getItem() instanceof BlockItem) {
											return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
										}
										return Blocks.AIR.getDefaultState();
									}
								}.toBlock((new Object() {
									public ItemStack getItemStack(int sltid, Entity entity) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
											_retval.set(capability.getStackInSlot(sltid).copy());
										});
										return _retval.get();
									}
								}.getItemStack((int) ((entity.getPersistentData().getDouble("slotID"))), entity))));
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
									if (_bs.has(_property))
										_bs = _bs.with(_property, (Comparable) entry.getValue());
								}
								TileEntity _te = world.getTileEntity(_bp);
								CompoundNBT _bnbt = null;
								if (_te != null) {
									_bnbt = _te.write(new CompoundNBT());
									_te.remove();
								}
								world.setBlockState(_bp, _bs, 3);
								if (_bnbt != null) {
									_te = world.getTileEntity(_bp);
									if (_te != null) {
										try {
											_te.read(_bnbt);
										} catch (Exception ignored) {
										}
									}
								}
							}
							{
								final ItemStack _setstack = new ItemStack(Blocks.ALLIUM, (int) (1));
								final int _sltid = (int) ((entity.getPersistentData().getDouble("slotID")));
								_setstack.setCount((int) 1);
								entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable) {
										((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
									}
								});
							}
						}
						entity.getPersistentData().putDouble("zcoord", ((entity.getPersistentData().getDouble("zcoord")) - 1));
					}
					entity.getPersistentData().putDouble("ycoord", ((entity.getPersistentData().getDouble("ycoord")) - 1));
				}
				entity.getPersistentData().putDouble("xcoord", ((entity.getPersistentData().getDouble("xcoord")) - 1));
			}
			if (!entity.world.isRemote)
				entity.remove();
		}
	}
}
