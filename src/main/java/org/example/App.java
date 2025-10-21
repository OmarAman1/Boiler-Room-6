package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckoutService checkoutService = new CheckoutService((from, to) -> {
            if (from.equals("USD") && to.equals("SEK")) return 10; else return 1;
        });

        System.out.println("Vad vill du köpa?");
        System.out.print("Sku: ");
        String sku = scanner.nextLine().trim();
        System.out.print("Antal: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println("Totalt pris: " + checkoutService.calculatePrice(sku, quantity));

    }
}
