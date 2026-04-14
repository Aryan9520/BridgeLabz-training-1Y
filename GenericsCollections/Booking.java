import java.util.*;

class Booking {
    String userId;
    String name;
    boolean isVIP;

    Booking(String userId, String name, boolean isVIP) {
        this.userId = userId;
        this.name = name;
        this.isVIP = isVIP;
    }

    public String toString() {
        return name + " (" + userId + ") " + (isVIP ? "[VIP]" : "[Normal]");
    }
}

public class EventSystem {

    Set<String> users = new HashSet<>();
    List<Booking> confirmedBookings = new ArrayList<>();
    Queue<Booking> bookingQueue = new LinkedList<>();
    PriorityQueue<Booking> vipQueue = new PriorityQueue<>(
            (a, b) -> Boolean.compare(b.isVIP, a.isVIP)
    );

    public void registerUser(String userId) {
        if (users.add(userId)) {
            System.out.println("Registered User: " + userId);
        } else {
            System.out.println("Duplicate User: " + userId);
        }
    }

    public void bookTicket(Booking b) {
        bookingQueue.add(b);
        vipQueue.add(b);
    }

    public void processBookings() {
        System.out.println("\nProcessing Bookings:");

        while (!vipQueue.isEmpty()) {
            Booking b = vipQueue.poll();
            confirmedBookings.add(b);
            System.out.println("Confirmed: " + b);
        }
    }

    public void showBookings() {
        System.out.println("\nAll Confirmed Bookings:");
        for (Booking b : confirmedBookings) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {

        EventSystem system = new EventSystem();

        system.registerUser("U1");
        system.registerUser("U2");
        system.registerUser("U1");

        system.bookTicket(new Booking("U1", "Aryan", false));
        system.bookTicket(new Booking("U2", "Rahul", true));
        system.bookTicket(new Booking("U3", "Sneha", false));

        system.processBookings();
        system.showBookings();
    }
}