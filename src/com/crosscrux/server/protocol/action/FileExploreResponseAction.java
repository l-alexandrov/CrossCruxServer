package com.crosscrux.server.protocol.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FileExploreResponseAction extends Action {
    public String directory;
    public String[] files;

    public FileExploreResponseAction(String directory, String[] files) {
        this.directory = directory;
        this.files = files;
    }

    public static FileExploreResponseAction parse(DataInputStream dis) throws IOException {
        String directory = dis.readUTF();
        int filesSize = dis.readInt();
        String[] files = new String[filesSize];

        for(int i = 0; i < filesSize; ++i) {
            files[i] = dis.readUTF();
        }

        return new FileExploreResponseAction(directory, files);
    }

    public void toDataOutputStream(DataOutputStream dos) throws IOException {
        dos.writeByte(9);
        dos.writeUTF(this.directory);
        dos.writeInt(this.files.length);
        String[] files;
        int filesLength = (files = this.files).length;

        for(int i = 0; i < filesLength; ++i) {
            String s = files[i];
            dos.writeUTF(s);
        }

    }
}
