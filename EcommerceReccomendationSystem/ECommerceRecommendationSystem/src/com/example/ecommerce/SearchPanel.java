package com.example.ecommerce;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SearchPanel extends JPanel {
    private JTextField searchField;
    private JComboBox<String> searchOptions;
    private JTextArea searchResults;
    private ProductPanel productPanel;

    public SearchPanel(ProductPanel productPanel) {
        this.productPanel = productPanel;

        setLayout(new BorderLayout());

        // Create search panel with options
        JPanel searchPanel = new JPanel();
        searchPanel.add(new JLabel("Search by:"));
        searchOptions = new JComboBox<>(new String[]{"Name", "Description"});
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        searchPanel.add(searchOptions);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.NORTH);

        // Create search results area
        searchResults = new JTextArea();
        searchResults.setEditable(false);
        add(new JScrollPane(searchResults), BorderLayout.CENTER);

        // Add search button action listener
        searchButton.addActionListener(e -> searchProducts());
    }

    private void searchProducts() {
        String searchText = searchField.getText().toLowerCase();
        String searchBy = (String) searchOptions.getSelectedItem();
        List<Product> filteredProducts = new ArrayList<>();

        if (searchBy.equals("Name")) {
            filteredProducts = searchByName(searchText);
        } else if (searchBy.equals("Description")) {
            filteredProducts = searchByDescription(searchText);
        }

        displayResults(filteredProducts);
    }

    private List<Product> searchByName(String searchText) {
        List<Product> results = new ArrayList<>();
        for (Product product : productPanel.products) {
            if (product.getName().toLowerCase().contains(searchText)) {
                results.add(product);
            }
        }
        return results;
    }

    private List<Product> searchByDescription(String searchText) {
        List<Product> results = new ArrayList<>();
        for (Product product : productPanel.products) {
            if (product.getDescription().toLowerCase().contains(searchText)) {
                results.add(product);
            }
        }
        return results;
    }

    private void displayResults(List<Product> products) {
        searchResults.setText("");
        for (Product product : products) {
            searchResults.append("Name: " + product.getName() + "\n");
            searchResults.append("Description: " + product.getDescription() + "\n");
            searchResults.append("Price: $" + product.getPrice() + "\n");
            searchResults.append("Rating: " + product.getRating() + "\n");
            searchResults.append("Popularity: " + product.getPopularity() + "\n");
            searchResults.append("-------------------------------\n");
        }
    }
}
