package net.minecraft.server;

public class BlockClassicCloth extends BlockCloth {
	
	public BlockClassicCloth(int i) {
		super(i);
	}
	
    public int a(int i, int j) {
    	j &= 15;
        if (j == 0) {
            return this.textureId;
        } else {
            j--;
            return 185 + (j & 3) + ((j & 12) << 2);
        }
    }
	
}
