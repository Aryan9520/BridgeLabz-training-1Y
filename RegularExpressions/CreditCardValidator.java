import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String card = sc.nextLine();

        if (card.matches("^(4|5)\\d{15}$")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}