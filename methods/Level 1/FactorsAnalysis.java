import java.util.Scanner;

public class FactorsAnalysis {

    public static int takeInput(Scanner sc) {
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }

    public static int[] findFactors(int number) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    public static int findSum(int[] factors) {
        int sum = 0;
        for (int i = 0; i < factors.length; i++) {
            sum += factors[i];
        }
        return sum;
    }

    public static long findProduct(int[] factors) {
        long product = 1;
        for (int i = 0; i < factors.length; i++) {
            product *= factors[i];
        }
        return product;
    }

    public static double findSumOfSquares(int[] factors) {
        double sumSquares = 0;
        for (int i = 0; i < factors.length; i++) {
            sumSquares += Math.pow(factors[i], 2);
        }
        return sumSquares;
    }

    public static void displayResults(int number, int[] factors, int sum, long product, double sumSquares) {
        System.out.println("Factors of " + number + ":");
        for (int i = 0; i < factors.length; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();
        System.out.println("Sum of factors = " + sum);
        System.out.println("Product of factors = " + product);
        System.out.println("Sum of squares of factors = " + sumSquares);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = takeInput(sc);
        int[] factors = findFactors(number);
        int sum = findSum(factors);
        long product = findProduct(factors);
        double sumSquares = findSumOfSquares(factors);

        displayResults(number, factors, sum, product, sumSquares);

        sc.close();
    }
}
