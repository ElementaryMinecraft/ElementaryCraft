package net.mcreator.elementarycraft.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.IProperty;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.elementarycraft.block.SolarPlasmaBlock;
import net.mcreator.elementarycraft.block.SiliconBlock;
import net.mcreator.elementarycraft.ElementaryCraftModElements;

import java.util.Map;

@ElementaryCraftModElements.ModElement.Tag
public class GrowCoreProcedure extends ElementaryCraftModElements.ModElement {
	public GrowCoreProcedure(ElementaryCraftModElements instance) {
		super(instance, 142);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure GrowCore!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure GrowCore!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure GrowCore!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure GrowCore!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.getWorld().isRemote) {
			BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
			TileEntity _tileEntity = world.getTileEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_tileEntity != null)
				_tileEntity.getTileData().putDouble("radius", ((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "radius")) + 1));
			world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
		}
		if ((((new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "maxCoreRadius")) - (new Object() {
			public double getValue(BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "lifeStage"))) <= 0)) {
			if (!world.getWorld().isRemote) {
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putBoolean("explode", (true));
				world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else {
			if (((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "radius")) <= ((new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "maxCoreRadius")) - (new Object() {
				public double getValue(BlockPos pos, String tag) {
					TileEntity tileEntity = world.getTileEntity(pos);
					if (tileEntity != null)
						return tileEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(new BlockPos((int) x, (int) y, (int) z), "lifeStage"))))) {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("xcoord", (new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "radius")));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				for (int index0 = 0; index0 < (int) ((((new Object() {
					public double getValue(BlockPos pos, String tag) {
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity != null)
							return tileEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(new BlockPos((int) x, (int) y, (int) z), "radius")) * 2) + 1)); index0++) {
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("ycoord", (new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) x, (int) y, (int) z), "radius")));
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					for (int index1 = 0; index1 < (int) ((((new Object() {
						public double getValue(BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(new BlockPos((int) x, (int) y, (int) z), "radius")) * 2) + 1)); index1++) {
						if (!world.getWorld().isRemote) {
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							TileEntity _tileEntity = world.getTileEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().putDouble("zcoord", (new Object() {
									public double getValue(BlockPos pos, String tag) {
										TileEntity tileEntity = world.getTileEntity(pos);
										if (tileEntity != null)
											return tileEntity.getTileData().getDouble(tag);
										return -1;
									}
								}.getValue(new BlockPos((int) x, (int) y, (int) z), "radius")));
							world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
						for (int index2 = 0; index2 < (int) ((((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "radius")) * 2) + 1)); index2++) {
							if (((new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) x, (int) y, (int) z), "radius")) == Math.ceil(Math.sqrt((((new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) x, (int) y, (int) z), "zcoord")) * (new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) x, (int) y, (int) z), "zcoord"))) + (((new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) x, (int) y, (int) z), "ycoord")) * (new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) x, (int) y, (int) z), "ycoord"))) + ((new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) x, (int) y, (int) z), "xcoord")) * (new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) x, (int) y, (int) z), "xcoord"))))))))) {
								if (((new Object() {
									public double getValue(BlockPos pos, String tag) {
										TileEntity tileEntity = world.getTileEntity(pos);
										if (tileEntity != null)
											return tileEntity.getTileData().getDouble(tag);
										return -1;
									}
								}.getValue(new BlockPos((int) x, (int) y, (int) z), "lifeStage")) == 1)) {
									if (((world.getBlockState(new BlockPos((int) (x + (new Object() {
										public double getValue(BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(new BlockPos((int) x, (int) y, (int) z), "xcoord"))), (int) (y + (new Object() {
										public double getValue(BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(new BlockPos((int) x, (int) y, (int) z), "ycoord"))), (int) (z + (new Object() {
										public double getValue(BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(new BlockPos((int) x, (int) y, (int) z), "zcoord")))))).getBlock() == SolarPlasmaBlock.block
											.getDefaultState().getBlock())) {
										{
											BlockPos _bp = new BlockPos((int) (x + (new Object() {
												public double getValue(BlockPos pos, String tag) {
													TileEntity tileEntity = world.getTileEntity(pos);
													if (tileEntity != null)
														return tileEntity.getTileData().getDouble(tag);
													return -1;
												}
											}.getValue(new BlockPos((int) x, (int) y, (int) z), "xcoord"))), (int) (y + (new Object() {
												public double getValue(BlockPos pos, String tag) {
													TileEntity tileEntity = world.getTileEntity(pos);
													if (tileEntity != null)
														return tileEntity.getTileData().getDouble(tag);
													return -1;
												}
											}.getValue(new BlockPos((int) x, (int) y, (int) z), "ycoord"))), (int) (z + (new Object() {
												public double getValue(BlockPos pos, String tag) {
													TileEntity tileEntity = world.getTileEntity(pos);
													if (tileEntity != null)
														return tileEntity.getTileData().getDouble(tag);
													return -1;
												}
											}.getValue(new BlockPos((int) x, (int) y, (int) z), "zcoord"))));
											BlockState _bs = Blocks.COAL_BLOCK.getDefaultState();
											BlockState _bso = world.getBlockState(_bp);
											for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
												IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
												if (_bs.has(_property))
													_bs = _bs.with(_property, (Comparable) entry.getValue());
											}
											world.setBlockState(_bp, _bs, 3);
										}
									}
								} else {
									if (((new Object() {
										public double getValue(BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(new BlockPos((int) x, (int) y, (int) z), "lifeStage")) == 2)) {
										if (((world.getBlockState(new BlockPos((int) (x + (new Object() {
											public double getValue(BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(new BlockPos((int) x, (int) y, (int) z), "xcoord"))), (int) (y + (new Object() {
											public double getValue(BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(new BlockPos((int) x, (int) y, (int) z), "ycoord"))), (int) (z + (new Object() {
											public double getValue(BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(new BlockPos((int) x, (int) y, (int) z), "zcoord")))))).getBlock() == Blocks.COAL_BLOCK
												.getDefaultState().getBlock())) {
											{
												BlockPos _bp = new BlockPos((int) (x + (new Object() {
													public double getValue(BlockPos pos, String tag) {
														TileEntity tileEntity = world.getTileEntity(pos);
														if (tileEntity != null)
															return tileEntity.getTileData().getDouble(tag);
														return -1;
													}
												}.getValue(new BlockPos((int) x, (int) y, (int) z), "xcoord"))), (int) (y + (new Object() {
													public double getValue(BlockPos pos, String tag) {
														TileEntity tileEntity = world.getTileEntity(pos);
														if (tileEntity != null)
															return tileEntity.getTileData().getDouble(tag);
														return -1;
													}
												}.getValue(new BlockPos((int) x, (int) y, (int) z), "ycoord"))), (int) (z + (new Object() {
													public double getValue(BlockPos pos, String tag) {
														TileEntity tileEntity = world.getTileEntity(pos);
														if (tileEntity != null)
															return tileEntity.getTileData().getDouble(tag);
														return -1;
													}
												}.getValue(new BlockPos((int) x, (int) y, (int) z), "zcoord"))));
												BlockState _bs = SiliconBlock.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_bs.has(_property))
														_bs = _bs.with(_property, (Comparable) entry.getValue());
												}
												world.setBlockState(_bp, _bs, 3);
											}
										}
									} else {
										if (((new Object() {
											public double getValue(BlockPos pos, String tag) {
												TileEntity tileEntity = world.getTileEntity(pos);
												if (tileEntity != null)
													return tileEntity.getTileData().getDouble(tag);
												return -1;
											}
										}.getValue(new BlockPos((int) x, (int) y, (int) z), "lifeStage")) == 3)) {
											if (((world.getBlockState(new BlockPos((int) (x + (new Object() {
												public double getValue(BlockPos pos, String tag) {
													TileEntity tileEntity = world.getTileEntity(pos);
													if (tileEntity != null)
														return tileEntity.getTileData().getDouble(tag);
													return -1;
												}
											}.getValue(new BlockPos((int) x, (int) y, (int) z), "xcoord"))), (int) (y + (new Object() {
												public double getValue(BlockPos pos, String tag) {
													TileEntity tileEntity = world.getTileEntity(pos);
													if (tileEntity != null)
														return tileEntity.getTileData().getDouble(tag);
													return -1;
												}
											}.getValue(new BlockPos((int) x, (int) y, (int) z), "ycoord"))), (int) (z + (new Object() {
												public double getValue(BlockPos pos, String tag) {
													TileEntity tileEntity = world.getTileEntity(pos);
													if (tileEntity != null)
														return tileEntity.getTileData().getDouble(tag);
													return -1;
												}
											}.getValue(new BlockPos((int) x, (int) y, (int) z), "zcoord")))))).getBlock() == SiliconBlock.block
													.getDefaultState().getBlock())) {
												{
													BlockPos _bp = new BlockPos((int) (x + (new Object() {
														public double getValue(BlockPos pos, String tag) {
															TileEntity tileEntity = world.getTileEntity(pos);
															if (tileEntity != null)
																return tileEntity.getTileData().getDouble(tag);
															return -1;
														}
													}.getValue(new BlockPos((int) x, (int) y, (int) z), "xcoord"))), (int) (y + (new Object() {
														public double getValue(BlockPos pos, String tag) {
															TileEntity tileEntity = world.getTileEntity(pos);
															if (tileEntity != null)
																return tileEntity.getTileData().getDouble(tag);
															return -1;
														}
													}.getValue(new BlockPos((int) x, (int) y, (int) z), "ycoord"))), (int) (z + (new Object() {
														public double getValue(BlockPos pos, String tag) {
															TileEntity tileEntity = world.getTileEntity(pos);
															if (tileEntity != null)
																return tileEntity.getTileData().getDouble(tag);
															return -1;
														}
													}.getValue(new BlockPos((int) x, (int) y, (int) z), "zcoord"))));
													BlockState _bs = Blocks.IRON_BLOCK.getDefaultState();
													BlockState _bso = world.getBlockState(_bp);
													for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
														IProperty _property = _bs.getBlock().getStateContainer()
																.getProperty(entry.getKey().getName());
														if (_bs.has(_property))
															_bs = _bs.with(_property, (Comparable) entry.getValue());
													}
													world.setBlockState(_bp, _bs, 3);
												}
											}
										} else {
											if (!world.getWorld().isRemote) {
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												TileEntity _tileEntity = world.getTileEntity(_bp);
												BlockState _bs = world.getBlockState(_bp);
												if (_tileEntity != null)
													_tileEntity.getTileData().putBoolean("explode", (true));
												world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
											}
										}
									}
								}
							}
							if (!world.getWorld().isRemote) {
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								TileEntity _tileEntity = world.getTileEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_tileEntity != null)
									_tileEntity.getTileData().putDouble("zcoord", ((new Object() {
										public double getValue(BlockPos pos, String tag) {
											TileEntity tileEntity = world.getTileEntity(pos);
											if (tileEntity != null)
												return tileEntity.getTileData().getDouble(tag);
											return -1;
										}
									}.getValue(new BlockPos((int) x, (int) y, (int) z), "zcoord")) - 1));
								world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
							}
						}
						if (!world.getWorld().isRemote) {
							BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
							TileEntity _tileEntity = world.getTileEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getTileData().putDouble("ycoord", ((new Object() {
									public double getValue(BlockPos pos, String tag) {
										TileEntity tileEntity = world.getTileEntity(pos);
										if (tileEntity != null)
											return tileEntity.getTileData().getDouble(tag);
										return -1;
									}
								}.getValue(new BlockPos((int) x, (int) y, (int) z), "ycoord")) - 1));
							world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
						}
					}
					if (!world.getWorld().isRemote) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("xcoord", ((new Object() {
								public double getValue(BlockPos pos, String tag) {
									TileEntity tileEntity = world.getTileEntity(pos);
									if (tileEntity != null)
										return tileEntity.getTileData().getDouble(tag);
									return -1;
								}
							}.getValue(new BlockPos((int) x, (int) y, (int) z), "xcoord")) - 1));
						world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			} else {
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("radius", 0);
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if (!world.getWorld().isRemote) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putDouble("lifeStage", ((new Object() {
							public double getValue(BlockPos pos, String tag) {
								TileEntity tileEntity = world.getTileEntity(pos);
								if (tileEntity != null)
									return tileEntity.getTileData().getDouble(tag);
								return -1;
							}
						}.getValue(new BlockPos((int) x, (int) y, (int) z), "lifeStage")) + 1));
					world.getWorld().notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
			}
		}
	}
}
