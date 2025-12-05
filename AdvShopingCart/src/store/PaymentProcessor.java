package store;

public class PaymentProcessor {
    public static boolean processPayment(double amount) {
        
        System.out.println("\nProcessing Payment of ₹" + String.format("%.2f", amount));
        System.out.println("UPI Payment Successful! TXN: UPI" + System.currentTimeMillis());
        return true;
    }
}