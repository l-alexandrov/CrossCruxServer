package com.crosscrux.server;

import com.crosscrux.server.connection.TCPServer;

import java.awt.*;
import java.io.IOException;
import java.util.prefs.Preferences;

public class ServerApp {
    public static final boolean IS_WINDOWS = System.getProperty("os.name").toLowerCase().contains("windows");
    private Preferences preferences = Preferences.userNodeForPackage(this.getClass());
    //private RemoteItServerTrayIcon trayIcon = new RemoteItServerTrayIcon(this);
    //private Robot robot = new Robot();
    private TCPServer tcpServer;
    public ServerApp() throws IOException{
        try{
            this.tcpServer = new TCPServer(this);
        }
        catch (IOException e)
        {

        }
    }

    public Preferences getPreferences() {
        return this.preferences;
    }
}
