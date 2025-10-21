package org.example;

import java.util.Map;

public class ProductCatalog {
    Map<String, Product> productCatalog = Map.of(
            "1", new Product("Hammare", 9.99),
            "2", new Product("Slipmaskin", 49.99));

    double priceUsd(String sku) {
        if (productCatalog.containsKey(sku)) {
            return productCatalog.get(sku).price();
        }
        else {
            throw new ProductNotFoundException("Produkten finns inte i databasen");
        }
    }

}
