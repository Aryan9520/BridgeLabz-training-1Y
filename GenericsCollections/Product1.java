import java.util.*;

class Product1 {
    String name;
    double price;
    int stock;

    Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String toString() {
        return name + " | ₹" + price + " | Stock: " + stock;
    }
}

public class InventorySystem {

    Set<String> productNames = new HashSet<>();
    List<Product> products = new ArrayList<>();
    Queue<Product> restockQueue = new LinkedList<>();
    Stack<Product> restockHistory = new Stack<>();

    public void addProduct(Product p) {
        if (productNames.add(p.name)) {
            products.add(p);
            System.out.println("Added: " + p);
        } else {
            System.out.println("Duplicate Product: " + p.name);
        }
    }

    public void checkLowStock(int threshold) {
        System.out.println("\nLow Stock Items:");
        for (Product p : products) {
            if (p.stock < threshold) {
                restockQueue.add(p);
                System.out.println(p);
            }
        }
    }

    public void processRestock(int quantity) {
        System.out.println("\nRestocking:");

        while (!restockQueue.isEmpty()) {
            Product p = restockQueue.remove();
            p.stock += quantity;
            restockHistory.push(p);

            System.out.println("Restocked: " + p);
        }
    }

    public void undoRestock(int quantity) {
        if (!restockHistory.isEmpty()) {
            Product p = restockHistory.pop();
            p.stock -= quantity;

            System.out.println("\nUndo Restock: " + p);
        }
    }

    public static void main(String[] args) {

        InventorySystem system = new InventorySystem();

        system.addProduct(new Product("Milk", 50, 5));
        system.addProduct(new Product("Bread", 30, 2));
        system.addProduct(new Product("Eggs", 10, 20));
        system.addProduct(new Product("Milk", 50, 5));

        system.checkLowStock(10);

        system.processRestock(20);

        system.undoRestock(20);
    }
}