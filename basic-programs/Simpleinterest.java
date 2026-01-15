import java.util.Scanner;
class Simpleinterest
	{ 
	public static void main(String[]args)
		{
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER THE PRINCIPAL:");
		double princial = sc.nextDouble();
		System.out.print("ENTER THE RATE:");
		double rate = sc.nextDouble();
		System.out.print("ENTER THE TIME:");
		double time = sc.nextDouble();
		double simpleinterest = princial*rate*time;
		
		System.out.print("SIMPLE INTEREST=" +simpleinterest);
		}
	}
		
		
		
