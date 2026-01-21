import java.util.Scanner;
class FeeDiscountCalculator {
    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Student Fee (INR): ");
        double fee = input.nextDouble();
		System.out.print("Enter University Discount Percent: ");
        double discountPercent = input.nextDouble();
		double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;
		System.out.println("The discount amount is INR " + discount +
                " and final discounted fee is INR " + finalFee);

        input.close();
    }
}
