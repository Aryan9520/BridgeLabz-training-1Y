import java.util.Scanner;

public class NumberFormatExceptionDemo {

    public static void generateException(String text) {
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }

    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled: Input is not a valid number.");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        try {
            generateException(text);
        } catch (Exception e) {
            System.out.println("Exception generated in generateException() method.");
        }

        handleException(text);

        sc.close();
    }
}
