import java.util.ArrayList;

public class WrapperCollectionExample {
    public static void main(String[] args) {
        double[] prices = {10.5, 20.0, 35.75, 5.5};

        ArrayList<Double> list = new ArrayList<>();

        for (double p : prices) {
            list.add(p);
        }

        double max = list.get(0);
        double sum = 0;

        for (Double price : list) {
            if (price > max) {
                max = price;
            }
            sum += price;
        }

        double avg = sum / list.size();

        System.out.println("Highest price = " + max);
        System.out.println("Average price = " + avg);
    }
}