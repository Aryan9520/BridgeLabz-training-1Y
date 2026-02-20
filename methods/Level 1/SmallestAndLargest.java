import java.util.Scanner;

public class SmallestAndLargest {

    public static int[] takeInput(Scanner sc) {
        int[] numbers = new int[3];

        System.out.print("Enter first number: ");
        numbers[0] = sc.nextInt();

        System.out.print("Enter second number: ");
        numbers[1] = sc.nextInt();

        System.out.print("Enter third number: ");
        numbers[2] = sc.nextInt();

        return numbers;
    }

    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = number1;
        int largest = number1;

        if (number2 < smallest) {
            smallest = number2;
        }
        if (number3 < smallest) {
            smallest = number3;
        }

        if (number2 > largest) {
            largest = number2;
        }
        if (number3 > largest) {
            largest = number3;
        }

        return new int[]{smallest, largest};
    }

    public static void displayResult(int smallest, int largest) {
        System.out.println("Smallest number = " + smallest);
        System.out.println("Largest number = " + largest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = takeInput(sc);
        int[] result = findSmallestAndLargest(numbers[0], numbers[1], numbers[2]);
        displayResult(result[0], result[1]);

        sc.close();
    }
}
