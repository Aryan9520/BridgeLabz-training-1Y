import java.util.Scanner;
class Sumofarray
{ public static void main(String[]args)
{ Scanner sc= new Scanner(System.in);
System.out.print("Enter array size:");
int n = sc.nextInt();
int arr[]=new int[n];
int sum=0;
System.out.print("Enter the Elements:");
for(int i=0;i<n;i++){
arr[i]=sc.nextInt();
sum=sum+arr[i];
}
System.out.print("Sum of array elements:" +sum);
}
}