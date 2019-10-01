package com.crosscrux.server.protocol;


import com.crosscrux.server.protocol.action.Action;
import com.crosscrux.server.protocol.action.ScreenCaptureResponseAction;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class Connection {
    public static final String BLUETOOTH_UUID = "300ad0a7-059d-4d97-b9a3-eabe5f6af813";
    public static final String DEFAULT_PASSWORD = "remote";
    private final DataInputStream dataInputStream;
    private final OutputStream outputStream;
    private Action capAction = new ScreenCaptureResponseAction(new byte[3000000]);
    public boolean active = true;

    public Connection(InputStream inputStream, OutputStream outputStream) {
        this.dataInputStream = new DataInputStream(inputStream);
        this.outputStream = outputStream;
    }

    public Action receiveAction() throws IOException {
        synchronized(this.dataInputStream) {
            Action action;
            try {
                byte type = this.dataInputStream.readByte();
                if (type == 7) {
                    return ((ScreenCaptureResponseAction) this.capAction).parse_(this.dataInputStream);
                }

                action = Action.parse(this.dataInputStream, type);
            } catch (IOException var4) {
                this.active = false;
                throw var4;
            }

            return action;
        }
    }

    public void sendAction(Action action) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        action.toDataOutputStream(new DataOutputStream(baos));
        synchronized(this.outputStream) {
            this.outputStream.write(baos.toByteArray());
            this.outputStream.flush();
        }
    }

    public void close() throws IOException {
        this.dataInputStream.close();
        this.outputStream.close();
    }
}

