// Decompiled with: CFR 0.152
// Class Version: 8
package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet132SetMobSpawner
extends Packet {
    public int a;
    public int b;
    public int c;
    public String spawnType;

    public Packet132SetMobSpawner() {
        this.k = true;
    }

    public Packet132SetMobSpawner(int x, int y, int z, String spawnType2) {
        this.k = true;
        this.a = x;
        this.b = y;
        this.c = z;
        if (spawnType2 == null) {
            spawnType2 = "none";
        }
        this.spawnType = spawnType2;
    }

    @Override
    public void a(DataInputStream dis) throws IOException {
        this.a = dis.readInt();
        this.b = dis.readShort();
        this.c = dis.readInt();
        this.spawnType = Packet132SetMobSpawner.a(dis, 16);
    }

    @Override
    public void a(DataOutputStream dos) throws IOException {
        dos.writeInt(this.a);
        dos.writeShort(this.b);
        dos.writeInt(this.c);
        Packet132SetMobSpawner.a(this.spawnType, dos);
    }

    @Override
    public void a(NetHandler netHandler) {
        netHandler.a(this);
    }

    @Override
    public int a() {
        return 12 + this.spawnType.length();
    }
}
