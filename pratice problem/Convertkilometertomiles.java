import java.util.Scanner;
class Convertkilometertomiles
	{
	public static void main(String[] args)
		{ Scanner sc = new Scanner(System.in);
		System.out.print("ENTER THE KILOMETER:");
		double kilometer = sc.nextDouble();
		double miles= kilometer*0.621371;
		
	System.out.print("Kilometer to Miles=" +miles);
	}
		}
		
	