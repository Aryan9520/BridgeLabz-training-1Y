
import java.util.Scanner;

public class NumberCheck {

    public static int takeInput(Scanner sc) {
        System.out.print("Enter an integer: ");
        return sc.nextInt();
    }

    public static int checkNumber(int number) {
        if (number > 0) {
            return 1;
        } else if (number < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void displayResult(int number, int result) {
        if (result == 1) {
            System.out.println(number + " is a Positive number.");
        } else if (result == -1) {
            System.out.println(number + " is a Negative number.");
        } else {
            System.out.println(number + " is Zero.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = takeInput(sc);
        int result = checkNumber(number);
        displayResult(number, result);

        sc.close();
    }
}
