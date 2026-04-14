import java.util.*;

public class CourseRegistration {

    public static void main(String[] args) {

        Map<String, Integer> courses = new HashMap<>();

        courses.put("CS101", 45);
        courses.put("CS102", 52);
        courses.put("CS103", 3);
        courses.put("CS104", 60);
        courses.put("CS105", 2);

        addStudent(courses, "CS101");
        addStudent(courses, "CS103");

        dropStudent(courses, "CS102");
        dropStudent(courses, "CS105");

        System.out.println("Course Registrations:");
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nNear Full Courses (>=50):");
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            if (entry.getValue() >= 50) {
                System.out.println(entry.getKey());
            }
        }

        System.out.println("\nUnder-Subscribed Courses (<5):");
        for (Map.Entry<String, Integer> entry : courses.entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void addStudent(Map<String, Integer> courses, String course) {
        if (courses.containsKey(course)) {
            courses.put(course, courses.get(course) + 1);
            System.out.println("Added student to " + course);
        }
    }

    public static void dropStudent(Map<String, Integer> courses, String course) {
        if (courses.containsKey(course)) {
            int count = courses.get(course);
            if (count > 0) {
                courses.put(course, count - 1);
                System.out.println("Dropped student from " + course);
            }
        }
    }
}