package com.example.ecommerce;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductPanel extends JPanel {
    List<Product> products;
    private DefaultTableModel tableModel;
    private JTable productTable;
    private Sorting sorting;

    public ProductPanel() {
        this.products = new ArrayList<>();
        this.sorting = new Sorting();

        setLayout(new BorderLayout());

        // Create table model with headers
        String[] columns = {"Name", "Price", "Rating", "Popularity", "Description"};
        tableModel = new DefaultTableModel(columns, 0);
        productTable = new JTable(tableModel);
        add(new JScrollPane(productTable), BorderLayout.CENTER);

        add(createSortPanel(), BorderLayout.NORTH);

        // Add initial products (for demonstration)
        addInitialProducts();
    }

    private void addInitialProducts() {
        // Add TVs
        products.add(new Product(1, "Samsung TV", 799.0, 4.5, 90, "55-inch 4K UHD Smart TV (Best Sellers)", "TV"));
        products.add(new Product(2, "LG TV", 699.0, 4.4, 80, "48-inch OLED TV (New Arrivals)", "TV"));
        products.add(new Product(3, "Sony TV", 899.0, 4.6, 85, "65-inch LED TV (Seasonal)", "TV"));
        products.add(new Product(4, "Panasonic TV", 759.0, 4.3, 70, "50-inch LED TV (Trending Products)", "TV"));
        products.add(new Product(5, "TCL TV", 649.0, 4.2, 75, "55-inch 4K UHD Roku TV (Cross-Selling)", "TV"));
        products.add(new Product(6, "Vizio TV", 679.0, 4.4, 78, "58-inch 4K UHD Smart TV (Upselling)", "TV"));
        products.add(new Product(7, "Philips TV", 699.0, 4.1, 72, "50-inch 4K UHD Smart TV (Seasonal)", "TV"));
        products.add(new Product(8, "Sharp TV", 799.0, 4.3, 80, "60-inch 4K UHD Smart TV (Best Sellers)", "TV"));
        products.add(new Product(9, "Hisense TV", 599.0, 4.0, 68, "55-inch 4K UHD Smart TV (New Arrivals)", "TV"));
        products.add(new Product(10, "Insignia TV", 529.0, 3.9, 65, "50-inch 4K UHD Fire TV (Trending Products)", "TV"));

        // Add Mobiles
        products.add(new Product(11, "iPhone 13", 999.0, 4.8, 300, "Latest Apple smartphone with A15 Bionic chip (Best Sellers)", "Mobile"));
        products.add(new Product(12, "Samsung Galaxy S21", 799.0, 4.7, 280, "Flagship Samsung phone with Exynos 2100 (New Arrivals)", "Mobile"));
        products.add(new Product(13, "Google Pixel 6", 699.0, 4.6, 260, "Google phone with Android 12 and Tensor chip (Seasonal)", "Mobile"));
        products.add(new Product(14, "OnePlus 9", 729.0, 4.5, 240, "High-performance phone with Snapdragon 888 (Trending Products)", "Mobile"));
        products.add(new Product(15, "Xiaomi Mi 11", 749.0, 4.4, 220, "Affordable flagship with Snapdragon 888 (Cross-Selling)", "Mobile"));
        products.add(new Product(16, "Sony Xperia 1 III", 999.0, 4.3, 200, "Sony's flagship phone with 4K display (Upselling)", "Mobile"));
        products.add(new Product(17, "Oppo Find X3 Pro", 899.0, 4.5, 230, "Premium phone with Snapdragon 888 (Seasonal)", "Mobile"));
        products.add(new Product(18, "Vivo X60 Pro+", 799.0, 4.6, 240, "Flagship phone with ZEISS optics (Best Sellers)", "Mobile"));
        products.add(new Product(19, "Asus ROG Phone 5", 999.0, 4.7, 250, "Gaming phone with Snapdragon 888 (New Arrivals)", "Mobile"));
        products.add(new Product(20, "Realme GT", 599.0, 4.4, 210, "Affordable phone with Snapdragon 888 (Trending Products)", "Mobile"));

        // Add Smartwatches
        products.add(new Product(21, "Apple Watch Series 7", 399.0, 4.8, 300, "Smartwatch with advanced health features (Best Sellers)", "Smartwatch"));
        products.add(new Product(22, "Samsung Galaxy Watch 4", 349.0, 4.5, 250, "Smartwatch with fitness tracking (New Arrivals)", "Smartwatch"));
        products.add(new Product(23, "Garmin Forerunner 945", 500.0, 4.7, 280, "GPS smartwatch for runners (Seasonal)", "Smartwatch"));
        products.add(new Product(24, "Fitbit Sense", 299.0, 4.4, 230, "Health smartwatch with stress management (Trending Products)", "Smartwatch"));
        products.add(new Product(25, "Fossil Gen 6", 299.0, 4.3, 220, "Smartwatch with heart rate monitoring (Cross-Selling)", "Smartwatch"));
        products.add(new Product(26, "TicWatch Pro 3", 299.0, 4.2, 210, "Smartwatch with long battery life (Upselling)", "Smartwatch"));
        products.add(new Product(27, "Amazfit GTR 3", 179.0, 4.1, 200, "Smartwatch with extensive fitness features (Seasonal)", "Smartwatch"));
        products.add(new Product(28, "Withings ScanWatch", 299.0, 4.4, 230, "Hybrid smartwatch with ECG and SpO2 monitoring (Best Sellers)", "Smartwatch"));
        products.add(new Product(29, "Huawei Watch GT 3", 329.0, 4.5, 240, "Smartwatch with long battery life (New Arrivals)", "Smartwatch"));
        products.add(new Product(30, "Suunto 7", 399.0, 4.3, 220, "Smartwatch with outdoor maps (Trending Products)", "Smartwatch"));

        // Add Laptops
        products.add(new Product(31, "HP Spectre x360", 1500.0, 4.5, 200, "Convertible laptop with Intel i7, 16GB RAM, 512GB SSD (Best Sellers)", "Laptop"));
        products.add(new Product(32, "Dell XPS 13", 1400.0, 4.7, 180, "Compact laptop with Intel i5, 8GB RAM, 256GB SSD (New Arrivals)", "Laptop"));
        products.add(new Product(33, "Apple MacBook Pro", 2000.0, 4.8, 220, "Powerful laptop with M1 chip, 16GB RAM, 1TB SSD (Trending Products)", "Laptop"));
        products.add(new Product(34, "Lenovo ThinkPad X1 Carbon", 1700.0, 4.6, 190, "Business laptop with Intel i7, 16GB RAM, 1TB SSD (Cross-Selling)", "Laptop"));
        products.add(new Product(35, "Asus ZenBook 14", 1200.0, 4.4, 160, "Ultrabook with AMD Ryzen 5, 8GB RAM, 512GB SSD (Upselling)", "Laptop"));
        products.add(new Product(36, "Microsoft Surface Laptop 4", 1300.0, 4.5, 170, "Laptop with Intel i5, 8GB RAM, 512GB SSD (Seasonal)", "Laptop"));
        products.add(new Product(37, "Acer Swift 3", 800.0, 4.2, 150, "Affordable laptop with Intel i5, 8GB RAM, 256GB SSD (Trending Products)", "Laptop"));
        products.add(new Product(38, "Razer Blade 15", 2500.0, 4.7, 210, "Gaming laptop with Intel i7, 16GB RAM, 1TB SSD (Best Sellers)", "Laptop"));
        products.add(new Product(39, "MSI Prestige 14", 1400.0, 4.5, 180, "Laptop with Intel i7, 16GB RAM, 512GB SSD (New Arrivals)", "Laptop"));
        products.add(new Product(40, "Google Pixelbook Go", 900.0, 4.3, 160, "Chromebook with Intel i5, 8GB RAM, 128GB SSD (Trending Products)", "Laptop"));

        updateTable();
    }

    private void updateTable() {
        tableModel.setRowCount(0);
        for (Product product : products) {
            tableModel.addRow(new Object[]{product.getName(), product.getPrice(), product.getRating(), product.getPopularity(), product.getDescription()});
        }
    }

    private JPanel createSortPanel() {
        JPanel sortPanel = new JPanel();
        JLabel sortLabel = new JLabel("Sort by:");
        String[] options = {"Price", "Rating", "Popularity"};
        JComboBox<String> sortComboBox = new JComboBox<>(options);

        sortComboBox.addActionListener(e -> {
            String selectedOption = (String) sortComboBox.getSelectedItem();
            if (selectedOption != null) {
                sortProducts(selectedOption);
            }
        });

        sortPanel.add(sortLabel);
        sortPanel.add(sortComboBox);

        return sortPanel;
    }

    private void sortProducts(String criterion) {
        Comparator<Product> comparator;
        switch (criterion) {
            case "Price":
                comparator = Comparator.comparingDouble(Product::getPrice);
                break;
            case "Rating":
                comparator = Comparator.comparingDouble(Product::getRating);
                break;
            case "Popularity":
                comparator = Comparator.comparingInt(Product::getPopularity);
                break;
            default:
                return;
        }

        products = sorting.mergeSort(products, comparator);
        updateTable();
    }

    public void updateProducts(List<Product> filteredProducts) {
        this.products = filteredProducts;
        updateTable();
    }

    public JTable getProductTable() {
        return productTable;
    }
}
