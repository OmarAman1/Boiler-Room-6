package org.example;

public interface ExchangeRateClient {
    double getRate(String from, String to); // "USD", "SEK"
}
