import java.util.Scanner;

public class SimpleInterestCalculator {

    public static double[] takeInput(Scanner sc) {
        double[] values = new double[3];

        System.out.print("Enter Principal: ");
        values[0] = sc.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        values[1] = sc.nextDouble();

        System.out.print("Enter Time: ");
        values[2] = sc.nextDouble();

        return values;
    }

    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }

    public static void displayResult(double principal, double rate, double time, double si) {
        System.out.println("The Simple Interest is " + si +
                " for Principal " + principal +
                ", Rate of Interest " + rate +
                " and Time " + time);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] inputs =
