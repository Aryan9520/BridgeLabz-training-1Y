import java.util.Scanner;

public class TrigonometricCalculator {

    public static double takeInput(Scanner sc) {
        System.out.print("Enter angle in degrees: ");
        return sc.nextDouble();
    }

    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);

        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        return new double[]{sine, cosine, tangent};
    }

    public static void displayResult(double angle, double[] values) {
        System.out.println("Angle (in degrees): " + angle);
        System.out.println("Sine = " + values[0]);
        System.out.println("Cosine = " + values[1]);
        System.out.println("Tangent = " + values[2]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double angle = takeInput(sc);
        double[] results = calculateTrigonometricFunctions(angle);
        displayResult(angle, results);

        sc.close();
    }
}
