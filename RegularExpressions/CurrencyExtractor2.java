import java.util.Scanner;
import java.util.regex.*;

public class CurrencyExtractor2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.useDelimiter("\\A").next();

        Pattern p = Pattern.compile("\\$\\d+\\.\\d{2}|\\b\\d+\\.\\d{2}\\b");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}