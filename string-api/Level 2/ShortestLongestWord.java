import java.util.Scanner;

public class ShortestLongestWord {

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

    public static String[] splitWords(String text) {
        int length = findLength(text);

        int wordCount = 1;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int start = 0;
        int wIndex = 0;

        for (int i = 0; i <= length; i++) {
            if (i == length || text.charAt(i) == ' ') {
                String word = "";
                for (int j = start; j < i; j++) {
                    word = word + text.charAt(j);
                }
                words[wIndex] = word;
                wIndex++;
                start = i + 1;
            }
        }

        return words;
    }

    public static String[][] getWordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            int len = findLength(words[i]);
            result[i][0] = words[i];
            result[i][1] = String.valueOf(len);
        }

        return result;
    }

    public static int[] findShortestAndLongest(String[][] data) {
        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 1; i < data.length; i++) {
            int currentLength = Integer.parseInt(data[i][1]);
            int shortestLength = Integer.parseInt(data[shortestIndex][1]);
            int longestLength = Integer.parseInt(data[longestIndex][1]);

            if (currentLength < shortestLength) {
                shortestIndex = i;
            }
            if (currentLength > longestLength) {
                longestIndex = i;
            }
        }

        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] wordsWithLengths = getWordsWithLengths(words);
        int[] result = findShortestAndLongest(wordsWithLengths);

        int shortestIndex = result[0];
        int longestIndex = result[1];

        System.out.println("\nShortest word: " + wordsWithLengths[shortestIndex][0]);
        System.out.println("Length: " + Integer.parseInt(wordsWithLengths[shortestIndex][1]));

        System.out.println("\nLongest word: " + wordsWithLengths[longestIndex][0]);
        System.out.println("Length: " + Integer.parseInt(wordsWithLengths[longestIndex][1]));

        sc.close();
    }
}
