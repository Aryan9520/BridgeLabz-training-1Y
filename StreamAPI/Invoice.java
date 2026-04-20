import java.util.*;
import java.util.stream.*;

class Invoice {
    String id;

    Invoice(String id) {
        this.id = id;
    }

    void show() {
        System.out.println("Invoice ID: " + id);
    }
}

public class Main {
    public static void main(String[] args) {

        List<String> ids = Arrays.asList("T101", "T102", "T103");

        ids.stream()
           .map(Invoice::new)
           .forEach(Invoice::show);
    }
}