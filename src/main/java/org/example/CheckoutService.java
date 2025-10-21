package org.example;

public class CheckoutService {
    private final ProductCatalog productCatalog;
    private final ExchangeRateClient exchangeRateClient;



    public CheckoutService(ProductCatalog productCatalog, ExchangeRateClient exchangeRateClient){
        this.productCatalog = productCatalog;
        this.exchangeRateClient = exchangeRateClient;
    }


    double calculatePrice (String sku, int quantity) {
        return Math.floor(productCatalog.priceUsd(sku) * quantity * exchangeRateClient.getRate("USD", "SEK") * 100) / 100;
    }

}
