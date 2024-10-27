package com.example.ecommerce;

import java.util.*;

public class RecommendationEngine {
    private List<Product> products; // List of all products
    private Graph graph; // Graph representing product relationships

    public RecommendationEngine(List<Product> products) {
        this.products = products;
        this.graph = new Graph();
        initializeGraph(); // Initialize the graph with products and their relationships
    }

    private void initializeGraph() {
        for (Product product : products) {
            graph.addNode(product); // Add each product as a node in the graph
        }

        for (Product from : products) {
            for (Product to : products) {
                if (!from.equals(to)) {
                    double weight = calculateWeight(from, to); // Calculate the weight between two products
                    graph.addEdge(from, to, weight); // Add an edge between the products with the calculated weight
                }
            }
        }
    }

    private double calculateWeight(Product from, Product to) {
        double priceDiff = Math.abs(from.getPrice() - to.getPrice()); // Calculate price difference
        double ratingDiff = Math.abs(from.getRating() - to.getRating()); // Calculate rating difference
        double categoryDiff = from.getCategory().equals(to.getCategory()) ? 0 : 1; // Check if products belong to the same category
        return priceDiff + ratingDiff + categoryDiff; // Total weight is the sum of differences
    }

    public List<Product> getRecommendations(Product product, String criterion) {
        Map<Product, Double> shortestPaths = Dijkstra.shortestPath(graph, product); // Get the shortest paths from the product
        List<Map.Entry<Product, Double>> sortedEntries = new ArrayList<>(shortestPaths.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue()); // Sort products by shortest distance

        List<Product> recommendations = new ArrayList<>();
        for (Map.Entry<Product, Double> entry : sortedEntries) {
            if (!entry.getKey().equals(product)) {
                recommendations.add(entry.getKey()); // Add products to recommendations excluding the current product
            }
        }

        return filterByCriterion(recommendations, criterion); // Filter recommendations based on the selected criterion
    }

    private List<Product> filterByCriterion(List<Product> recommendations, String criterion) {
        switch (criterion) {
            case "Best Sellers":
                return filterByDescription(recommendations, "Best Sellers"); // Filter by description keyword "Best Sellers"
            case "Personalized Recommendations":
                return filterByCategory(recommendations, recommendations.get(0).getCategory()); // Filter by same category
            case "Related Products":
                return filterByDescription(recommendations, recommendations.get(0).getDescription().split(" ")[0]); // Filter by first word in description
            case "New Arrivals":
                return filterByDescription(recommendations, "New Arrivals"); // Filter by description keyword "New Arrivals"
            case "Seasonal or Trending Products":
                return filterByDescription(recommendations, "Trending Products"); // Filter by description keyword "Trending Products"
            case "Cross-Selling":
                return filterByDescription(recommendations, "Cross-Selling"); // Filter by description keyword "Cross-Selling"
            case "Upselling":
                return filterByDescription(recommendations, "Upselling"); // Filter by description keyword "Upselling"
            case "Customer Reviews and Ratings":
                return filterByTopRatings(recommendations); // Filter by top ratings
            case "Discounts and Special Offers":
                return filterByDescription(recommendations, "Discount"); // Filter by description keyword "Discount"
            default:
                return recommendations; // Return recommendations without filtering if criterion is unknown
        }
    }

    private List<Product> filterByDescription(List<Product> products, String keyword) {
        List<Product> filtered = new ArrayList<>();
        for (Product product : products) {
            if (product.getDescription().contains(keyword)) {
                filtered.add(product); // Add product to filtered list if description contains keyword
            }
        }
        return filtered; // Return filtered list
    }

    private List<Product> filterByCategory(List<Product> products, String category) {
        List<Product> filtered = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                filtered.add(product); // Add product to filtered list if category matches
            }
        }
        return filtered; // Return filtered list
    }

    private List<Product> filterByTopRatings(List<Product> products) {
        List<Product> filtered = new ArrayList<>(products);
        filtered.sort(Comparator.comparingDouble(Product::getRating).reversed()); // Sort products by rating in descending order
        return filtered; // Return sorted list
    }
}
