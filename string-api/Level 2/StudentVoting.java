import java.util.Scanner;

public class StudentVoting {

    public static int[] getAges(int n, Scanner sc) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }
        return ages;
    }

    public static String[][] checkVoting(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "False";
            } else if (ages[i] >= 18) {
                result[i][1] = "True";
            } else {
                result[i][1] = "False";
            }
        }

        return result;
    }

    public static void displayTable(String[][] data) {
        System.out.println("Age\tCan Vote");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 10;
        int[] ages = getAges(n, sc);

        String[][] votingResult = checkVoting(ages);

        displayTable(votingResult);

        sc.close();
    }
}
