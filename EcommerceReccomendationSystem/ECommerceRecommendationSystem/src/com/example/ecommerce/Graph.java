package com.example.ecommerce;

import java.util.*;

public class Graph {
    private Map<Product, List<Edge>> adjList; // Adjacency list to store the graph

    public Graph() {
        this.adjList = new HashMap<>(); // Initialize the adjacency list
    }

    public void addNode(Product product) {
        adjList.putIfAbsent(product, new ArrayList<>()); // Add a new node if it doesn't already exist
    }

    public void addEdge(Product from, Product to, double weight) {
        adjList.get(from).add(new Edge(to, weight)); // Add a directed edge from 'from' product to 'to' product with a given weight
    }

    public List<Edge> getEdges(Product product) {
        return adjList.get(product); // Get the edges of a specific product
    }

    public Set<Product> getNodes() {
        return adjList.keySet(); // Get all the nodes in the graph
    }

    public static class Edge {
        private Product to;
        private double weight;

        public Edge(Product to, double weight) {
            this.to = to;
            this.weight = weight;
        }

        public Product getTo() {
            return to; // Get the destination product of the edge
        }

        public double getWeight() {
            return weight; // Get the weight of the edge
        }
    }
}
