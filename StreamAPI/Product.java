import java.util.*;

class Product {
    String name;
    int price, rating, discount;

    Product(String name, int price, int rating, int discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }
}

public class EcommerceSort {
    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("Laptop", 50000, 5, 20));
        list.add(new Product("Phone", 20000, 4, 15));
        list.add(new Product("Watch", 5000, 3, 30));

        Collections.sort(list, (a, b) -> a.price - b.price);

        for (Product p : list) {
            System.out.println(p.name + " " + p.price);
        }
    }
}