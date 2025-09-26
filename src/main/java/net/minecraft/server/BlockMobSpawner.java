package net.minecraft.server;

import java.util.Random;

public class BlockMobSpawner extends BlockContainer {

    protected BlockMobSpawner(int i, int j) {
        super(i, j, Material.STONE);
    }

    protected TileEntity a_() {
        return new TileEntityMobSpawner();
    }

    public int a(int i, Random random) {
        return 0;
    }

    public int a(Random random) {
        return 0;
    }
    
    @Override
    public int a_(int i) {
    	return i;
    }

    public boolean a() {
        return false;
    }
    
    @Override
    public void postPlace(World world, int i, int j, int k, int l) {
        String name = EntityTypes.idToName(l);
        String str1 = EntityTypes.getSpawnType(name);
        boolean legal = str1 != null ? str1 != "illegal" : false;
        TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(i, j, k);
        tileentitymobspawner.a(name != null && legal ? name : "Pig");
    }
}
