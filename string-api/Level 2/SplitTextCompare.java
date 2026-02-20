import java.util.Scanner;

public class SplitTextCompare {

    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static String[] splitUsingCharAt(String text) {
        int length = findLength(text);

        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        int[] spaceIndexes = new int[wordCount - 1];
        int sIndex = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[sIndex] = i;
                sIndex++;
            }
        }

        String[] words = new String[wordCount];
        int start = 0;

        for (int i = 0; i < wordCount; i++) {
            int end;
            if (i < wordCount - 1) {
                end = spaceIndexes[i];
            } else {
                end = length;
            }

            String word = "";
            for (int j = start; j < end; j++) {
                word = word + text.charAt(j);
            }
            words[i] = word;
            start = end + 1;
        }

        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        String[] userWords = splitUsingCharAt(text);
        String[] builtInWords = text.split(" ");

        boolean isSame = compareArrays(userWords, builtInWords);

        System.out.println("Wo
