package net.minecraft.server;

import java.util.ArrayList;

import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.entity.CraftEntity;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EntityChicken extends EntityAnimal {

    public boolean a = false;
    public float b = 0.0F;
    public float c = 0.0F;
    public float f;
    public float g;
    public float h = 1.0F;
    public int i;

    public EntityChicken(World world) {
        super(world);
        this.texture = "/mob/chicken.png";
        this.b(0.3F, 0.4F);
        this.health = 4;
        this.i = this.random.nextInt(6000) + 6000;
    }

    public void v() {
        super.v();
        this.g = this.b;
        this.f = this.c;
        this.c = (float) ((double) this.c + (double) (this.onGround ? -1 : 4) * 0.3D);
        if (this.c < 0.0F) {
            this.c = 0.0F;
        }

        if (this.c > 1.0F) {
            this.c = 1.0F;
        }

        if (!this.onGround && this.h < 1.0F) {
            this.h = 1.0F;
        }

        this.h = (float) ((double) this.h * 0.9D);
        if (!this.onGround && this.motY < 0.0D) {
            this.motY *= 0.6D;
        }

        this.b += this.h * 2.0F;
        if (!this.world.isStatic && --this.i <= 0) {
            this.world.makeSound(this, "mob.chickenplop", 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.b(Item.EGG.id, 1);
            this.i = this.random.nextInt(6000) + 6000;
        }
    }

    protected void a(float f) {}

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
    }

    protected String g() {
        return "mob.chicken";
    }

    protected String h() {
        return "mob.chickenhurt";
    }

    protected String i() {
        return "mob.chickenhurt";
    }

    protected int j() {
        return Item.FEATHER.id;
    }
    
    @Override
    protected void q() {
        int i = this.j();
        int ii = Item.CHICKEN.id;
        ArrayList<ItemStack> loot = new ArrayList<ItemStack>();
        int count = this.random.nextInt(3);
        if (i > 0 && count > 0) {
            loot.add(new ItemStack(i, count));
        }
        count = this.random.nextInt(3);
        if (ii > 0 && count > 0) {
            loot.add(new ItemStack(ii, 1));
        }
        CraftEntity entity = (CraftEntity)this.getBukkitEntity();
        EntityDeathEvent event = new EntityDeathEvent(entity, loot);
        CraftWorld bworld = this.world.getWorld();
        this.world.getServer().getPluginManager().callEvent(event);
        for (ItemStack stack : event.getDrops()) {
            bworld.dropItemNaturally(entity.getLocation(), stack);
        }
    }
}
