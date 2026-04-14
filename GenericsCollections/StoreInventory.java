import java.util.*;

public class StoreInventory {

    public static void main(String[] args) {

        Map<String, Integer> inventory = new HashMap<>();

        inventory.put("Milk", 10);
        inventory.put("Bread", 5);
        inventory.put("Eggs", 20);

        buyProduct(inventory, "Milk", 5);
        buyProduct(inventory, "Bread", 5);

        restockProduct(inventory, "Bread", 10);

        checkStock(inventory, "Milk");
        checkStock(inventory, "Butter");

        showOutOfStock(inventory);
    }

    public static void buyProduct(Map<String, Integer> inventory, String product, int qty) {
        if (inventory.containsKey(product)) {
            int newQty = inventory.get(product) - qty;
            if (newQty <= 0) {
                inventory.put(product, 0);
                System.out.println(product + " is now OUT OF STOCK");
            } else {
                inventory.put(product, newQty);
                System.out.println("Bought " + qty + " " + product);
            }
        } else {
            System.out.println(product + " not found");
        }
    }

    public static void restockProduct(Map<String, Integer> inventory, String product, int qty) {
        inventory.put(product, inventory.getOrDefault(product, 0) + qty);
        System.out.println("Restocked " + qty + " " + product);
    }

    public static void checkStock(Map<String, Integer> inventory, String product) {
        if (inventory.containsKey(product)) {
            System.out.println(product + " stock: " + inventory.get(product));
        } else {
            System.out.println(product + " is not stocked");
        }
    }

    public static void showOutOfStock(Map<String, Integer> inventory) {
        System.out.println("\nOut of Stock Products:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println(entry.getKey());
            }
        }
    }
}