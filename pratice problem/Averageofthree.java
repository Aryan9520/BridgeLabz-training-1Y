import java.util.Scanner;
class Averageofthree
	{ public static void main(String[]args)
		{
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER THE FIRST NUMBER:");
		double num1 = sc.nextDouble();
		System.out.print("ENTER THE SECOND NUMBER:");
		double num2 = sc.nextDouble();
		System.out.print("ENTER THE THIRD NUMBER:");
		double num3 = sc.nextDouble();
		double average = (num1+num2+num3) /3;
		System.out.print("Average of three=" +average);
		}
	}