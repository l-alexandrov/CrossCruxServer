package com.crosscrux.server.connection;

import com.crosscrux.server.ServerApp;

public abstract class Server {
    protected ServerApp application;

    public Server(ServerApp application) {
        this.application = application;
    }

    public abstract void close();
}