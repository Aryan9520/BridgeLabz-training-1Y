import java.util.*;

public class EmployeeDepartment {

    public static void main(String[] args) {

        Map<Integer, String> empDept = new HashMap<>();

        empDept.put(101, "IT");
        empDept.put(102, "HR");
        empDept.put(103, "Finance");
        empDept.put(104, "IT");
        empDept.put(105, "HR");
        empDept.put(106, "IT");

        empDept.put(103, "IT");
        System.out.println("Updated Department for 103");

        String targetDept = "IT";
        System.out.println("\nEmployees in " + targetDept + ":");
        for (Map.Entry<Integer, String> entry : empDept.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(targetDept)) {
                System.out.println("EmpID: " + entry.getKey());
            }
        }

        Map<String, Integer> deptCount = new HashMap<>();

        for (String dept : empDept.values()) {
            deptCount.put(dept, deptCount.getOrDefault(dept, 0) + 1);
        }

        System.out.println("\nEmployees per Department:");
        for (Map.Entry<String, Integer> entry : deptCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}