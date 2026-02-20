import java.util.Scanner;

public class WordsLength2DArray {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] data = getWordsWithLengths(words);

        System.out.println("\nWord\tLength");
        for (int i = 0; i < data.length; i++) {
            int length = Integer.parseInt(data[i][1]);
            System.out.println(data[i][0] + "\t" + length);
        }

        sc.close();
    }
}
