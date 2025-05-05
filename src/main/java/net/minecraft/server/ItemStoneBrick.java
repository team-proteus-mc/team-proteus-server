// Decompiled with: CFR 0.152
// Class Version: 8
package net.minecraft.server;

public class ItemStoneBrick
extends ItemBlock {
    private String[] typenames = new String[]{"default", "mossy", "cracked", "chiseled"};

    public ItemStoneBrick(int n) {
        super(n);
        this.d(0);
        this.a(true);
    }

    @Override
    public int filterData(int n) {
        return n;
    }
}
