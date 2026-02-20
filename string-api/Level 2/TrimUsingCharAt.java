import java.util.Scanner;

public class TrimUsingCharAt {

    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end + 1};
    }

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

        System.out.print("Enter text with spaces: ");
        String text = sc.nextLine();

        int[] indexes = findTrimIndexes(text);
        String userTrimmed = createSubstring(text, indexes[0], indexes[1]);
        String builtInTrimmed = text.trim();

        boolean isSame = compareStrings(userTrimmed, builtInTrimmed);

        System.out.println("Trimmed using charAt(): " + userTrimmed);
        System.out.println("Trimmed using trim(): " + builtInTrimmed);
        System.out.println("Are both results equal? " + isSame);

        sc.close();
    }
}
