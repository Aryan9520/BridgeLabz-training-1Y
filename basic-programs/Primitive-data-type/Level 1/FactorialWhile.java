import java.util.Scanner;

class FactorialWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            int factorial = 1;
            int i = 1;

            while (i <= num) {
                factorial = factorial * i;
                i++;
            }

            System.out.println("Factorial of " + num + " = " + factorial);
        }

        sc.close();
    }
}
