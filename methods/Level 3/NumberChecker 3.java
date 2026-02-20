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

    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];
        int j = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            reversed[j] = digits[i];
            j++;
        }
        return reversed;
    }

    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseArray(digits);
        return compareArrays(digits, reversed);
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) {
                return true;
            }
        }
        return false;
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

        int[] reversedDigits = reverseArray(digits);
        System.out.print("\nReversed digits array: ");
        for (int i = 0; i < reversedDigits.length; i++) {
            System.out.print(reversedDigits[i] + " ");
        }

        boolean arraysEqual = compareArrays(digits, reversedDigits);
        System.out.println("\nAre original and reversed arrays equal? " + arraysEqual);

        if (isPalindrome(digits)) {
            System.out.println("The number is a Palindrome.");
        } else {
            System.out.println("The number is not a Palindrome.");
        }

        if (isDuckNumber(digits)) {
            System.out.println("The number is a Duck Number.");
        } else {
            System.out.println("The number is not a Duck Number.");
        }
    }
}
