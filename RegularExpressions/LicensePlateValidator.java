import java.util.Scanner;

public class LicensePlateValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String plate = sc.nextLine();

        if (plate.matches("^[A-Z]{2}[0-9]{4}$")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}