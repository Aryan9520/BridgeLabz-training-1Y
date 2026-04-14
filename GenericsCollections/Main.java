public class Main {
    public static void main(String[] args) {

        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println(intBox.get());

        Box<String> strBox = new Box<>();
        strBox.set("Hello Java");
        System.out.println(strBox.get());

        Box<Double> doubleBox = new Box<>();
        doubleBox.set(99.99);
        System.out.println(doubleBox.get());
    }
}