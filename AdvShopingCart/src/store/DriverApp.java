package store;

import java.util.Scanner;

public class DriverApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart shop = new ShoppingCart();
        
        while (true) {
            System.out.println("\n1. View Store");
            System.out.println("2. Add to Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            
            int choice = sc.nextInt();
            
            try {
                switch (choice) {
                    case 1:
                        shop.displayInventory();
                        break;
                    case 2:
                        shop.displayInventory();
                        System.out.print("Enter Price of item to buy (e.g. 1499.0): ");
                        double price = sc.nextDouble();
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();
                        shop.addToCart(price, qty);
                        break;
                    case 3:
                        shop.viewCartAndCheckout();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (StockException e) {
                // Handling the custom exception 
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid Input.");
                sc.nextLine(); // clear buffer
            }
        }
    }
}