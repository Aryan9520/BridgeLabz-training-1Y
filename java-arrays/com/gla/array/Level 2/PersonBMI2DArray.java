import java.util.Scanner;

public class PersonBMI2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            double weight;
            double height;

            do {
                System.out.print("Enter weight of person " + (i + 1) + ": ");
                weight = sc.nextDouble();
                if (weight <= 0) {
                    System.out.println("Invalid weight. Enter positive value.");
                }
            } while (weight <= 0);

            do {
                System.out.print("Enter height (in meters) of person " + (i + 1) + ": ");
                height = sc.nextDouble();
                if (height <= 0) {
                    System.out.println("Invalid height. Enter positive value.");
                }
            } while (height <= 0);

            double bmi = weight / (height * height);

            personData[i][0] = height;
            personData[i][1] = weight;
            personData[i][2] = bmi;

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal";
            } else if (bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nPerson Details:");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1) +
                    " | Height = " + personData[i][0] +
                    " | Weight = " + personData[i][1] +
                    " | BMI = " + personData[i][2] +
                    " | Status = " + weightStatus[i]);
        }

        sc.close();
    }
}
