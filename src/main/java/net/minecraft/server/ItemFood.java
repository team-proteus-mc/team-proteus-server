package net.minecraft.server;

public class ItemFood extends Item {

    private int a;
    private boolean bk;

    public ItemFood(int i, int j, boolean flag) {
        super(i);
        this.a = j;
        this.bk = flag;
        this.maxStackSize = 8;
    }

    @Override
    public ItemStack a(ItemStack itemstack, World world, EntityHuman entityhuman) {
        if (entityhuman.health < 20) {
            --itemstack.count;
            entityhuman.b(this.a);
        }
        return itemstack;
    }

    public int k() {
        return this.a;
    }

    public boolean l() {
        return this.bk;
    }
}
