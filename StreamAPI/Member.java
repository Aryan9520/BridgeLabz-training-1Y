import java.time.*;
import java.util.*;
import java.util.stream.*;

class Member {
    String name;
    LocalDate expiryDate;

    Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }
}

public class Main {
    public static void main(String[] args) {

        List<Member> list = Arrays.asList(
            new Member("Rahul", LocalDate.now().plusDays(10)),
            new Member("Amit", LocalDate.now().plusDays(40)),
            new Member("Neha", LocalDate.now().plusDays(25)),
            new Member("Priya", LocalDate.now().plusDays(5))
        );

        list.stream()
            .filter(m -> m.expiryDate.isBefore(LocalDate.now().plusDays(31)))
            .forEach(m -> System.out.println(m.name + " " + m.expiryDate));
    }
}