import java.util.Scanner;

public class SpaceReplacer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        text = text.replaceAll("\\s+", " ");
        System.out.println(text);
    }
}