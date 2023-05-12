package com.crosscrux.server;

import com.crosscrux.server.connection.TCPServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public void exit() {
        //this.trayIcon.close();
        if (this.tcpServer != null) {
            this.tcpServer.close();
        }

        /*if (this.serverBluetooth != null) {
            this.serverBluetooth.close();
        }*/

        System.exit(0);
    }

    public static void main(String[] args) {
        try {
            new ServerApp();
            new App();
        /*} catch (AWTException var2) {
            var2.printStackTrace();
            System.exit(1);*/
        } catch (IOException var3) {
            var3.printStackTrace();
            System.exit(1);
        }

    }

    public Preferences getPreferences() {
        return this.preferences;
    }
}
