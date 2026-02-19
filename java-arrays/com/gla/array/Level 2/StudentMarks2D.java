import java.util.Scanner;

public class StudentMarks2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int number = sc.nextInt();

        double[][] marks = new double[number][3];
        double[] percentage = new double[number];
        String[] grade = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Enter marks for Student " + (i + 1));

            for (int j = 0; j < 3; j++) {
                double input;
                do {
                    if (j == 0) {
                        System.out.print("Physics: ");
                    } else if (j == 1) {
                        System.out.print("Chemistry: ");
                    } else {
                        System.out.print("Maths: ");
                    }
                    input = sc.nextDouble();
                    if (input < 0) {
                        System.out.println("Invalid marks. Enter positive value.");
                    }
                } while (input < 0);

                marks[i][j] = input;
            }
        }

        for (int i = 0; i < number; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 90) {
                grade[i] = "A";
            } else if (percentage[i] >= 75) {
                grade[i] = "B";
            } else if (percentage[i] >= 60) {
                grade[i] = "C";
            } else if (percentage[i] >= 40) {
                grade[i] = "D";
            } else {
                grade[i] = "F";
            }
        }

        System.out.println("\nStudent Results:");
        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1) +
                    " | Physics = " + marks[i][0] +
                    " | Chemistry = " + marks[i][1] +
                    " | Maths = " + marks[i][2] +
                    " | Percentage = " + percentage[i] +
                    " | Grade = " + grade[i]);
        }

        sc.close();
    }
}
