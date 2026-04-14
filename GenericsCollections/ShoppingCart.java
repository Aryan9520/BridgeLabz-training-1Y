import java.util.*;

public class ShoppingCart {

    public static void main(String[] args) {

        LinkedHashMap<String, Double> cart = new LinkedHashMap<>();

        cart.put("Laptop", 45000.0);
        cart.put("Mouse", 500.0);
        cart.put("Keyboard", 1500.0);
        cart.put("Headphones", 2000.0);

        System.out.println("Cart Items (Insertion Order):");
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " : ₹" + entry.getValue());
        }

        double total = 0;
        for (double price : cart.values()) {
            total += price;
        }

        System.out.println("\nTotal Amount: ₹" + total);

        if (total > 5000) {
            double discount = total * 0.10;
            total -= discount;
            System.out.println("Discount Applied (10%): -₹" + discount);
        }

        System.out.println("Final Amount: ₹" + total);

        cart.remove("Mouse");
        System.out.println("\nRemoved item: Mouse");

        System.out.println("\nUpdated Cart:");
        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " : ₹" + entry.getValue());
        }
    }
}