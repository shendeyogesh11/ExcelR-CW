package store;

public class Item implements Comparable<Item> {
    
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String appliedDiscount = ""; 

    public Item(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    
    public double getTotalPrice() {
        return price * quantity;
    }

    public void applyDiscount(double percentOff) {
    	
        double discountAmount = this.price * (percentOff / 100);
        this.price = this.price - discountAmount;
        this.appliedDiscount =  percentOff + " % off ";
    }

    @Override
    public String toString() {
        return String.format("%s x%d: ₹%.2f%s", name, quantity, getTotalPrice(), appliedDiscount);
    }

    @Override
    public int compareTo(Item o) {
        return Double.compare(this.getTotalPrice(), o.getTotalPrice());
    }
}