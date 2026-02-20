
import java.util.Scanner;

public class FactorsProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] factors = findFactors(num);

        System.out.println("Factors of " + num + " are:");
        for (int i = 0; i < factors.length; i++) {
            System.out.print(factors[i] + " ");
        }

        int sum = sumOfFactors(factors);
        int product = productOfFactors(factors);
        int sumOfSquares = sumOfSquares(factors);

        System.out.println("\nSum of factors = " + sum);
        System.out.println("Product of factors = " + product);
        System.out.println("Sum of squares of factors = " + sumOfSquares);
    }

    static int[] findFactors(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors[index] = i;
                index++;
            }
        }

        return factors;
    }

    static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int i = 0; i < factors.length; i++) {
            sum += factors[i];
        }
        return sum;
    }

    static int productOfFactors(int[] factors) {
        int product = 1;
        for (int i = 0; i < factors.length; i++) {
            product *= factors[i];
        }
        return product;
    }

    static int sumOfSquares(int[] factors) {
        int sum = 0;
        for (int i = 0; i < factors.length; i++) {
            sum += (int) Math.pow(factors[i], 2);
        }
        return sum;
    }
}
