package net.mcreator.elementarycraft.procedures;

@ElementaryCraftModElements.ModElement.Tag
public class ElectronquantumfieldBlockDropProcedure extends ElementaryCraftModElements.ModElement {

	public ElectronquantumfieldBlockDropProcedure(ElementaryCraftModElements instance) {
		super(instance, 4);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ElectronquantumfieldBlockDrop!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ElectronquantumfieldBlockDrop!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ElectronquantumfieldBlockDrop!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ElectronquantumfieldBlockDrop!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (!world.getWorld().isRemote) {
			ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(ElectronItem.block, (int) (1)));
			entityToSpawn.setPickupDelay(10);
			world.addEntity(entityToSpawn);
		}
		if (!world.getWorld().isRemote) {
			ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(PositronItem.block, (int) (1)));
			entityToSpawn.setPickupDelay(10);
			world.addEntity(entityToSpawn);
		}

	}

}
