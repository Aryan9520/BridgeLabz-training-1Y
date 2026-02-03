import java.util.Scanner;

class LargestOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int number1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int number2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int number3 = sc.nextInt();
        if (number1 > number2 && number1 > number3) {
            System.out.println("Is the first number the largest? YES");
        } else {
            System.out.println("Is the first number the largest? NO");
        }
        if (number2 > number1 && number2 > number3) {
            System.out.println("Is the second number the largest? YES");
        } else {
            System.out.println("Is the second number the largest? NO");
        }
        if (number3 > number1 && number3 > number2) {
            System.out.println("Is the third number the largest? YES");
        } else {
            System.out.println("Is the third number the largest? NO");
        }
    }
}
