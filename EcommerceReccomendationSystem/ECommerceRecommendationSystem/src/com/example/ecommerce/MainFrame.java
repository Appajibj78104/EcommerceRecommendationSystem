package com.example.ecommerce;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private WelcomePanel welcomePanel;
    private JPanel mainPanel;
    private JPanel controlPanel;
    private ProductPanel productPanel;
    private SearchPanel searchPanel;
    private RecommendationPanel recommendationPanel;

    public MainFrame() {
        setTitle("E-Commerce System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panels
        productPanel = new ProductPanel();
        searchPanel = new SearchPanel(productPanel);
        recommendationPanel = new RecommendationPanel(productPanel);
        welcomePanel = new WelcomePanel(this);

        // Main panel to hold other panels
        mainPanel = new JPanel(new CardLayout());

        mainPanel.add(productPanel, "ProductPanel");
        mainPanel.add(searchPanel, "SearchPanel");
        mainPanel.add(recommendationPanel, "RecommendationPanel");

        // Create control panel
        controlPanel = new JPanel();
        JButton productButton = new JButton("Product Panel");
        JButton searchButton = new JButton("Search Panel");
        JButton recommendationButton = new JButton("Recommendation Panel");

        productButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "ProductPanel");
        });

        searchButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "SearchPanel");
        });

        recommendationButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.show(mainPanel, "RecommendationPanel");
        });

        controlPanel.add(productButton);
        controlPanel.add(searchButton);
        controlPanel.add(recommendationButton);

        // Initially show the welcome panel
        add(welcomePanel);
    }

    public void showMainInterface() {
        remove(welcomePanel);
        add(controlPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}

