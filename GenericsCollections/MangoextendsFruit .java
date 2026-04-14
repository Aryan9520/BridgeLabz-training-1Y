import java.util.ArrayList;

class Fruit {
    public void display() {
        System.out.println("This is a fruit");
    }
}

class Apple extends Fruit {
    @Override
    public void display() {
        System.out.println("Apple");
    }
}

class MangoextendsFruit {
    @Override
    public void display() {
        System.out.println("Mango");
    }
}

class FruitBox<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void displayFruits() {
        for (T fruit : fruits) {
            fruit.display();
        }
    }
}

class Test {
    public static void main(String[] args) {
        FruitBox<Fruit> box = new FruitBox<>();

        box.add(new Apple());
        box.add(new Mango());

        box.displayFruits();

        // This will give compile-time error ❌
        // class Car {}
        // box.add(new Car());  // Not allowed because Car is not a Fruit
    }
}