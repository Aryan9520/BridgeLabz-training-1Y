import java.util.Scanner;

public class CharFrequency2D {

    public static String[][] findFrequency(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        boolean[] visited = new boolean[256];
        int uniqueCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!visited[ch]) {
                visited[ch] = true;
                uniqueCount++;
            }
        }

        String[][] result = new String[uniqueCount][2];
        boolean[] added = new boolean[256];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!added[ch]) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ch]);
                added[ch] = true;
                index++;
            }
        }

        return result;
    }

    public static void displayResult(String[][] data) {
        System.out.println("Character\tFrequency");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] freqData = findFrequency(text);
        displayResult(freqData);

        sc.close();
    }
}
