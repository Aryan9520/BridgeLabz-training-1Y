import java.util.Scanner;

public class BadWordCensor2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.useDelimiter("\\A").next();

        text = text.replaceAll("\\b(damn|stupid)\\b", "****");

        System.out.println(text);
    }
}