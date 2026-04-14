import java.util.*;

public class SetPerformanceTest {

    public static void main(String[] args) {

        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        int n = 100000;

        long start, end;

        start = System.nanoTime();
        for (int i = 0; i < n; i++) hashSet.add(i);
        end = System.nanoTime();
        System.out.println("HashSet Add: " + (end - start));

        start = System.nanoTime();
        for (int i = 0; i < n; i++) linkedHashSet.add(i);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Add: " + (end - start));

        start = System.nanoTime();
        for (int i = 0; i < n; i++) treeSet.add(i);
        end = System.nanoTime();
        System.out.println("TreeSet Add: " + (end - start));

        start = System.nanoTime();
        hashSet.contains(n - 1);
        end = System.nanoTime();
        System.out.println("HashSet Search: " + (end - start));

        start = System.nanoTime();
        linkedHashSet.contains(n - 1);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search: " + (end - start));

        start = System.nanoTime();
        treeSet.contains(n - 1);
        end = System.nanoTime();
        System.out.println("TreeSet Search: " + (end - start));

        start = System.nanoTime();
        hashSet.remove(n - 1);
        end = System.nanoTime();
        System.out.println("HashSet Remove: " + (end - start));

        start = System.nanoTime();
        linkedHashSet.remove(n - 1);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Remove: " + (end - start));

        start = System.nanoTime();
        treeSet.remove(n - 1);
        end = System.nanoTime();
        System.out.println("TreeSet Remove: " + (end - start));
    }
}