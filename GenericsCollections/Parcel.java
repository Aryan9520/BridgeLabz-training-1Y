import java.util.*;

class Parcel {
    String id;
    String address;
    int priority;

    Parcel(String id, String address, int priority) {
        this.id = id;
        this.address = address;
        this.priority = priority;
    }

    public String toString() {
        return id + " → " + address + " (Priority: " + priority + ")";
    }
}

public class CourierSystem {

    PriorityQueue<Parcel> priorityQueue =
            new PriorityQueue<>((a, b) -> b.priority - a.priority);

    Queue<Parcel> normalQueue = new LinkedList<>();
    Set<String> parcelIds = new HashSet<>();
    List<Parcel> completed = new ArrayList<>();

    public void addParcel(Parcel p) {
        if (parcelIds.add(p.id)) {
            if (p.priority > 3) {
                priorityQueue.add(p);
            } else {
                normalQueue.add(p);
            }
            System.out.println("Added: " + p);
        } else {
            System.out.println("Duplicate Parcel ID: " + p.id);
        }
    }

    public void assignDeliveries() {
        System.out.println("\nAssigning Deliveries:");

        while (!priorityQueue.isEmpty()) {
            Parcel p = priorityQueue.poll();
            completed.add(p);
            System.out.println("Delivered (Priority): " + p);
        }

        while (!normalQueue.isEmpty()) {
            Parcel p = normalQueue.remove();
            completed.add(p);
            System.out.println("Delivered (Normal): " + p);
        }
    }

    public void showCompleted() {
        System.out.println("\nCompleted Deliveries:");
        for (Parcel p : completed) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        CourierSystem system = new CourierSystem();

        system.addParcel(new Parcel("P1", "Delhi", 5));
        system.addParcel(new Parcel("P2", "Mumbai", 2));
        system.addParcel(new Parcel("P3", "Agra", 4));
        system.addParcel(new Parcel("P1", "Duplicate", 5));

        system.assignDeliveries();
        system.showCompleted();
    }
}