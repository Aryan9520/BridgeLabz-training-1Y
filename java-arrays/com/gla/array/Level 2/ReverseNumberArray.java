import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;
        if (temp < 0) {
            temp = -temp;
        }

        int count = 0;
        int copy = temp;
        if (copy == 0) {
            count = 1;
        } else {
            while (copy != 0) {
                count++;
                copy = copy / 10;
            }
        }

        int[] digits = new int[count];
        int index = 0;

        if (temp == 0) {
            digits[index] = 0;
        } else {
            while (temp != 0) {
                digits[index] = temp % 10;
                temp = temp / 10;
                index++;
            }
        }

        int[] reverse = new int[count];
        for (int i = 0; i < count; i++) {
            reverse[i] = digits[i];
        }

        System.out.println("Reversed digits:");
        for (int i = 0; i < reverse.length; i++) {
            System.out.print(reverse[i] + " ");
        }

        sc.close();
    }
}
