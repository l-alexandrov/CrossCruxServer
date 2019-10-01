package com.crosscrux.server.protocol.action;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ScreenCaptureResponseAction extends Action {
    public byte[] data;
    public int dataSize = 0;

    public ScreenCaptureResponseAction(byte[] data) {
        this.data = data;
        this.dataSize = data.length;
    }

    public ScreenCaptureResponseAction(byte[] data, int dataSize) {
        this.data = data;
        this.dataSize = dataSize;
    }

    public static ScreenCaptureResponseAction parse(DataInputStream dis) throws IOException {
        int dataSize = dis.readInt();
        byte[] data = new byte[dataSize];
        dis.readFully(data);
        return new ScreenCaptureResponseAction(data, dataSize);
    }

    public ScreenCaptureResponseAction parse_(DataInputStream dis) throws IOException {
        this.dataSize = dis.readInt();
        dis.readFully(this.data, 0, this.dataSize);
        return this;
    }

    public void toDataOutputStream(DataOutputStream dos) throws IOException {
        dos.writeByte(7);
        dos.writeInt(this.data.length);
        dos.write(this.data);
    }
}
