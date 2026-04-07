import java.util.ArrayList;

public class SensorDataLogger {

    static ArrayList<Double> data = new ArrayList<>();

    public static void logTemperature(double temp) {
        data.add(temp);
    }

    public static void logTemperature(Double temp) {
        data.add(temp);
    }

    public static void displayData() {
        for (Double value : data) {
            double temp = value;
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {

        logTemperature(25.5);
        logTemperature(30.2);
        logTemperature(Double.valueOf(28.7));

        displayData();
    }
}