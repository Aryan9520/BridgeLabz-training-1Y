import java.util.*;

public class Main1 {
    public static void main(String[] args) {

        List<Double> prices = Arrays.asList(
            120.50, 121.75, 119.80, 122.40, 123.10
        );

        prices.forEach(price -> System.out.println("Stock Price: " + price));
    }
}