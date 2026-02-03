import java.util.Scanner;
class Table
{ public static void main(String[]args)
{ Scanner sc = new Scanner(System.in);
System.out.print("ENTER THE VALUE OF n:");
int n = sc.nextInt();
for(int i=1;i<11;i++){
System.out.println(i*n);
}
}
}
