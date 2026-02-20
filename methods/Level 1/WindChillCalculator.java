import java.util.Scanner;

public class WindChillCalculator {

    public static double[] takeInput(Scanner sc) {
        double[] values = new double[2];

        System.out.print("Enter temperature (in Fahrenheit): ");
        values[0] = sc.nextDouble();

        System.out.print("Enter wind speed (in mph): ");
        values[1] = sc.nextDouble();

        return values;
    }

    public static double calculateWindChill(double temperature, double windSpeed) {
        return 35.74 + 0.6215 * temperature +
               (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }

    public static void displayResult(double temperature, double windSpeed, double windChill) {
        System.out.println("Temperature = " + temperature);
        System.out.println("Wind Speed = " + windSpeed);
        System.out.println("Wind Chill Temperature = " + windChill);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] inputs = takeInput(sc);
        double temperature = inputs[0];
        double windSpeed = inputs[1];

        double windChill = calculateWindChill(temperature, windSpeed);
        displayResult(temperature, windSpeed, windChill);

        sc.close();
    }
}
