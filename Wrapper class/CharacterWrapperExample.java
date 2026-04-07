import java.util.Scanner;

public class CharacterWrapperExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int letters = 0, digits = 0, special = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isLetter(ch)) {
                letters++;
            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (!Character.isWhitespace(ch)) {
                special++;
            }
        }

        System.out.println("Total letters = " + letters);
        System.out.println("Total digits = " + digits);
        System.out.println("Total special characters = " + special);
    }
}