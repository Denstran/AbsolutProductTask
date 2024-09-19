package org.example;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Product {
    private final String name;
    private final Set<Product> productIngredients;

    public Product(String name) {
        this.name = name;
        productIngredients = new HashSet<>();
    }

    public boolean addProduct(Product p) {
        if (p == null || this.equals(p) || p.containsProduct(this))
            return false;

        return productIngredients.add(p);
    }

    private boolean containsProduct(Product product) {
        if (this.productIngredients.contains(product)) return true;

        return this.productIngredients.contains(product) ||
                this.productIngredients.stream()
                .anyMatch(p -> p.containsProduct(product));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
