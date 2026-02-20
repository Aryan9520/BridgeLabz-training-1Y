import java.util.Scanner;

public class CollinearUsingArea {

    public static double findTriangleArea(double x1, double y1,
                                          double x2, double y2,
                                          double x3, double y3) {
        double area = 0.5 * (x1 * (y2 - y3)
                           + x2 * (y3 - y1)
                           + x3 * (y1 - y2));
        return area;
    }

    public static boolean areCollinear(double x1, double y1,
                                       double x2, double y2,
                                       double x3, double y3) {
        double area = findTriangleArea(x1, y1, x2, y2, x3, y3);
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

        double area = findTriangleArea(x1, y1, x2, y2, x3, y3);

        System.out.println("Area of Triangle = " + area);

        if (areCollinear(x1, y1, x2, y2, x3, y3)) {
            System.out.println("The three points are Collinear.");
        } else {
            System.out.println("The three points are Not Collinear.");
        }
    }
}
