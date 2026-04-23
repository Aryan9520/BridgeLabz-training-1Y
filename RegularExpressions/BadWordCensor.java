import java.util.Scanner;

public class BadWordCensor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        text = text.replaceAll("\\b(damn|stupid)\\b", "****");
        System.out.println(text);
    }
}