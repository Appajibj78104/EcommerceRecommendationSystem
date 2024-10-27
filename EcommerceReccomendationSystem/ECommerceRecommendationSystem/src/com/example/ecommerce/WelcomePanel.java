package com.example.ecommerce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class WelcomePanel extends JPanel {

    private JButton getStartedButton;
    private MainFrame mainFrame;

    public WelcomePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to eCommerce", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24));

        // Load the image
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = loadImageIcon("com/example/ecommerce/welcomeimage.jpg");
        if (imageIcon != null) {
            imageLabel.setIcon(imageIcon);
        }

        // Panel to hold the image and welcome label
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(welcomeLabel, BorderLayout.NORTH);
        topPanel.add(imageLabel, BorderLayout.CENTER);

        getStartedButton = new JButton("Get Started");
        getStartedButton.setFont(new Font("Serif", Font.PLAIN, 18));
        getStartedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.showMainInterface();
            }
        });

        add(topPanel, BorderLayout.CENTER);
        add(getStartedButton, BorderLayout.SOUTH);
    }

    private ImageIcon loadImageIcon(String path) {
        URL imgURL = getClass().getClassLoader().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
