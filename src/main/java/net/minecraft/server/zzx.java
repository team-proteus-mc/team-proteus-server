// Decompiled with: CFR 0.152
// Class Version: 8
package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class zzx
extends Packet {
    public String zf;
    public String zd;

    public zzx() {
    }

    public zzx(String string, String string2) {
        this.zf = string;
        this.zd = string2;
    }

    @Override
    public void a(DataInputStream dataInputStream) throws IOException {
        this.zf = zzx.a(dataInputStream, 5);
        this.zd = zzx.a(dataInputStream, 64);
    }

    @Override
    public void a(DataOutputStream dataOutputStream) throws IOException {
        zzx.a(this.zf, dataOutputStream);
        zzx.a(this.zd, dataOutputStream);
    }

    @Override
    public void a(NetHandler netHandler) {
        netHandler.a(this);
    }

    @Override
    public int a() {
        return 69;
    }
}
