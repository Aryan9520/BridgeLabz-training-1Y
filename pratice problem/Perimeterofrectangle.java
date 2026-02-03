import java.util.Scanner;
class Perimeterofrectangle
	{ public static void main(String[]args)
		{ Scanner sc = new Scanner(System.in);
		System.out.print("ENTER THE LENGHT:");
		double lenght = sc.nextDouble();
		System.out.print("ENTER THE WIDTH:");
		double width = sc.nextDouble();
		double perimeter = 2*lenght*width;
		
		System.out.print("Perimeter of rectangle=" +perimeter);
		}
	}