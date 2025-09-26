package net.minecraft.server;

public class ItemCobblestone extends ItemBlock {

	public ItemCobblestone(int i) {
		super(i);
        this.d(0);
        this.a(true);
    }

    public int filterData(int i) {
        return i & 1;
    }
}
