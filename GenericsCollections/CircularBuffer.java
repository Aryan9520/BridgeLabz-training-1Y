import java.util.*;

class CircularBuffer {
    private int[] buffer;
    private int size;
    private int front = 0;
    private int count = 0;

    CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }

    public void insert(int value) {
        int rear = (front + count) % size;

        if (count == size) {
            front = (front + 1) % size;
            rear = (front + count - 1 + size) % size;
        } else {
            count++;
        }

        buffer[rear] = value;
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        CircularBuffer cb = new CircularBuffer(3);

        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display();

        cb.insert(4);
        cb.display();
    }
}