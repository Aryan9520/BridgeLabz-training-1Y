import java.util.Scanner;

public class UniqueCharFrequency {

    public static char[] uniqueCharacters(String text) {
        int length = text.length();
        char[] temp = new char[length];
        int count = 0;

        for (int i = 0; i < length; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[count] = current;
                count++;
            }
        }

        char[] unique = new char[count];
        for (int i = 0; i < count; i++) {
            unique[i] = temp[i];
        }

        return unique;
    }

    public static String[][] frequencyUsingUnique(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        char[] unique = uniqueCharacters(text);
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            char ch = unique[i];
            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(frequency[ch]);
        }

        return result;
    }

    public static void display(String[][] data) {
        System.out.println("Character\tFrequency");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] freqData = frequencyUsingUnique(text);
        display(freqData);

        sc.close();
    }
}
