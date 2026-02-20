import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    public static void generateException(String text) {
        String result = text.substring(5, 2);
        System.out.println(result);
    }

    public static void handleException(String text) {
        try {
            String result = text.substring(5, 2);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled: Start index is greater than end index.");
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
