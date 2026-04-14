import java.util.*;

class Vehicle {
    String name;

    Vehicle(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Truck extends Vehicle {
    Truck(String name) {
        super(name);
    }

    public String toString() {
        return "Truck: " + name;
    }
}

class Bike extends Vehicle {
    Bike(String name) {
        super(name);
    }

    public String toString() {
        return "Bike: " + name;
    }
}

class FleetManager<T extends Vehicle> {
    private List<T> fleet = new ArrayList<>();

    public void addVehicle(T vehicle) {
        fleet.add(vehicle);
    }

    public void showFleet() {
        for (T vehicle : fleet) {
            System.out.println(vehicle);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        FleetManager<Truck> truckFleet = new FleetManager<>();
        truckFleet.addVehicle(new Truck("Tata Truck"));
        truckFleet.addVehicle(new Truck("Ashok Leyland"));

        FleetManager<Bike> bikeFleet = new FleetManager<>();
        bikeFleet.addVehicle(new Bike("Royal Enfield"));
        bikeFleet.addVehicle(new Bike("Yamaha R15"));

        truckFleet.showFleet();
        bikeFleet.showFleet();
    }
}