import java.util.Scanner;

class Arraylength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = sc.nextInt();

        int number[] = new int[size];

        System.out.println("Enter elements:");
        for(int i = 0; i < size; i++) {
            number[i] = sc.nextInt();
        }

        System.out.print("Enter value to search (x): ");
        int x = sc.nextInt();

        for(int i = 0; i < number.length; i++) {
            if(number[i] == x) {
                System.out.println("X found at index: " + i);
            }
        }
    }
}
 