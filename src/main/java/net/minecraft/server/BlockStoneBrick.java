// Decompiled with: CFR 0.152
// Class Version: 8
package net.minecraft.server;

public class BlockStoneBrick
extends Block {
    public BlockStoneBrick(int n) {
        super(n, 54, Material.STONE);
    }

    @Override
    public int a(int n, int n2) {
        if ((n2 & 3) == 0) {
            return this.textureId;
        }
        if ((n2 & 3) == 3) {
            return 199;
        }
        return 99 + (n2 & 3);
    }

    @Override
    protected int a_(int n) {
        return n;
    }

    public static int c(int n) {
        return ~n & 3;
    }

    public static int d(int n) {
        return ~n & 3;
    }
}
