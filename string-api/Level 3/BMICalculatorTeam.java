import java.util.Scanner;

public class BMICalculatorTeam {

    public static String[] calculateBMIAndStatus(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);

        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        return new String[]{String.format("%.2f", bmi), status};
    }

    public static String[][] processData(double[][] data) {
        int n = data.length;
        String[][] result = new String[n][4];

        for (int i = 0; i < n; i++) {
            double weight = data[i][0];
            double height = data[i][1];

            String[] bmiData = calculateBMIAndStatus(weight, height);

            result[i][0] = String.valueOf(height);
            result[i][1] = String.valueOf(weight);
            result[i][2] = bmiData[0];
            result[i][3] = bmiData[1];
        }

        return result;
    }

    public static void displayTable(String[][] table) {
        System.out.println("Height(cm)\tWeight(kg)\tBMI\tStatus");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t\t" + table[i][1] + "\t\t" + table[i][2] + "\t" + table[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 10;
        double[][] personData = new double[n][2];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Person " + (i + 1));

            System.out.print("Enter weight (kg): ");
            personData[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm): ");
            personData[i][1] = sc.nextDouble();
        }

        String[][] result = processData(personData);
        displayTable(result);

        sc.close();
    }
}
