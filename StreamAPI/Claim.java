import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

class Claim {
    String type;
    double amount;

    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Claim> list = Arrays.asList(
            new Claim("Health", 5000),
            new Claim("Vehicle", 8000),
            new Claim("Health", 7000),
            new Claim("Vehicle", 6000),
            new Claim("Life", 9000)
        );

        Map<String, Double> result = list.stream()
            .collect(groupingBy(c -> c.type, averagingDouble(c -> c.amount)));

        result.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}