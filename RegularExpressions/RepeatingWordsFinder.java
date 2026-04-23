import java.util.Scanner;
import java.util.regex.*;

public class RepeatingWordsFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.useDelimiter("\\A").next();

        Pattern p = Pattern.compile("\\b(\\w+)\\s+\\1\\b");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
}