package com.crosscrux.server.protocol.action;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MouseMoveAction extends Action {
    public short moveX;
    public short moveY;

    public MouseMoveAction(short moveX, short moveY) {
        this.moveX = moveX;
        this.moveY = moveY;
    }

    public static MouseMoveAction parse(DataInputStream dis) throws IOException {
        short moveX = dis.readShort();
        short moveY = dis.readShort();
        return new MouseMoveAction(moveX, moveY);
    }

    public void toDataOutputStream(DataOutputStream dos) throws IOException {
        dos.writeByte(0);
        dos.writeShort(this.moveX);
        dos.writeShort(this.moveY);
    }
}
