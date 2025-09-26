package net.minecraft.server;

public class BlockCobblestone extends Block {
	public BlockCobblestone(int id) {
		super(id, 16, Material.STONE);
	}
	
    protected int a_(int i) {
        return i & 1;
    }
}
