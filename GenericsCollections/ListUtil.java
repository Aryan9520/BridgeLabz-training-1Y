import java.util.*;

class ListUtil {
    public static void copyList(List<? super Number> dest, List<? extends Number> src) {
        for (Number n : src) {
            dest.add(n);
        }
    }
}

class Test {
    public static void main(String[] args) {
        List<Integer> src = Arrays.asList(10, 20, 30);
        List<Number> dest = new ArrayList<>();

        ListUtil.copyList(dest, src);

        System.out.println(dest);
    }
}