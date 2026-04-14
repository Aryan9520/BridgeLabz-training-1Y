import java.util.*;

class Movie {
    String title;
    String genre;

    Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String toString() {
        return title + " (" + genre + ")";
    }
}

public class StreamingSystem {

    Stack<Movie> watchHistory = new Stack<>();
    List<Movie> allMovies = new ArrayList<>();
    Set<String> genresWatched = new HashSet<>();
    Queue<Movie> upNext = new LinkedList<>();

    public void addMovie(Movie m) {
        allMovies.add(m);
    }

    public void addToUpNext(Movie m) {
        upNext.add(m);
        System.out.println("Added to Up Next: " + m);
    }

    public void watchMovie() {
        if (!upNext.isEmpty()) {
            Movie m = upNext.remove();
            watchHistory.push(m);
            genresWatched.add(m.genre);
            System.out.println("Watched: " + m);
        }
    }

    public void showRecommendations() {
        System.out.println("\nRecommended Movies:");
        for (Movie m : allMovies) {
            if (genresWatched.contains(m.genre)) {
                System.out.println(m);
            }
        }
    }

    public void showHistory() {
        System.out.println("\nWatch History:");
        for (Movie m : watchHistory) {
            System.out.println(m);
        }
    }

    public static void main(String[] args) {

        StreamingSystem system = new StreamingSystem();

        system.addMovie(new Movie("Inception", "Sci-Fi"));
        system.addMovie(new Movie("Avengers", "Action"));
        system.addMovie(new Movie("Interstellar", "Sci-Fi"));
        system.addMovie(new Movie("Titanic", "Romance"));

        system.addToUpNext(new Movie("Inception", "Sci-Fi"));
        system.addToUpNext(new Movie("Avengers", "Action"));

        system.watchMovie();
        system.watchMovie();

        system.showHistory();
        system.showRecommendations();
    }
}