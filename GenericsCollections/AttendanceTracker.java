import java.util.*;

public class AttendanceTracker {

    public static void main(String[] args) {

        Map<String, Integer> attendance = new HashMap<>();

        String[] students = {"Aryan", "Rahul", "Sneha", "Riya", "Aman"};

        for (String s : students) {
            attendance.put(s, 0);
        }

        List<List<String>> monthAttendance = Arrays.asList(
                Arrays.asList("Aryan", "Rahul", "Sneha"),
                Arrays.asList("Aryan", "Riya", "Aman"),
                Arrays.asList("Rahul", "Sneha"),
                Arrays.asList("Aryan", "Rahul", "Aman"),
                Arrays.asList("Sneha", "Riya"),
                Arrays.asList("Aryan", "Rahul"),
                Arrays.asList("Aman", "Riya"),
                Arrays.asList("Aryan", "Sneha"),
                Arrays.asList("Rahul", "Aman"),
                Arrays.asList("Aryan", "Riya"),
                Arrays.asList("Sneha", "Rahul"),
                Arrays.asList("Aryan", "Aman"),
                Arrays.asList("Riya", "Sneha"),
                Arrays.asList("Aryan", "Rahul"),
                Arrays.asList("Aman", "Sneha")
        );

        for (List<String> day : monthAttendance) {
            for (String student : day) {
                attendance.put(student, attendance.get(student) + 1);
            }
        }

        System.out.println("Attendance Count:");
        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        int threshold = 10;
        System.out.println("\nStudents with attendance < " + threshold + ":");

        for (Map.Entry<String, Integer> entry : attendance.entrySet()) {
            if (entry.getValue() < threshold) {
                System.out.println(entry.getKey());
            }
        }
    }
}