import java.util.*;
import java.util.function.Predicate;

public class HospitalAlerts {
    public static void main(String[] args) {

        List<String> alerts = Arrays.asList(
                "Emergency Alert",
                "Medicine Reminder",
                "Appointment Alert",
                "General Update"
        );

        Predicate<String> filter = a -> a.contains("Alert");

        for (String a : alerts) {
            if (filter.test(a)) {
                System.out.println(a);
            }
        }
    }
}