import java.util.*;

public class Main3 {
    public static void main(String[] args) {

        List<String> attendees = Arrays.asList(
            "Rahul", "Amit", "Neha", "Priya"
        );

        attendees.forEach(name ->
            System.out.println("Welcome " + name)
        );
    }
}