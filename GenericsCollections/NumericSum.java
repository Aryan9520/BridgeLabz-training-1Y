import java.util.*;

class NumericSum {
    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }
}

class Test {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Double> list2 = Arrays.asList(2.5, 3.5, 4.0);

        System.out.println(sumNumbers(list1));
        System.out.println(sumNumbers(list2));
    }
}