import java.util.Scanner;

public class NumberChecker {

    public static int countDigits(int number) {
        number = Math.abs(number);
        if (number == 0) {
            return 1;
        }
        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static int[] storeDigits(int number) {
        number = Math.abs(number);
        int count = countDigits(number);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += (int) Math.pow(digits[i], 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        if (sum == 0) {
            return false;
        }
        return number % sum == 0;
    }

    public static int[][] findDigitFrequency(int[] digits) {
        int[][] freq = new int[10][2];

        for (int i = 0; i < 10; i++) {
            freq[i][0] = i;      // digit
            freq[i][1] = 0;      // frequency
        }

        for (int i = 0; i < digits.length; i++) {
            int d = digits[i];
            freq[d][1]++;
        }

        return freq;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int digitCount = countDigits(number);
        int[] digits = storeDigits(number);

        System.out.println("Count of digits = " + digitCount);

        System.out.print("Digits array: ");
        for (int i = 0; i < digits.length; i++) {
            System.out.print(digits[i] + " ");
        }
        System.out.println();

        int sumDigits = sumOfDigits(digits);
        System.out.println("Sum of digits = " + sumDigits);

        int sumSquares = sumOfSquaresOfDigits(digits);
        System.out.println("Sum of squares of digits = " + sumSquares);

        if (isHarshadNumber(number, digits)) {
            System.out.println("It is a Harshad Number.");
        } else {
            System.out.println("It is not a Harshad Number.");
        }

        int[][] frequency = findDigitFrequency(digits);
        System.out.println("Digit Frequency (Digit : Frequency):");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i][1] > 0) {
                System.out.println(frequency[i][0] + " : " + frequency[i][1]);
            }
        }
    }
}
