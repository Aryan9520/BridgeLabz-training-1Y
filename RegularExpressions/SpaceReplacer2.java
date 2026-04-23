import java.util.Scanner;

public class SpaceReplacer2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.useDelimiter("\\A").next();

        text = text.replaceAll("\\s+", " ").trim();

        System.out.println(text);
    }
}