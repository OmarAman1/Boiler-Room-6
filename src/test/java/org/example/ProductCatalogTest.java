package org.example;

import org.junit.jupiter.api.Test;

import javax.xml.catalog.Catalog;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductCatalogTest {

    @Test

    void givenHammare_whenPriceUsd_return25 (){

        ProductCatalog productCatalog = new ProductCatalog();

        double usd =  productCatalog.priceUsd("Hammare");

        assertEquals(25.0, usd);

    }

    @Test

    void givenSlipmaskin_whenPriceUsd_return200(){

        ProductCatalog productCatalog = new ProductCatalog();

        double usd =  productCatalog.priceUsd("Slipmaskin");

        assertEquals(200.0, usd);
    }

}
