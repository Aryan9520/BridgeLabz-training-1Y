import java.util.*;

class SumUtil {
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(10, 20, 30);
        List<Double> doubleList = Arrays.asList(5.5, 2.5, 1.0);

        System.out.println(sumNumbers(intList));
        System.out.println(sumNumbers(doubleList));
    }
}