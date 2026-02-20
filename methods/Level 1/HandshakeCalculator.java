import java.util.Scanner;

public class HandshakeCalculator {

    public static int takeInput(Scanner sc) {
        System.out.print("Enter the number of students: ");
        return sc.nextInt();
    }

    public static int calculateHandshakes(int numberOfStudents) {
        if (numberOfStudents < 2) {
            return 0;
        }
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void displayResult(int students, int handshakes) {
        System.out.println("Maximum number of possible handshakes among "
                + students + " students = " + handshakes);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfStudents = takeInput(sc);
        int handshakes = calculateHandshakes(numberOfStudents);
        displayResult(numberOfStudents, handshakes);

        sc.close();
    }
}
