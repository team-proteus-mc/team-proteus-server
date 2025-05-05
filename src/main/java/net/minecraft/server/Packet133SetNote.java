// Decompiled with: CFR 0.152
// Class Version: 8
package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet133SetNote
extends Packet {
    public int a;
    public int b;
    public int c;
    public byte note;

    public Packet133SetNote() {
        this.k = true;
    }

    public Packet133SetNote(int n, int n2, int n3, byte by) {
        this.k = true;
        this.a = n;
        this.b = n2;
        this.c = n3;
        this.note = by;
    }

    @Override
    public void a(DataInputStream dis) throws IOException {
        this.a = dis.readInt();
        this.b = dis.readShort();
        this.c = dis.readInt();
        this.note = dis.readByte();
    }

    @Override
    public void a(DataOutputStream dos) throws IOException {
        dos.writeInt(this.a);
        dos.writeShort(this.b);
        dos.writeInt(this.c);
        dos.writeByte(this.note);
    }

    @Override
    public void a(NetHandler netHandler) {
        netHandler.a(this);
    }

    @Override
    public int a() {
        return 14;
    }
}
