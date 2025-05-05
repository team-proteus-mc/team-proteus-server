// Decompiled with: CFR 0.152
// Class Version: 8
package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet244PlayerStance
extends Packet {
    public int entityId;
    public int stance;
    public float height;

    public Packet244PlayerStance() {
    }

    public Packet244PlayerStance(Entity entity, int n, float f) {
        this.entityId = entity.id;
        this.stance = n;
        this.height = f;
    }

    @Override
    public void a(DataInputStream dataInputStream) throws IOException {
        this.entityId = dataInputStream.readInt();
        this.stance = dataInputStream.readInt();
        this.height = dataInputStream.readFloat();
    }

    @Override
    public void a(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.entityId);
        dataOutputStream.writeInt(this.stance);
        dataOutputStream.writeFloat(this.height);
    }

    @Override
    public void a(NetHandler netHandler) {
        netHandler.a(this);
    }

    @Override
    public int a() {
        return 12;
    }
}
