import java.util.Scanner;
class Volumeofcyclinder
	{ public static void main(String[]args) 
		{
		Scanner sc = new Scanner(System.in);
		System.out.print("ENTER THE RADIUS: ");
		double radius = sc.nextDouble();
		System.out.print("ENTER THE HEIGHT: ");
		double height = sc.nextDouble();
		double volumne = 3.14*radius*height;
 System.out.print(" volumne of the cyclinder=" +volumne);
		}
	}