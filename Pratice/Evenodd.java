import java.util.Scanner;
class Evenodd
{ public static void main(String[]args)
{ Scanner sc = new Scanner(System.in);
System.out.print("ENTER THE NUMBER:");
int x = sc.nextInt();
if (x%2==0) {
System.out.println("Even");
} else{
System.out.println("Odd");
}
}
}