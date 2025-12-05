package store;

public class DiscountItem implements Comparable<DiscountItem> {
    
    private String discountName;
    private double percentage;

    public DiscountItem(String discountName, double percentage) {
        this.discountName = discountName;
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return discountName + " (" + percentage + "% OFF)";
    }

    @Override
    public int compareTo(DiscountItem o) {
        // highest % first 
        return Double.compare(o.percentage, this.percentage);
    }
}