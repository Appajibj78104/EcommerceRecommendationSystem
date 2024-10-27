package com.example.ecommerce;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class RecommendationPanel extends JPanel {
    private ProductPanel productPanel;
    private DefaultTableModel tableModel;
    private JTable recommendationTable;
    private RecommendationEngine recommendationEngine;

    public RecommendationPanel(ProductPanel productPanel) {
        this.productPanel = productPanel;
        this.recommendationEngine = new RecommendationEngine(productPanel.products);

        setLayout(new BorderLayout());

        // Create table model with headers
        String[] columns = {"Name", "Price", "Rating", "Popularity", "Description"};
        tableModel = new DefaultTableModel(columns, 0);
        recommendationTable = new JTable(tableModel);
        add(new JScrollPane(recommendationTable), BorderLayout.CENTER);

        add(createRecommendationPanel(), BorderLayout.NORTH);
    }

    private JPanel createRecommendationPanel() {
        JPanel recommendationPanel = new JPanel();
        JLabel recommendationLabel = new JLabel("Recommend by:");
        String[] options = {
                "Best Sellers", "Personalized Recommendations", "Related Products",
                "New Arrivals", "Seasonal or Trending Products", "Cross-Selling",
                "Upselling", "Customer Reviews and Ratings", "Discounts and Special Offers"
        };
        JComboBox<String> recommendationComboBox = new JComboBox<>(options);

        recommendationComboBox.addActionListener(e -> {
            String selectedOption = (String) recommendationComboBox.getSelectedItem();
            if (selectedOption != null) {
                Product selectedProduct = getSelectedProduct();
                if (selectedProduct != null) {
                    List<Product> recommendations = recommendationEngine.getRecommendations(selectedProduct, selectedOption);
                    updateTable(recommendations);
                }
            }
        });

        recommendationPanel.add(recommendationLabel);
        recommendationPanel.add(recommendationComboBox);

        return recommendationPanel;
    }

    private Product getSelectedProduct() {
        JTable productTable = productPanel.getProductTable();
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow != -1) {
            return productPanel.products.get(selectedRow);
        }
        JOptionPane.showMessageDialog(this, "Please select a product from the Product Panel first.");
        return null;
    }

    private void updateTable(List<Product> recommendations) {
        tableModel.setRowCount(0);
        for (Product product : recommendations) {
            tableModel.addRow(new Object[]{product.getName(), product.getPrice(), product.getRating(), product.getPopularity(), product.getDescription()});
        }
    }
}
