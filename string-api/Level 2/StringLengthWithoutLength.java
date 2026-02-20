import java.util.Scanner;

public class StringLengthWithoutLength {

    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        int userLength = findLength(text);
        int builtInLength = text.length();

        System.out.println("Length using user-defined method: " + userLength);
        System.out.println("Length using built-in length() method: " + builtInLength);

        sc.close();
    }
}
