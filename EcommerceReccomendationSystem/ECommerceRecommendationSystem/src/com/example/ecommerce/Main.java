package com.example.ecommerce;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Ensures that the GUI is created and updated on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            // Create and display the main application window
            new MainFrame();
        });
    }
}