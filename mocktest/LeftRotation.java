import java.util.*;

public class LeftRotation {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70};
        int k = 3; 

        int n = arr.length;
        d = d % n;

        int[] result = new int[n];

        for (int k = 0; k < n; k++) {
            result[k] = arr[(k + d) % n];
        }

        System.out.println("Left Rotated Array:");
        System.out.println(Arrays.toString(result));
    }
} 
