package com.example.ecommerce;

import java.util.List;
import java.util.stream.Collectors;

public class Searching {

    public List<Product> searchProductsByName(List<Product> products, String keyword) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
