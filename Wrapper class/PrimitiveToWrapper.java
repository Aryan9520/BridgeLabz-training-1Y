import java.util.Scanner;

public class PrimitiveToWrapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Integer obj = Integer.valueOf(num);
        System.out.println(num);
        System.out.println(obj);
    }
}