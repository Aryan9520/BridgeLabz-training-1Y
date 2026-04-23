import java.util.Scanner;
import java.util.regex.*;

public class ProgrammingLanguageExtractor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.useDelimiter("\\A").next();

        Pattern p = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}