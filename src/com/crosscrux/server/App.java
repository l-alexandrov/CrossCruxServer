package com.crosscrux.server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel panel1;
    private JButton ОКButton;
    private JLabel HelloText;
    private JLabel Description;

    public App() {
        ОКButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setVisible(false);
            }
        });
    }
}
