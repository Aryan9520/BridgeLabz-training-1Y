import java.util.*;

public class LibraryCatalog {

    public static void main(String[] args) {

        Map<String, String> catalog = new HashMap<>();

        catalog.put("978-1111111111", "Java Basics");
        catalog.put("978-2222222222", "Data Structures");
        catalog.put("978-3333333333", "Algorithms");

        searchByISBN(catalog, "978-1111111111");
        searchByISBN(catalog, "978-9999999999");

        catalog.remove("978-2222222222");
        System.out.println("\nRemoved book with ISBN 978-2222222222");

        System.out.println("\nBooks Sorted by ISBN:");
        Map<String, String> sorted = new TreeMap<>(catalog);
        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        searchByTitle(catalog, "Algorithms");
    }

    public static void searchByISBN(Map<String, String> catalog, String isbn) {
        if (catalog.containsKey(isbn)) {
            System.out.println("Found: " + catalog.get(isbn));
        } else {
            System.out.println("Book not found");
        }
    }

    public static void searchByTitle(Map<String, String> catalog, String title) {
        System.out.println("\nSearching by Title: " + title);

        boolean found = false;

        for (Map.Entry<String, String> entry : catalog.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(title)) {
                System.out.println("Found ISBN: " + entry.getKey());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found");
        }
    }
}