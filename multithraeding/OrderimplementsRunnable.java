class OrderimplementsRunnable {

    private int orderId;
    private String restaurant;
    private int deliveryTime; // in seconds

    public Order(int orderId, String restaurant, int deliveryTime) {
        this.orderId = orderId;
        this.restaurant = restaurant;
        this.deliveryTime = deliveryTime;
    }

    @Override
    public void run() {
        String agent = Thread.currentThread().getName();
        long startTime = System.currentTimeMillis();

        try {
            System.out.println("Order " + orderId + " from " + restaurant +
                    " | Agent: " + agent + " → Picked up");

            Thread.sleep(deliveryTime * 500); // simulate pickup delay

            System.out.println("Order " + orderId +
                    " | Agent: " + agent + " → In Transit");

            Thread.sleep(deliveryTime * 500); // simulate travel

            System.out.println("Order " + orderId +
                    " | Agent: " + agent + " → Delivered ✅");

        } catch (InterruptedException e) {
            System.out.println(e);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Order " + orderId +
                " Total Delivery Time: " + (endTime - startTime) / 1000.0 + " sec\n");
    }
}

public class FoodDeliverySystem {
    public static void main(String[] args) {

        // Create Orders
        Thread o1 = new Thread(new Order(101, "Dominos", 4), "Agent-A");
        Thread o2 = new Thread(new Order(102, "KFC", 3), "Agent-B");
        Thread o3 = new Thread(new Order(103, "Burger King", 5), "Agent-C");
        Thread o4 = new Thread(new Order(104, "Pizza Hut", 2), "Agent-D");
        Thread o5 = new Thread(new Order(105, "Subway", 6), "Agent-E");

        // Set Priorities
        o1.setPriority(10); // Express
        o2.setPriority(5);  // Standard
        o3.setPriority(3);  // Economy
        o4.setPriority(10); // Express
        o5.setPriority(5);  // Standard

        // Start all orders
        o1.start();
        o2.start();
        o3.start();
        o4.start();
        o5.start();

        // Wait for all to complete
        try {
            o1.join();
            o2.join();
            o3.join();
            o4.join();
            o5.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("🍕 All Orders Delivered Successfully!");
    }
}