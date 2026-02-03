import java.util.Scanner;

class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();

        if (number <= 1) {
            System.out.println("No greatest factor other than itself.");
        } else {
            int greatestFactor = 1;
            int counter = number - 1;   // start from last but one

            while (counter >= 1) {
                if (number % counter == 0) {
                    greatestFactor = counter;
                    break;   
                }
                counter--;   
            }

            System.out.println("Greatest factor (besides itself) = " + greatestFactor);
        }

        sc.close();
    }
}
