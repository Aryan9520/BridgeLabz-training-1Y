import java.util.Scanner;

public class SubstringCompare {

    public static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result = result + text.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        if (start < 0 || end > text.length() || start > end) {
            System.out.println("Invalid indices.");
            sc.close();
            return;
        }

        String substringCharAt = createSubstring(text, start, end);
        String substringBuiltIn = text.substring(start, end);

        boolean comparisonResult = compareStrings(substringCharAt, substringBuiltIn);

        System.out.println("Substring using charAt(): " + substringCharAt);
        System.out.println("Substring using substring(): " + substringBuiltIn);
        System.out.println("Are both substrings equal? " + comparisonResult);

        sc.close();
    }
}
