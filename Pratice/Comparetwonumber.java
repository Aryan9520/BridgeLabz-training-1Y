import java.util.Scanner;
class Comparetwonumber
{ public static void main(String[]args)
{Scanner sc = new Scanner(System.in);
System.out.print("ENTER THE VALUE OF a:");
int a = sc.nextInt();
System.out.println("ENTER THE VALUE OF b:");
int b = sc.nextInt();
if (a==b){
System.out.print("EQUAL");
}else {
if(a<b) {
System.out.print("a is lesser than b");
}  else {
System.out.print("a is greater than b");
}
}
} 
}