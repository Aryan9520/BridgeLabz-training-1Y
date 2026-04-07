import java.util.ArrayList;

public class PerformanceTest {

    public static void main(String[] args) {

        int n = 1_000_000;

        int[] arr = new int[n];
        long start1 = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        long sum1 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i];
        }

        long end1 = System.currentTimeMillis();

        ArrayList<Integer> list = new ArrayList<>();
        long start2 = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        long sum2 = 0;
        for (Integer val : list) {
            sum2 += val;
        }

        long end2 = System.currentTimeMillis();

        System.out.println("int[] sum: " + sum1 + " | Time: " + (end1 - start1) + " ms");
        System.out.println("ArrayList<Integer> sum: " + sum2 + " | Time: " + (end2 - start2) + " ms");
    }
}