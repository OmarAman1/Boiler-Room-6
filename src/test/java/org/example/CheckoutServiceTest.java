package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CheckoutServiceTest {

    @Test
    void givenHammareAndFive_whenCalculatePrice_return125() {
        ExchangeRateClient mockedExchangeRateClient = mock(ExchangeRateClient.class);
        when(mockedExchangeRateClient.getRate("USD", "SEK")).thenReturn(10.0);
        CheckoutService checkoutService = new CheckoutService(mockedExchangeRateClient);

        double result = checkoutService.calculatePrice("Hammare", 5);

        assertEquals(1250.0, result);
    }

    @Test
    void givenSlipmaskinAndFive_whenCalculatePrice_return1000() {
        ExchangeRateClient mockedExchangeRateClient = mock(ExchangeRateClient.class);
        when(mockedExchangeRateClient.getRate("USD", "SEK")).thenReturn(10.0);
        CheckoutService checkoutService = new CheckoutService(mockedExchangeRateClient);

        double result = checkoutService.calculatePrice("Slipmaskin", 5);

        assertEquals(10000.0, result);
    }
}