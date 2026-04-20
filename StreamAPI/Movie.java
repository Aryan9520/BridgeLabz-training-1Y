import java.util.*;
import java.util.stream.*;

class Movie {
    String name;
    double rating;
    int year;

    Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
            new Movie("Movie1", 8.5, 2024),
            new Movie("Movie2", 9.0, 2025),
            new Movie("Movie3", 7.8, 2023),
            new Movie("Movie4", 8.9, 2025),
            new Movie("Movie5", 8.2, 2024),
            new Movie("Movie6", 9.1, 2026)
        );

        movies.stream()
              .filter(m -> m.rating > 8.0)
              .sorted((a, b) -> Double.compare(b.rating, a.rating))
              .limit(5)
              .forEach(m -> System.out.println(m.name + " " + m.rating + " " + m.year));
    }
}