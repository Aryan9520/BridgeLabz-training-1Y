import java.util.Scanner;

public class AthleteRounds {

    public static double[] takeInput(Scanner sc) {
        double[] sides = new double[3];

        System.out.print("Enter side 1 (in meters): ");
        sides[0] = sc.nextDouble();

        System.out.print("Enter side 2 (in meters): ");
        sides[1] = sc.nextDouble();

        System.out.print("Enter side 3 (in meters): ");
        sides[2] = sc.nextDouble();

        return sides;
    }

    public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        double distance = 5000.0;
        return distance / perimeter;
    }

    public static void displayResult(double a, double b, double c, double rounds) {
        double perimeter = a + b + c;
        System.out.println("Perimeter of the triangular park = " + perimeter + " meters");
        System.out.println("Number of rounds to complete 5 km run = " + rounds);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] sides = takeInput(sc);
        double rounds = calculateRounds(sides[0], sides[1], sides[2]);
        displayResult(sides[0], sides[1], sides[2], rounds);

        sc.close();
    }
}
