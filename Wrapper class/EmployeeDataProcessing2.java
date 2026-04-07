import java.util.ArrayList;
import java.util.Collections;

public class EmployeeDataProcessing2 {
    public static void main(String[] args) {

        int[] ages = {22, 35, 19, 41, 28, 30};

        ArrayList<Integer> ageList = new ArrayList<>();

        for (int age : ages) {
            ageList.add(age);
        }

        int youngest = Collections.min(ageList);
        int oldest = Collections.max(ageList);

        System.out.println("Ages: " + ageList);
        System.out.println("Youngest: " + youngest);
        System.out.println("Oldest: " + oldest);
    }
}