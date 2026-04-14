import java.util.*;

class PackageItem {
    String id;
    String address;

    PackageItem(String id, String address) {
        this.id = id;
        this.address = address;
    }

    public String toString() {
        return "PackageID: " + id + " → " + address;
    }
}

public class DeliverySystem {

    Queue<PackageItem> deliveryQueue = new LinkedList<>();
    Set<String> packageIds = new HashSet<>();
    List<PackageItem> delivered = new ArrayList<>();
    Stack<PackageItem> returned = new Stack<>();

    public void addPackage(PackageItem p) {
        if (packageIds.add(p.id)) {
            deliveryQueue.add(p);
            System.out.println("Added: " + p);
        } else {
            System.out.println("Duplicate Package ID: " + p.id);
        }
    }

    public void processDeliveries() {
        System.out.println("\nProcessing Deliveries:");

        while (!deliveryQueue.isEmpty()) {
            PackageItem p = deliveryQueue.remove();

            if (p.id.hashCode() % 2 == 0) {
                delivered.add(p);
                System.out.println("Delivered: " + p);
            } else {
                returned.push(p);
                System.out.println("Returned: " + p);
            }
        }
    }

    public void showSummary() {
        System.out.println("\nDelivered Packages:");
        for (PackageItem p : delivered) {
            System.out.println(p);
        }

        System.out.println("\nReturned Packages:");
        for (PackageItem p : returned) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        DeliverySystem system = new DeliverySystem();

        system.addPackage(new PackageItem("P101", "Delhi"));
        system.addPackage(new PackageItem("P102", "Mumbai"));
        system.addPackage(new PackageItem("P103", "Agra"));
        system.addPackage(new PackageItem("P101", "Duplicate"));

        system.processDeliveries();
        system.showSummary();
    }
}