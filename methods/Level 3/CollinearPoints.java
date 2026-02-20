import java.util.Scanner;

public class CollinearPoints {

    public static boolean areCollinearBySlope(double x1, double y1,
                                              double x2, double y2,
                                              double x3, double y3) {

        if ((x2 - x1) == 0 && (x3 - x2) == 0) {
            return true;
        }

        if ((x2 - x1) == 0 || (x3 - x2) == 0) {
            return false;
        }

        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);

        return (slopeAB == slopeBC) && (slopeAB == slopeAC);
    }

    public static boolean areCollinearByArea(double x1, double y1,
                                             double x2, double y2,
                                             double x3, double y3) {

        double area = x1 * (y2 - y3)
                    + x2 * (y3 - y1)
                    + x3 * (y1 - y2);

        return area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x1 and y1: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.print("Enter x2 and y2: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        System.out.print("Enter x3 and y3: ");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        boolean collinearSlope = areCollinearBySlope(x1, y1, x2, y2, x3, y3);
        boolean collinearArea = areCollinearByArea(x1, y1, x2, y2, x3, y3);

        if (collinearSlope) {
            System.out.println("Points are collinear (Using Slope Formula).");
        } else {
            System.out.println("Points are not collinear (Using Slope Formula).");
        }

        if (collinearArea) {
            System.out.println("Points are collinear (Using Area of Triangle Formula).");
        } else {
            System.out.println("Points are not collinear (Using Area of Triangle Formula).");
        }
    }
}
