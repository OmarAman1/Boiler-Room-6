package org.example;

import java.util.List;

public class ProductCatalog {
    List<Product> productCatalog = List.of(new Product("Hammare", 25), new Product("Slipmaskin", 200));

    double priceUsd(String sku) {
        return productCatalog.stream()
                .filter(p -> sku.equals(p.getName()))
                .findFirst()
                .get()
                .getPrice();
    }

}
