package net.minecraft.server;

import java.util.Random;

public class BlockStep extends Block {

	public static final String[] a = new String[]{"stone", "sand", "wood", "cobble", "", "", "", ""};
    private boolean b;
    private boolean b2;
    
    public BlockStep(int i, boolean flag) {
        super(i, 6, Material.STONE);
        this.f(255);
        this.b = flag;
        if (!flag) {
            this.f(0);
        }
    }
    
    public void a(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = var1.getData(var2, var3, var4);
        if (this.b) {
            this.b2 = false;
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        } else if (var5 < 8) {
            this.b2 = false;
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f);
        } else if (var5 >= 8) {
            this.b2 = true;
            this.a(0.0f, 0.5f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }
    
    @Override
    public AxisAlignedBB e(World var1, int var2, int var3, int var4) {
        int var5 = var1.getData(var2, var3, var4);
        return !this.b ? 
        		this.e(var1, var2, var3, var4, var5) : 
        			AxisAlignedBB.b((double)var2 + 0.0, (double)var3 + 0.0, (double)var4 + 0.0, (double)var2 + 1.0, (double)var3 + 1.0, (double)var4 + 1.0);
    }

    @Override
    public AxisAlignedBB e(World var1, int var2, int var3, int var4, int var5) {
        return var5 < 8 ? AxisAlignedBB.b((double)var2 + 0.0, (double)var3 + 0.0, (double)var4 + 0.0, (double)var2 + 1.0, (double)var3 + 0.5, (double)var4 + 1.0) : 
        					AxisAlignedBB.b((double)var2 + 0.0, (double)var3 + 0.5, (double)var4 + 0.0, (double)var2 + 1.0, (double)var3 + 1.0, (double)var4 + 1.0);
    }

    public int a(int i, int j) {
        return j == 0 ? (i <= 1 ? 6 : 5) : (j == 1 ? (i == 0 ? 208 : (i == 1 ? 176 : 192)) : (j == 2 ? 4 : (j == 3 ? 16 : 6)));
    }

    public int a(int i) {
        return this.a(i, 0);
    }

    public boolean a() {
        return this.b;
    }

    public int a(int i, Random random) {
        return Block.STEP.id;
    }

    public int a(Random random) {
        return this.b ? 2 : 1;
    }

    protected int a_(int i) {
        return i & 7;
    }

    public boolean b() {
        return this.b;
    }
}
