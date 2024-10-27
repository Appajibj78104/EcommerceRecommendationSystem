package com.example.ecommerce;

public class Product {
    private int id;
    private String name;
    private double price;
    private double rating;
    private int popularity;
    private String description;
    private String category;

    public Product(int id, String name, double price, double rating, int popularity, String description, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.popularity = popularity;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}
