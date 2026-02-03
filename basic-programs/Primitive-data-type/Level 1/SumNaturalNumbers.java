import java.util.Scanner;

class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a valid natural number (greater than 0).");
        } else {
           
            int sumWhile = 0;
            int i = 1;

            while (i <= n) {
                sumWhile = sumWhile + i;
                i++;
            }

       
            int sumFormula = n * (n + 1) / 2;

        
            System.out.println("Sum using while loop = " + sumWhile);
            System.out.println("Sum using formula = " + sumFormula);

           
            if (sumWhile == sumFormula) {
                System.out.println("Both results are correct and equal.");
            } else {
                System.out.println("Results are not equal.");
            }
        }

        sc.close();
    }
}
