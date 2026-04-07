import java.util.ArrayList;

public class ShoppingCart2 {
    public static void main(String[] args) {

        String[] prices = {"250", "499", "99", "abc", "150"};

        ArrayList<Integer> list = new ArrayList<>();
        int total = 0;

        for (String p : prices) {
            try {
                int value = Integer.parseInt(p);
                list.add(value);
                total += value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid price: " + p);
            }
        }

        System.out.println("Prices: " + list);
        System.out.println("Total: " + total);
    }
}