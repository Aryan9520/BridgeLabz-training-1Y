import java.util.*;

public class determine {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {3,4,5};

        System.out.println(isSubset(arr1, arr2));

        int[] arr3 = {1,2,3,4,5};
        int[] arr4 = {1,2,9};

        System.out.println(isSubset(arr3, arr4));
    }

    static boolean isSubset(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : a) set.add(x);
        for (int x : b) if (!set.contains(x)) return false;
        return true;
    }
}