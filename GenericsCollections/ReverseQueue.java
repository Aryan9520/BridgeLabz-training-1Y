import java.util.*;

public class ReverseQueue {

    public static <T> void reverseQueue(Queue<T> queue) {
        if (queue.isEmpty()) return;

        T front = queue.remove();
        reverseQueue(queue);
        queue.add(front);
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        reverseQueue(queue);

        System.out.println(queue);
    }
}