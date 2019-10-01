package com.crosscrux.server.connection;
import com.crosscrux.server.protocol.Connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TCPConnection extends Connection {
    public static final int DEFAULT_PORT = 64788;
    private Socket socket;

    public TCPConnection(Socket socket) throws IOException {
        super(socket.getInputStream(), socket.getOutputStream());
        this.socket = socket;
        this.socket.setPerformancePreferences(0, 2, 1);
        this.socket.setTcpNoDelay(true);
        this.socket.setReceiveBufferSize(1048576);
        this.socket.setSendBufferSize(1048576);
    }

    public static TCPConnection create(String host, int port) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(host, port), 1000);
        return new TCPConnection(socket);
    }

    public InetAddress getInetAddress() {
        return this.socket.getInetAddress();
    }

    public int getPort() {
        return this.socket.getPort();
    }

    public void close() throws IOException {
        this.socket.shutdownInput();
        this.socket.shutdownOutput();
        super.close();
        this.socket.close();
    }
}
