import java.util.Scanner;

class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = sc.nextInt();

        int count = 0;

        
        if (number == 0) {
            count = 1;
        } else {
            
            if (number < 0) {
                number = -number;
            }

            while (number != 0) {
                number = number / 10; 
                count++;              
            }
        }

        System.out.println("Number of digits = " + count);

        sc.close();
    }
}
