import java.util.*;

class Book3 {
    int id;
    String title;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String toString() {
        return id + " | " + title;
    }
}

public class LibrarySystem {

    List<Book> books = new ArrayList<>();
    Set<String> members = new HashSet<>();
    Queue<Book> issueQueue = new LinkedList<>();
    Stack<Book> returnedStack = new Stack<>();

    public void addBook(Book b) {
        books.add(b);
        System.out.println("Added Book: " + b);
    }

    public void registerMember(String id) {
        if (members.add(id)) {
            System.out.println("Registered Member: " + id);
        } else {
            System.out.println("Duplicate Member ID: " + id);
        }
    }

    public void requestBook(Book b) {
        issueQueue.add(b);
    }

    public void issueBooks() {
        System.out.println("\nIssuing Books:");
        while (!issueQueue.isEmpty()) {
            Book b = issueQueue.remove();
            System.out.println("Issued: " + b);
        }
    }

    public void returnBook(Book b) {
        returnedStack.push(b);
        System.out.println("Returned: " + b);
    }

    public void reissueLastReturned() {
        if (!returnedStack.isEmpty()) {
            Book b = returnedStack.pop();
            System.out.println("Re-Issued: " + b);
        }
    }

    public static void main(String[] args) {

        LibrarySystem system = new LibrarySystem();

        system.addBook(new Book(1, "Java Basics"));
        system.addBook(new Book(2, "Data Structures"));

        system.registerMember("M1");
        system.registerMember("M2");
        system.registerMember("M1");

        system.requestBook(new Book(1, "Java Basics"));
        system.requestBook(new Book(2, "Data Structures"));

        system.issueBooks();

        system.returnBook(new Book(1, "Java Basics"));
        system.returnBook(new Book(2, "Data Structures"));

        system.reissueLastReturned();
    }
}