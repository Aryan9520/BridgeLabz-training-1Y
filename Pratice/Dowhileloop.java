import java.util.Scanner;
class Dowhileloop
{
public static void main(String[]args)
{
Scanner sc = new Scanner(System.in);
System.out.print("ETNER THE NUMBER:");
int a = sc.nextInt();
do {
System.out.println(a);
a++;
}while(a<=6);
}
}