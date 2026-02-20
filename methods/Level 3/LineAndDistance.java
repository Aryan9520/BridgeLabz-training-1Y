import java.util.Scanner;

public class LineAndDistance {

    public static double findEuclideanDistance(double x1, double y1,
                                               double x2, double y2) {
        double distance = Math.sqrt(
                Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)
        );
        return distance;
    }

    public static double[] findLineEquation(double x1, double y1,
                                            double x2, double y2) {

        if (x2 - x1 == 0) {
            return null; // Vertical line (slope undefined)
        }

        double m = (y2 - y1) / (x2 - x1); // slope
        double b = y1 - m * x1;           // y-intercept

        return new double[]{m, b};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1 and y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.print("Enter x2 and y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        double distance = findEuclideanDistance(x1, y1, x2, y2);
        System.out.println("Euclidean Distance = " + distance);

        double[] line = findLineEquation(x1, y1, x2, y2);

        if (line == null) {
            System.out.println("The line is vertical (x = " + x1 + "), slope is undefined.");
        } else {
            double m = line[0];
            double b = line[1];

            System.out.println("Slope (m) = " + m);
            System.out.println("Y-intercept (b) = " + b);
            System.out.println("Equation of line: y = " + m + "x + " + b);
        }
    }
}
