import java.util.*;

public class EmployeeSalary {

    public static void main(String[] args) {

        Map<String, Double> salaries = new HashMap<>();

        salaries.put("Aryan", 50000.0);
        salaries.put("Rahul", 60000.0);
        salaries.put("Sneha", 75000.0);
        salaries.put("Riya", 75000.0);
        salaries.put("Aman", 55000.0);
        salaries.put("Neha", 65000.0);

        giveRaise(salaries, "Aryan", 10);
        giveRaise(salaries, "Rahul", 5);
        giveRaise(salaries, "Unknown", 10);

        double total = 0;
        for (double sal : salaries.values()) {
            total += sal;
        }
        double avg = total / salaries.size();

        System.out.println("\nAverage Salary: " + avg);

        double max = Collections.max(salaries.values());

        System.out.println("\nHighest Paid Employee(s):");
        for (Map.Entry<String, Double> entry : salaries.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    public static void giveRaise(Map<String, Double> salaries, String name, double percent) {
        if (salaries.containsKey(name)) {
            double current = salaries.get(name);
            double updated = current + (current * percent / 100);
            salaries.put(name, updated);
            System.out.println("Updated Salary of " + name + ": " + updated);
        } else {
            System.out.println("Employee not found: " + name);
        }
    }
}