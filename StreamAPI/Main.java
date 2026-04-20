import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList(
            "rahul", "amit", "neha", "priya"
        );

        names.stream()
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
    }
}