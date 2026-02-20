import java.util.Scanner;

public class QuotientAndRemainder {

    public static int[] takeInput(Scanner sc) {
        int[] values = new int[2];

        System.out.print("Enter the number: ");
        values[0] = sc.nextInt();

        System.out.print("Enter the divisor: ");
        values[1] = sc.nextInt();

        return values;
    }

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        if (divisor == 0) {
            System.out.println("Division by zero is not allowed.");
            return new int[]{0, 0};
        }

        int quotient = number / divisor;
        int remainder = number % divisor;

        return new int[]{quotient, remainder};
    }

    public static void displayResult(int number, int divisor, int quotient, int remainder) {
        System.out.println("Number: " + number);
        System.out.println("Divisor: " + divisor);
        System.out.println("Quotient = " + quotient);
        System.out.println("Remainder = " + remainder);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] inputs = takeInput(sc);
        int number = inputs[0];
        int divisor = inputs[1];

        int[] result = findRemainderAndQuotient(number, divisor);
        displayResult(number, divisor, result[0], result[1]);

        sc.close();
    }
}
