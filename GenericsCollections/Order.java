import java.util.*;

class Order {
    int orderId;
    String customerName;

    Order(int orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
    }

    public int hashCode() {
        return Objects.hash(orderId);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Order)) return false;
        Order o = (Order) obj;
        return this.orderId == o.orderId;
    }

    public String toString() {
        return "OrderID: " + orderId + ", Customer: " + customerName;
    }
}

public class OrderProcessingSystem {

    List<Order> allOrders = new ArrayList<>();
    Set<Order> uniqueOrders = new HashSet<>();
    Queue<Order> processingQueue = new LinkedList<>();
    Stack<Order> failedStack = new Stack<>();

    public void addOrder(Order order) {
        allOrders.add(order);
    }

    public void removeDuplicates() {
        uniqueOrders.addAll(allOrders);
    }

    public void prepareQueue() {
        processingQueue.addAll(uniqueOrders);
    }

    public void processOrders() {
        System.out.println("Processing Orders:");

        while (!processingQueue.isEmpty()) {
            Order order = processingQueue.remove();

            if (order.orderId % 2 == 0) {
                System.out.println("Processed: " + order);
            } else {
                System.out.println("Failed: " + order);
                failedStack.push(order);
            }
        }
    }

    public void retryFailedOrders() {
        System.out.println("\nRetrying Failed Orders:");

        while (!failedStack.isEmpty()) {
            Order order = failedStack.pop();
            System.out.println("Reprocessed: " + order);
        }
    }

    public static void main(String[] args) {

        OrderProcessingSystem system = new OrderProcessingSystem();

        system.addOrder(new Order(1, "Aryan"));
        system.addOrder(new Order(2, "Rahul"));
        system.addOrder(new Order(3, "Sneha"));
        system.addOrder(new Order(2, "Rahul"));

        system.removeDuplicates();
        system.prepareQueue();
        system.processOrders();
        system.retryFailedOrders();
    }
}