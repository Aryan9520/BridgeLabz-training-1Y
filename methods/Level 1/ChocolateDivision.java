import java.util.Scanner;

public class ChocolateDivision {

    public static int[] takeInput(Scanner sc) {
        int[] values = new int[2];

        System.out.print("Enter number of chocolates: ");
        values[0] = sc.nextInt();

        System.out.print("Enter number of children: ");
        values[1] = sc.nextInt();

        return values;
    }

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        if (divisor <= 0) {
            System.out.println("Number of children must be greater than 0.");
            return new int[]{0, 0};
        }

        int chocolatesPerChild = number / divisor;
        int remainingChocolates = number % divisor;

        return new int[]{chocolatesPerChild, remainingChocolates};
    }

    public static void displayResult(int chocolates, int children, int perChild, int remaining) {
        System.out.println("Total Chocolates: " + chocolates);
        System.out.println("Number of Children: " + children);
        System.out.println("Chocolates each child gets = " + perChild);
        System.out.println("Remaining chocolates = " + remaining);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] inputs = takeInput(sc);
        int numberOfChocolates = inputs[0];
        int numberOfChildren = inputs[1];

        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);
        displayResult(numberOfChocolates, numberOfChildren, result[0], result[1]);

        sc.close();
    }
}
