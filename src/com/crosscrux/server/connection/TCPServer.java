package com.crosscrux.server.connection;

import com.crosscrux.server.ServerApp;
import com.crosscrux.server.protocol.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer extends Server implements Runnable {
    private ServerSocket serverSocket;
    public TCPServer(ServerApp application) throws IOException {
        super(application);
        int port = this.application.getPreferences().getInt("port", 64788);
        this.serverSocket = new ServerSocket(port);
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        try {
            while(true) {
                Socket socket = this.serverSocket.accept();
                TCPConnection connection = new TCPConnection(socket);
                //new Connection(this.application, connection);
            }
        } catch (IOException e) {
            System.out.println("LAN connection broke. This is normal if the server is shutting down.");
        }
    }
}
