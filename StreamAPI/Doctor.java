import java.util.*;

class Doctor {
    String name, specialty;
    boolean weekend;

    Doctor(String name, String specialty, boolean weekend) {
        this.name = name;
        this.specialty = specialty;
        this.weekend = weekend;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Doctor> list = Arrays.asList(
            new Doctor("Rahul", "Cardiology", true),
            new Doctor("Amit", "Neurology", false),
            new Doctor("Neha", "Dermatology", true),
            new Doctor("Priya", "Orthopedic", true)
        );

        list.stream()
            .filter(d -> d.weekend)
            .sorted((a, b) -> a.specialty.compareTo(b.specialty))
            .forEach(d -> System.out.println(d.name + " " + d.specialty));
    }
}