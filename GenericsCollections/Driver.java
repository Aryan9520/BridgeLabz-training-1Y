import java.util.*;

class Driver {
    int id;
    String name;

    Driver(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Driver)) return false;
        Driver d = (Driver) obj;
        return this.id == d.id;
    }

    public String toString() {
        return "Driver " + id + " (" + name + ")";
    }
}

class RideRequest {
    String customer;
    int priority;

    RideRequest(String customer, int priority) {
        this.customer = customer;
        this.priority = priority;
    }

    public String toString() {
        return customer + " (Priority: " + priority + ")";
    }
}

class Ride {
    Driver driver;
    RideRequest request;

    Ride(Driver driver, RideRequest request) {
        this.driver = driver;
        this.request = request;
    }

    public String toString() {
        return request.customer + " served by " + driver.name;
    }
}

public class RideSystem {

    Queue<RideRequest> requestQueue = new LinkedList<>();
    PriorityQueue<RideRequest> priorityQueue =
            new PriorityQueue<>((a, b) -> b.priority - a.priority);

    Set<Driver> availableDrivers = new HashSet<>();
    List<Ride> completedRides = new ArrayList<>();

    public void addRequest(RideRequest r) {
        requestQueue.add(r);
        priorityQueue.add(r);
    }

    public void addDriver(Driver d) {
        availableDrivers.add(d);
    }

    public void assignRides() {
        System.out.println("Assigning Rides:");

        while (!priorityQueue.isEmpty() && !availableDrivers.isEmpty()) {
            RideRequest req = priorityQueue.poll();

            Driver driver = availableDrivers.iterator().next();
            availableDrivers.remove(driver);

            Ride ride = new Ride(driver, req);
            completedRides.add(ride);

            System.out.println("Assigned: " + ride);
        }
    }

    public void showCompletedRides() {
        System.out.println("\nCompleted Rides:");
        for (Ride r : completedRides) {
            System.out.println(r);
        }
    }

    public static void main(String[] args) {

        RideSystem system = new RideSystem();

        system.addDriver(new Driver(1, "Amit"));
        system.addDriver(new Driver(2, "Rahul"));

        system.addRequest(new RideRequest("Aryan", 2));
        system.addRequest(new RideRequest("Sneha", 5));
        system.addRequest(new RideRequest("Riya", 1));

        system.assignRides();
        system.showCompletedRides();
    }
}