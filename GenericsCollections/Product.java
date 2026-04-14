import java.util.*;

class Product {
    double price;

    Product(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class Mobile extends Product {
    Mobile(double price) {
        super(price);
    }
}

class Laptop extends Product {
    Laptop(double price) {
        super(price);
    }
}

public class Main {

    public static double calculateTotal(List<? extends Product> items) {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public static void main(String[] args) {

        List<Mobile> mobiles = new ArrayList<>();
        mobiles.add(new Mobile(15000));
        mobiles.add(new Mobile(20000));

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop(50000));
        laptops.add(new Laptop(70000));

        System.out.println("Mobile Total: " + calculateTotal(mobiles));
        System.out.println("Laptop Total: " + calculateTotal(laptops));
    }
}