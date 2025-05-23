package net.minecraft.server;

public class TileEntityNote extends TileEntity {

    public byte note = 0;
    public boolean b = false;

    public TileEntityNote() {}

    public void b(NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.a("note", this.note);
    }

    public void a(NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.note = nbttagcompound.c("note");
        if (this.note < 0) {
            this.note = 0;
        }

        if (this.note > 48) {
            this.note = 48;
        }
    }

    public void a(boolean crouch) {
        if (crouch) {
            this.note = (byte)((this.note + 48) % 49);
            this.update();
        } else {
            this.note = (byte)((this.note + 1) % 49);
            this.update();
        }
        ((WorldServer)this.world).server.serverConfigurationManager.sendPacketNearby((double)this.x + 0.5, (double)this.y + 0.5, (double)this.z + 0.5, 256.0, ((WorldServer)this.world).dimension, this.f());
    }

    public void play(World world, int i, int j, int k) {
        if (world.getMaterial(i, j + 1, k) == Material.AIR) {
            Material material = world.getMaterial(i, j - 1, k);
            byte b0 = 0;

            if (material == Material.STONE) {
                b0 = 1;
            }

            if (material == Material.SAND) {
                b0 = 2;
            }

            if (material == Material.SHATTERABLE) {
                b0 = 3;
            }

            if (material == Material.WOOD) {
                b0 = 4;
            }

            world.playNote(i, j, k, b0, this.note);
        }
    }
}
