package net.minecraft.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet1Login extends Packet {

    public int a;
    public String name;
    public long c;
    public byte d;
    public int tpv;

    public Packet1Login() {}

    public Packet1Login(String s, int i, long j, byte b0) {
        this.name = s;
        this.a = i;
        this.c = j;
        this.d = b0;
        this.tpv = Integer.parseInt(StatisticCollector.a("server.rawversion"));
    }

    public void a(DataInputStream datainputstream) throws IOException {
        this.a = datainputstream.readInt();
        this.name = a(datainputstream, 16);
        this.c = datainputstream.readLong();
        this.d = datainputstream.readByte();
        if (this.a == -14) {
        	this.a = 14;
        	this.tpv = datainputstream.readInt();
        } else {
        	this.tpv = -1;
        }
        
    }

    public void a(DataOutputStream dataoutputstream) throws IOException {
        dataoutputstream.writeInt(this.a);
        a(this.name, dataoutputstream);
        dataoutputstream.writeLong(this.c);
        dataoutputstream.writeByte(this.d);
        dataoutputstream.writeInt(this.tpv);
    }

    public void a(NetHandler nethandler) {
        nethandler.a(this);
    }

    public int a() {
        return 4 + this.name.length() + 4 + 5 + 4;
    }
}