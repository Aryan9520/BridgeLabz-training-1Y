import java.util.Scanner;

public class SumOfNaturalNumbers {

    public static int takeInput(Scanner sc) {
        System.out.print("Enter a number (n): ");
        return sc.nextInt();
    }

    public static int findSum(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    public static void displayResult(int n, int sum) {
        System.out.println("Sum of first " + n + " natural numbers = " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = takeInput(sc);
        int sum = findSum(n);
        displayResult(n, sum);

        sc.close();
    }
}
