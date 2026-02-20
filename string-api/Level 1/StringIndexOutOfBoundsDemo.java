import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    public static void generateException(String text) {
        System.out.println(text.charAt(text.length()));
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled: Index is out of range.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception generated in generateException() method.");
        }

        handleException(text);

        sc.close();
    }
}
