package org.example;

public class CheckoutService{
    private ProductCatalog productCatalog = new ProductCatalog();
    private ExchangeRateClient exchangeRateClient;



  public CheckoutService(ExchangeRateClient e){
      this.exchangeRateClient = e;
  }


    double calculatePrice (String sku, int quantity) {
        return productCatalog.priceUsd(sku) * quantity * exchangeRateClient.getRate("USD", "SEK");
    }

}
