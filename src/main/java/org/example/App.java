package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Read sku and quantity -> total price
        Scanner scanner = new Scanner(System.in);
        ExchangeRateClient exchangeRateClient = new ExchangeRateClient() {
            @Override
            public double getRate(String from, String to) {
                if (from.equals("USD") && to.equals("SEK")) {
                    return 10;
                }
                else {
                    return -1;
                }
            }
        };
        CheckoutService checkoutService = new CheckoutService(exchangeRateClient);

        System.out.println("What do you want to purchase?");
        System.out.print("Sku: ");
        String sku = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        checkoutService.calculatePrice(sku, quantity);

    }
}
