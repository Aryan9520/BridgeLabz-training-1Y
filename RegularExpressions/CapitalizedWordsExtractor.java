import java.util.Scanner;
import java.util.regex.*;

public class CapitalizedWordsExtractor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        Pattern p = Pattern.compile("\\b[A-Z][a-zA-Z]*\\b");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}