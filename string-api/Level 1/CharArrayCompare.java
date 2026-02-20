import java.util.Scanner;

public class CharArrayCompare {

    public static char[] getCharacters(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] userDefinedArray = getCharacters(text);
        char[] builtInArray = text.toCharArray();

        boolean result = compareCharArrays(userDefinedArray, builtInArray);

        System.out.println("Characters using user-defined method:");
        for (int i = 0; i < userDefinedArray.length; i++) {
            System.out.print(userDefinedArray[i] + " ");
        }

        System.out.println("\nCharacters using toCharArray() method:");
        for (int i = 0; i < builtInArray.length; i++) {
            System.out.print(builtInArray[i] + " ");
        }

        System.out.println("\nAre both arrays equal? " + result);

        sc.close();
    }
}
