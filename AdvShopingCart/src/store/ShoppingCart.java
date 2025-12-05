package store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ShoppingCart {

    // 1. Inventory sorted by Price automatically
    TreeMap<Double, String> inventory = new TreeMap<>();
    
    // 2. Discounts sorted by Highest % automatically
    PriorityQueue<DiscountItem> discountQueue = new PriorityQueue<>();
    
    // 3. User Cart
    ArrayList<Item> cart = new ArrayList<>();

    public ShoppingCart() {
        initializeStore();
    }

    private void initializeStore() {
        // Adding 5 products to TreeMap [cite: 12]
        inventory.put(1499.0, "P001 OnePlus Buds 1");
        inventory.put(2499.0, "P002 OnePlus Buds 2");
        inventory.put(199.0,  "P003 Keyboard");
        inventory.put(49.99,  "P004 Mouse");
        inventory.put(5499.0, "P005 Monitor");

        // Adding Discounts to PriorityQueue
        discountQueue.add(new DiscountItem("Summer Sale", 10.0));
        discountQueue.add(new DiscountItem("Mega Deal", 20.0)); // Highest, will be used first
        discountQueue.add(new DiscountItem("Welcome", 5.0));
    }

    public void displayInventory() {
        System.out.println("\n--- Sorted Inventory (By Price) ---");
        // Iterating TreeMap
        for (Double price : inventory.keySet()) {
            System.out.println("₹" + price + " - " + inventory.get(price));
        }
    }

    public void addToCart(Double priceKey, int quantity) throws StockException {
        // Validation [cite: 20]
        if (quantity <= 0) {
            throw new StockException("Quantity must be positive!");
        }
        if (!inventory.containsKey(priceKey)) {
            throw new StockException("Product with price " + priceKey + " not found!");
        }

        String rawName = inventory.get(priceKey);
        // Splitting "P001 OnePlus" into ID and Name for cleaner objects
        String[] parts = rawName.split(" ", 2); 
        String id = parts[0];
        String name = parts[1];

        // Create the Item
        Item newItem = new Item(id, name, priceKey, quantity);

        // Apply Discount Logic: Poll from Queue (Use once) 
        if (!discountQueue.isEmpty()) {
            DiscountItem discount = discountQueue.poll(); // Removes the best discount
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

        // Sort Cart by Total Price [cite: 14]
        Collections.sort(cart);

        System.out.println("\n--- Cart (Sorted by Total Price) ---");
        double finalTotal = 0;
        
        for (Item item : cart) {
            System.out.println(item);
            finalTotal += item.getTotalPrice();
        }
        
        System.out.println("Total: ₹" + String.format("%.2f", finalTotal));
        
        // Process Payment 
        PaymentProcessor.processPayment(finalTotal);
        cart.clear(); // Empty cart after paying
    }
}