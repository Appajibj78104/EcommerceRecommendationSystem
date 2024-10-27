package com.example.ecommerce;

import java.util.List;

public class User {
    private int id;
    private String name;
    private List<Product> purchasedProducts;

    public User(int id, String name, List<Product> purchasedProducts) {
        this.id = id;
        this.name = name;
        this.purchasedProducts = purchasedProducts;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<Product> getPurchasedProducts() { return purchasedProducts; }

    public void setPurchasedProducts(List<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }
}
