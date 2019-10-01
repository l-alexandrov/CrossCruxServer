package com.crosscrux.server.protocol.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class AuthenticationAction extends Action {
    public String password;

    public AuthenticationAction(String password) {
        this.password = password;
    }

    public static AuthenticationAction parse(DataInputStream dis) throws IOException {
        String password = dis.readUTF();
        return new AuthenticationAction(password);
    }

    public void toDataOutputStream(DataOutputStream dos) throws IOException {
        dos.writeByte(4);
        dos.writeUTF(this.password);
    }
}