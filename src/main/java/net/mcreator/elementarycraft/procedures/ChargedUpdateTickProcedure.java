package net.mcreator.elementarycraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.Map;
import java.util.HashMap;

@ElementaryCraftModElements.ModElement.Tag
public class ChargedUpdateTickProcedure extends ElementaryCraftModElements.ModElement {
	public ChargedUpdateTickProcedure(ElementaryCraftModElements instance) {
		super(instance, 90);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ChargedUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ChargedUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ChargedUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ChargedUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack loc = ItemStack.EMPTY;
		double Ex = 0;
		double Ey = 0;
		double Ez = 0;
		double Em = 0;
		if ((new Object() {
			public boolean getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "move"))) {
			Ex = (double) (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "ex"));
			Ey = (double) (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "ey"));
			Ez = (double) (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "ez"));
			Em = (double) 0.4;
			if ((Math.abs((Ex)) >= Math.abs((Ey)))) {
				if ((Math.abs((Ex)) >= Math.abs((Ez)))) {
					if (((world.getBlockState(new BlockPos((int) (x + Math.round(((Ex) / Math.abs((Ex))))), (int) y, (int) z)))
							.getMaterial() == net.minecraft.block.material.Material.AIR)) {
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x", x);
							$_dependencies.put("y", y);
							$_dependencies.put("z", z);
							ChargeRemoveProcedure.executeProcedure($_dependencies);
						}
						loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos((int) (x + ((Ex) / Math.abs((Ex)))), (int) y, (int) z), /* @BlockState */(new Object() {
							public BlockState toBlock(ItemStack _stk) {
								if (_stk.getItem() instanceof BlockItem) {
									return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
								}
								return Blocks.AIR.getDefaultState();
							}
						}.toBlock((loc))), 3);
					} else if ((Math.abs((Ez)) >= Math.abs((Ey)))) {
						if ((Math.abs((Ez)) >= (Em))) {
							if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + ((Ez) / Math.abs((Ez)))))))
									.getMaterial() == net.minecraft.block.material.Material.AIR)) {
								{
									Map<String, Object> $_dependencies = new HashMap<>();
									$_dependencies.put("world", world);
									$_dependencies.put("x", x);
									$_dependencies.put("y", y);
									$_dependencies.put("z", z);
									ChargeRemoveProcedure.executeProcedure($_dependencies);
								}
								loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
								world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
								world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + ((Ez) / Math.abs((Ez))))),
										/* @BlockState */(new Object() {
											public BlockState toBlock(ItemStack _stk) {
												if (_stk.getItem() instanceof BlockItem) {
													return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
												}
												return Blocks.AIR.getDefaultState();
											}
										}.toBlock((loc))), 3);
							} else if ((Math.abs((Ey)) >= (Em))) {
								if (((world.getBlockState(new BlockPos((int) x, (int) (y + ((Ey) / Math.abs((Ey)))), (int) z)))
										.getMaterial() == net.minecraft.block.material.Material.AIR)) {
									{
										Map<String, Object> $_dependencies = new HashMap<>();
										$_dependencies.put("world", world);
										$_dependencies.put("x", x);
										$_dependencies.put("y", y);
										$_dependencies.put("z", z);
										ChargeRemoveProcedure.executeProcedure($_dependencies);
									}
									loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
									world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
									world.setBlockState(new BlockPos((int) x, (int) (y + ((Ey) / Math.abs((Ey)))), (int) z),
											/* @BlockState */(new Object() {
												public BlockState toBlock(ItemStack _stk) {
													if (_stk.getItem() instanceof BlockItem) {
														return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
													}
													return Blocks.AIR.getDefaultState();
												}
											}.toBlock((loc))), 3);
								}
							}
						}
					} else if ((Math.abs((Ez)) >= (Em))) {
						if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + ((Ez) / Math.abs((Ez)))))))
								.getMaterial() == net.minecraft.block.material.Material.AIR)) {
							{
								Map<String, Object> $_dependencies = new HashMap<>();
								$_dependencies.put("world", world);
								$_dependencies.put("x", x);
								$_dependencies.put("y", y);
								$_dependencies.put("z", z);
								ChargeRemoveProcedure.executeProcedure($_dependencies);
							}
							loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
							world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + ((Ez) / Math.abs((Ez))))), /* @BlockState */(new Object() {
								public BlockState toBlock(ItemStack _stk) {
									if (_stk.getItem() instanceof BlockItem) {
										return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
									}
									return Blocks.AIR.getDefaultState();
								}
							}.toBlock((loc))), 3);
						} else if ((Math.abs((Ey)) >= (Em))) {
							if (((world.getBlockState(new BlockPos((int) x, (int) (y + ((Ey) / Math.abs((Ey)))), (int) z)))
									.getMaterial() == net.minecraft.block.material.Material.AIR)) {
								{
									Map<String, Object> $_dependencies = new HashMap<>();
									$_dependencies.put("world", world);
									$_dependencies.put("x", x);
									$_dependencies.put("y", y);
									$_dependencies.put("z", z);
									ChargeRemoveProcedure.executeProcedure($_dependencies);
								}
								loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
								world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
								world.setBlockState(new BlockPos((int) x, (int) (y + ((Ey) / Math.abs((Ey)))), (int) z),
										/* @BlockState */(new Object() {
											public BlockState toBlock(ItemStack _stk) {
												if (_stk.getItem() instanceof BlockItem) {
													return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
												}
												return Blocks.AIR.getDefaultState();
											}
										}.toBlock((loc))), 3);
							}
						}
					}
				} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + ((Ez) / Math.abs((Ez)))))))
						.getMaterial() == net.minecraft.block.material.Material.AIR)) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						ChargeRemoveProcedure.executeProcedure($_dependencies);
					}
					loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + ((Ez) / Math.abs((Ez))))), /* @BlockState */(new Object() {
						public BlockState toBlock(ItemStack _stk) {
							if (_stk.getItem() instanceof BlockItem) {
								return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
							}
							return Blocks.AIR.getDefaultState();
						}
					}.toBlock((loc))), 3);
				} else {
					if ((Math.abs((Ex)) >= (Em))) {
						if (((world.getBlockState(new BlockPos((int) (x + Math.round(((Ex) / Math.abs((Ex))))), (int) y, (int) z)))
								.getMaterial() == net.minecraft.block.material.Material.AIR)) {
							{
								Map<String, Object> $_dependencies = new HashMap<>();
								$_dependencies.put("world", world);
								$_dependencies.put("x", x);
								$_dependencies.put("y", y);
								$_dependencies.put("z", z);
								ChargeRemoveProcedure.executeProcedure($_dependencies);
							}
							loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
							world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
							world.setBlockState(new BlockPos((int) (x + ((Ex) / Math.abs((Ex)))), (int) y, (int) z), /* @BlockState */(new Object() {
								public BlockState toBlock(ItemStack _stk) {
									if (_stk.getItem() instanceof BlockItem) {
										return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
									}
									return Blocks.AIR.getDefaultState();
								}
							}.toBlock((loc))), 3);
						} else if ((Math.abs((Ey)) >= (Em))) {
							if (((world.getBlockState(new BlockPos((int) x, (int) (y + ((Ey) / Math.abs((Ey)))), (int) z)))
									.getMaterial() == net.minecraft.block.material.Material.AIR)) {
								{
									Map<String, Object> $_dependencies = new HashMap<>();
									$_dependencies.put("world", world);
									$_dependencies.put("x", x);
									$_dependencies.put("y", y);
									$_dependencies.put("z", z);
									ChargeRemoveProcedure.executeProcedure($_dependencies);
								}
								loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
								world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
								world.setBlockState(new BlockPos((int) x, (int) (y + ((Ey) / Math.abs((Ey)))), (int) z),
										/* @BlockState */(new Object() {
											public BlockState toBlock(ItemStack _stk) {
												if (_stk.getItem() instanceof BlockItem) {
													return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
												}
												return Blocks.AIR.getDefaultState();
											}
										}.toBlock((loc))), 3);
							}
						}
					}
				}
			} else if ((Math.abs((Ex)) >= Math.abs((Ez)))) {
				if (((world.getBlockState(new BlockPos((int) x, (int) (y + ((Ey) / Math.abs((Ey)))), (int) z)))
						.getMaterial() == net.minecraft.block.material.Material.AIR)) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						ChargeRemoveProcedure.executeProcedure($_dependencies);
					}
					loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y + ((Ey) / Math.abs((Ey)))), (int) z), /* @BlockState */(new Object() {
						public BlockState toBlock(ItemStack _stk) {
							if (_stk.getItem() instanceof BlockItem) {
								return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
							}
							return Blocks.AIR.getDefaultState();
						}
					}.toBlock((loc))), 3);
				} else if ((Math.abs((Ex)) >= (Em))) {
					if (((world.getBlockState(new BlockPos((int) (x + Math.round(((Ex) / Math.abs((Ex))))), (int) y, (int) z)))
							.getMaterial() == net.minecraft.block.material.Material.AIR)) {
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x", x);
							$_dependencies.put("y", y);
							$_dependencies.put("z", z);
							ChargeRemoveProcedure.executeProcedure($_dependencies);
						}
						loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos((int) (x + ((Ex) / Math.abs((Ex)))), (int) y, (int) z), /* @BlockState */(new Object() {
							public BlockState toBlock(ItemStack _stk) {
								if (_stk.getItem() instanceof BlockItem) {
									return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
								}
								return Blocks.AIR.getDefaultState();
							}
						}.toBlock((loc))), 3);
					} else if ((Math.abs((Ez)) >= (Em))) {
						if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + ((Ez) / Math.abs((Ez)))))))
								.getMaterial() == net.minecraft.block.material.Material.AIR)) {
							{
								Map<String, Object> $_dependencies = new HashMap<>();
								$_dependencies.put("world", world);
								$_dependencies.put("x", x);
								$_dependencies.put("y", y);
								$_dependencies.put("z", z);
								ChargeRemoveProcedure.executeProcedure($_dependencies);
							}
							loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
							world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
							world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + ((Ez) / Math.abs((Ez))))), /* @BlockState */(new Object() {
								public BlockState toBlock(ItemStack _stk) {
									if (_stk.getItem() instanceof BlockItem) {
										return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
									}
									return Blocks.AIR.getDefaultState();
								}
							}.toBlock((loc))), 3);
						}
					}
				}
			} else if ((Math.abs((Ey)) >= Math.abs((Ez)))) {
				if (((world.getBlockState(new BlockPos((int) x, (int) (y + ((Ey) / Math.abs((Ey)))), (int) z)))
						.getMaterial() == net.minecraft.block.material.Material.ROCK)) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						ChargeRemoveProcedure.executeProcedure($_dependencies);
					}
					loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) (y + ((Ey) / Math.abs((Ey)))), (int) z), /* @BlockState */(new Object() {
						public BlockState toBlock(ItemStack _stk) {
							if (_stk.getItem() instanceof BlockItem) {
								return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
							}
							return Blocks.AIR.getDefaultState();
						}
					}.toBlock((loc))), 3);
				} else if ((Math.abs((Ez)) >= (Em))) {
					if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + ((Ez) / Math.abs((Ez)))))))
							.getMaterial() == net.minecraft.block.material.Material.AIR)) {
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x", x);
							$_dependencies.put("y", y);
							$_dependencies.put("z", z);
							ChargeRemoveProcedure.executeProcedure($_dependencies);
						}
						loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + ((Ez) / Math.abs((Ez))))), /* @BlockState */(new Object() {
							public BlockState toBlock(ItemStack _stk) {
								if (_stk.getItem() instanceof BlockItem) {
									return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
								}
								return Blocks.AIR.getDefaultState();
							}
						}.toBlock((loc))), 3);
					} else if ((Math.abs((Ex)) >= (Em))) {
						if (((world.getBlockState(new BlockPos((int) (x + Math.round(((Ex) / Math.abs((Ex))))), (int) y, (int) z)))
								.getMaterial() == net.minecraft.block.material.Material.AIR)) {
							{
								Map<String, Object> $_dependencies = new HashMap<>();
								$_dependencies.put("world", world);
								$_dependencies.put("x", x);
								$_dependencies.put("y", y);
								$_dependencies.put("z", z);
								ChargeRemoveProcedure.executeProcedure($_dependencies);
							}
							loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
							world.setBlockState(new BlockPos((int) (x + ((Ex) / Math.abs((Ex)))), (int) y, (int) z), /* @BlockState */(new Object() {
								public BlockState toBlock(ItemStack _stk) {
									if (_stk.getItem() instanceof BlockItem) {
										return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
									}
									return Blocks.AIR.getDefaultState();
								}
							}.toBlock((loc))), 3);
							world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
						}
					}
				}
			} else {
				if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + ((Ez) / Math.abs((Ez)))))))
						.getMaterial() == net.minecraft.block.material.Material.AIR)) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						ChargeRemoveProcedure.executeProcedure($_dependencies);
					}
					loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + ((Ez) / Math.abs((Ez))))), /* @BlockState */(new Object() {
						public BlockState toBlock(ItemStack _stk) {
							if (_stk.getItem() instanceof BlockItem) {
								return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
							}
							return Blocks.AIR.getDefaultState();
						}
					}.toBlock((loc))), 3);
				} else if ((Math.abs((Ey)) >= (Em))) {
					if (((world.getBlockState(new BlockPos((int) x, (int) (y + ((Ey) / Math.abs((Ey)))), (int) z)))
							.getMaterial() == net.minecraft.block.material.Material.AIR)) {
						{
							Map<String, Object> $_dependencies = new HashMap<>();
							$_dependencies.put("world", world);
							$_dependencies.put("x", x);
							$_dependencies.put("y", y);
							$_dependencies.put("z", z);
							ChargeRemoveProcedure.executeProcedure($_dependencies);
						}
						loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
						world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
						world.setBlockState(new BlockPos((int) x, (int) (y + ((Ey) / Math.abs((Ey)))), (int) z), /* @BlockState */(new Object() {
							public BlockState toBlock(ItemStack _stk) {
								if (_stk.getItem() instanceof BlockItem) {
									return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
								}
								return Blocks.AIR.getDefaultState();
							}
						}.toBlock((loc))), 3);
					} else if ((Math.abs((Ex)) >= (Em))) {
						if (((world.getBlockState(new BlockPos((int) (x + Math.round(((Ex) / Math.abs((Ex))))), (int) y, (int) z)))
								.getMaterial() == net.minecraft.block.material.Material.AIR)) {
							{
								Map<String, Object> $_dependencies = new HashMap<>();
								$_dependencies.put("world", world);
								$_dependencies.put("x", x);
								$_dependencies.put("y", y);
								$_dependencies.put("z", z);
								ChargeRemoveProcedure.executeProcedure($_dependencies);
							}
							loc = (new ItemStack((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()));
							world.setBlockState(new BlockPos((int) (x + ((Ex) / Math.abs((Ex)))), (int) y, (int) z), /* @BlockState */(new Object() {
								public BlockState toBlock(ItemStack _stk) {
									if (_stk.getItem() instanceof BlockItem) {
										return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
									}
									return Blocks.AIR.getDefaultState();
								}
							}.toBlock((loc))), 3);
							world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
						}
					}
				}
			}
		}
	}
}
