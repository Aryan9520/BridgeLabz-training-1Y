import java.util.ArrayList;
import java.util.Objects;

public class ProductRatingsAnalyzer {

    public static void main(String[] args) {

        int[] ratingsArray = {5, 4, 3, 5};
        ArrayList<Integer> ratingsList = new ArrayList<>();
        ratingsList.add(4);
        ratingsList.add(null);
        ratingsList.add(2);
        ratingsList.add(5);

        ArrayList<Integer> combined = new ArrayList<>();

        for (int r : ratingsArray) {
            combined.add(r);
        }

        combined.addAll(ratingsList);

        int sum = 0;
        int count = 0;

        for (Integer r : combined) {
            if (Objects.nonNull(r)) {
                sum += r;
                count++;
            }
        }

        double average = (count == 0) ? 0.0 : (double) sum / count;

        System.out.println("Combined Ratings: " + combined);
        System.out.println("Average Rating: " + average);
    }
}