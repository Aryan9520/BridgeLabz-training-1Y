import java.util.Scanner;

public class PalindromeCheck {

    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    public static char[] reverseUsingCharAt(String text) {
        char[] reverse = new char[text.length()];
        int index = 0;

        for (int i = text.length() - 1; i >= 0; i--) {
            reverse[index] = text.charAt(i);
            index++;
        }
        return reverse;
    }

    public static boolean isPalindromeUsingArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = reverseUsingCharAt(text);

        if (original.length != reverse.length) {
            return false;
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        boolean result1 = isPalindromeIterative(text);
        boolean result2 = isPalindromeRecursive(text, 0, text.length() - 1);
        boolean result3 = isPalindromeUsingArray(text);

        System.out.println("Palindrome Check using Iterative Method: " + result1);
        System.out.println("Palindrome Check using Recursive Method: " + result2);
        System.out.println("Palindrome Check using Array Method: " + result3);

        sc.close();
    }
}
