package com.example.ecommerce;

import java.util.*;

public class Dijkstra {

    public static Map<Product, Double> shortestPath(Graph graph, Product start) {
        Map<Product, Double> distances = new HashMap<>(); // Stores the shortest distance to each product
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(Node::getDistance)); // Min-heap priority queue to select the node with the smallest distance
        Set<Product> visited = new HashSet<>(); // Set to track visited products

        for (Product product : graph.getNodes()) {
            distances.put(product, Double.MAX_VALUE); // Initialize distances to infinity
        }
        distances.put(start, 0.0); // Distance to the start product is 0
        pq.add(new Node(start, 0.0)); // Add the start node to the priority queue

        while (!pq.isEmpty()) {
            Node current = pq.poll(); // Get the node with the smallest distance
            if (visited.contains(current.getProduct())) {
                continue; // Skip if already visited
            }
            visited.add(current.getProduct()); // Mark the current product as visited

            for (Graph.Edge edge : graph.getEdges(current.getProduct())) { // Iterate through all edges of the current product
                Product neighbor = edge.getTo(); // Get the neighboring product
                double newDist = distances.get(current.getProduct()) + edge.getWeight(); // Calculate the new distance
                if (newDist < distances.get(neighbor)) { // If new distance is shorter, update it
                    distances.put(neighbor, newDist);
                    pq.add(new Node(neighbor, newDist)); // Add the neighbor to the priority queue
                }
            }
        }

        return distances; // Return the map of shortest distances
    }

    private static class Node {
        private Product product;
        private double distance;

        public Node(Product product, double distance) {
            this.product = product;
            this.distance = distance;
        }

        public Product getProduct() {
            return product;
        }

        public double getDistance() {
            return distance;
        }
    }
}
