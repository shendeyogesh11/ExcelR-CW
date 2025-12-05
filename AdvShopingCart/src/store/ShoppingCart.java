package store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ShoppingCart {

    TreeMap<Double, String> inventory = new TreeMap<>();
    
    PriorityQueue<DiscountItem> discountQueue = new PriorityQueue<>();
    
    ArrayList<Item> cart = new ArrayList<>();

    public ShoppingCart() {
        initializeStore();
    }

    private void initializeStore() {
       
        inventory.put(1499.0, "P001 OnePlus Buds 1");
        inventory.put(2499.0, "P002 OnePlus Buds 2");
        inventory.put(199.0,  "P003 Keyboard");
        inventory.put(49.99,  "P004 Mouse");
        inventory.put(5499.0, "P005 Monitor");

       
        discountQueue.add(new DiscountItem("Summer Sale", 10.0));
        discountQueue.add(new DiscountItem("Mega Deal", 20.0));
        discountQueue.add(new DiscountItem("Welcome", 5.0));
    }

    public void displayInventory() {
        System.out.println("\n Sorted Inventory (By Price)");
       
        for (Double price : inventory.keySet()) {
            System.out.println( price + " - " + inventory.get(price));
        }
    }

    public void addToCart(Double priceKey, int quantity) throws StockException {
       
        if (quantity <= 0) {
            throw new StockException("Quantity must be positive!");
        }
        if (!inventory.containsKey(priceKey)) {
            throw new StockException("Product with price " + priceKey + " not found!");
        }

        String rawName = inventory.get(priceKey);
  
        String[] parts = rawName.split(" ", 2); 
        String id = parts[0];
        String name = parts[1];

        Item newItem = new Item(id, name, priceKey, quantity);

        
        if (!discountQueue.isEmpty()) {
            DiscountItem discount = discountQueue.poll(); 
            newItem.applyDiscount(discount.getPercentage());
            System.out.println("Applied " + discount + " to " + name);
        }

        cart.add(newItem);
        System.out.println("Added to cart.");
    }

    public void viewCartAndCheckout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        Collections.sort(cart);

        System.out.println("\n Cart (Sorted by Total Price) ");
        double finalTotal = 0;
        
        for (Item item : cart) {
            System.out.println(item);
            finalTotal += item.getTotalPrice();
        }
        
        System.out.println("Total: " + String.format("%.2f", finalTotal));
        
        PaymentProcessor.processPayment(finalTotal);
        cart.clear(); 
    }
}