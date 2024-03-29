package com.crosscrux.server.protocol.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MouseWheelAction extends Action {

    public byte amount;

    public MouseWheelAction(byte amount) {
        this.amount = amount;
    }

    public static MouseWheelAction parse(DataInputStream dis) throws IOException {
        byte amount = dis.readByte();
        return new MouseWheelAction(amount);
    }

    public void toDataOutputStream(DataOutputStream dos) throws IOException {
        dos.writeByte(2);
        dos.writeByte(this.amount);
    }
}
