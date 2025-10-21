package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductCatalog productCatalog = new ProductCatalog();
        CheckoutService checkoutService = new CheckoutService(
                productCatalog,
                (from, to) -> {
                    if (from.equals("USD") && to.equals("SEK")) return 10.21; else return 1;
                });

        while (true) {
            System.out.println("Vad vill du köpa? Ange -1 som SKU för att avsluta");
            System.out.print("SKU: ");
            String sku = scanner.nextLine().trim();
            if (sku.equals("-1")) break;
            System.out.print("Antal: ");
            int quantity;

            try {
                quantity = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Felaktig inmatning, skriv siffran för antalet du vill köpa");
                continue;
            }

            try {
                System.out.println("Totalt pris: " + checkoutService.calculatePrice(sku, quantity));
            } catch (ProductNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
