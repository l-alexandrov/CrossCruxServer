package com.crosscrux.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.MalformedURLException;
import java.net.URL;

public class App {


    private JPanel panel1;
    private JFrame frame;
    private JButton OKButton;

    public App() {
        frame = new JFrame("CrossCrux Server");
        frame.setSize(400, 400);
        frame.setLocation(400,400);
        frame.add(panel1);
        try{
            URL url = new URL("https","public.slidesharecdn.com","/images/logo/linkedin-ss/SS_Logo_White_Large.png"); //TODO: Change Icon
            frame.setIconImage(Toolkit.getDefaultToolkit().createImage(url));
            System.out.println(url.toString());
        }catch (MalformedURLException e) {
            System.exit(-1);
            System.out.println(e.toString());
        }
        frame.setVisible(true);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }
}
