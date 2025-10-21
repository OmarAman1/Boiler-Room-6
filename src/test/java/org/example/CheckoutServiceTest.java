package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CheckoutServiceTest {

    @Test
    void givenHammareAndFive_whenCalculatePrice_return125() {
        ExchangeRateClient mockedExchangeRateClient = mock(ExchangeRateClient.class);
        when(mockedExchangeRateClient.getRate("USD", "SEK")).thenReturn(10.21);
        CheckoutService checkoutService = new CheckoutService(new ProductCatalog(), mockedExchangeRateClient);

        double result = checkoutService.calculatePrice("Hammare", 7);

        assertEquals(713.99, result, 0.01);
    }

    @Test
    void givenSlipmaskinAndFive_whenCalculatePrice_return1000() {
        ExchangeRateClient mockedExchangeRateClient = mock(ExchangeRateClient.class);
        when(mockedExchangeRateClient.getRate("USD", "SEK")).thenReturn(10.21);
        CheckoutService checkoutService = new CheckoutService(new ProductCatalog(), mockedExchangeRateClient);

        double result = checkoutService.calculatePrice("Slipmaskin", 5);

        assertEquals(2551.99, result, 0.01);
    }
}