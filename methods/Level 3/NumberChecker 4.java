import java.util.Scanner;

public class NumberChecker {

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNeon(int number) {
        int square = number * number;
        int sum = 0;

        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }

        return sum == number;
    }

    public static boolean isSpy(int number) {
        int temp = Math.abs(number);
        int sum = 0;
        int product = 1;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }

        return sum == product;
    }

    public static boolean isAutomorphic(int number) {
        int square = number * number;
        int temp = number;

        while (temp > 0) {
            if (temp % 10 != square % 10) {
                return false;
            }
            temp /= 10;
            square /= 10;
        }
        return true;
    }

    public static boolean isBuzz(int number) {
        if (number % 7 == 0 || number % 10 == 7) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (isPrime(number)) {
            System.out.println(number + " is a Prime Number.");
        } else {
            System.out.println(number + " is not a Prime Number.");
        }

        if (isNeon(number)) {
            System.out.println(number + " is a Neon Number.");
        } else {
            System.out.println(number + " is not a Neon Number.");
        }

        if (isSpy(number)) {
            System.out.println(number + " is a Spy Number.");
        } else {
            System.out.println(number + " is not a Spy Number.");
        }

        if (isAutomorphic(number)) {
            System.out.println(number + " is an Automorphic Number.");
        } else {
            System.out.println(number + " is not an Automorphic Number.");
        }

        if (isBuzz(number)) {
            System.out.println(number + " is a Buzz Number.");
        } else {
            System.out.println(number + " is not a Buzz Number.");
        }
    }
}
