import java.util.Scanner;
import java.util.regex.*;

public class DateExtractor3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.useDelimiter("\\A").next();

        Pattern p = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}