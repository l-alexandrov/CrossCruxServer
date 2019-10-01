package com.crosscrux.server.protocol.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class AuthenticationResponseAction extends  Action{
    public boolean authenticated;

    public AuthenticationResponseAction(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public static AuthenticationResponseAction parse(DataInputStream dis) throws IOException {
        boolean authenticated = dis.readBoolean();
        return new AuthenticationResponseAction(authenticated);
    }

    public void toDataOutputStream(DataOutputStream dos) throws IOException {
        dos.writeByte(5);
        dos.writeBoolean(this.authenticated);
    }
}
