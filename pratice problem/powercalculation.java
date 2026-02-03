import java.util.Scanner;
class Student{
	public static void main(String[]args)
		{
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER THE M:");
		double m = sc.nextDouble();
		System.out.print("ENTER THE N:");
		double n = sc.nextDouble();
		double powercalculation = Math.pow(m, n);
		System.out.print("POWER CALCULATION:" +powercalculation);
		
		}
	}


