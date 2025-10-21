package org.example;

public class CheckoutService{
    private ProductCatalog productCatalog = new ProductCatalog();
    private ExchangeRateClient exchangeRateClient;



    public CheckoutService(ExchangeRateClient exchangeRateClient){
        this.exchangeRateClient = exchangeRateClient;
    }


    double calculatePrice (String sku, int quantity) {
        return productCatalog.priceUsd(sku) * quantity * exchangeRateClient.getRate("USD", "SEK");
    }

}
