import java.util.*;

public class Main4 {
    public static void main(String[] args) {

        List<Integer> readings = Arrays.asList(
            45, 72, 30, 90, 65, 20
        );

        readings.stream()
            .filter(r -> r > 50)
            .forEach(r -> System.out.println("Reading: " + r));
    }
}