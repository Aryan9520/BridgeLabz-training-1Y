import java.util.Scanner;

public class CreditCardValidator5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String card = sc.nextLine();

        if (card.matches("^[45]\\d{15}$")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}