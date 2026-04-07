import java.util.ArrayList;

public class StudentMarksReport {

    public static void main(String[] args) {

        Object[] inputs = {"85", 95, Integer.valueOf(88), "null", "abc"};

        ArrayList<Integer> validMarks = new ArrayList<>();

        for (Object obj : inputs) {
            try {
                if (obj == null) continue;

                if (obj instanceof Integer) {
                    validMarks.add((Integer) obj);
                } else if (obj instanceof String) {
                    String str = (String) obj;

                    if (str.equalsIgnoreCase("null")) continue;

                    int value = Integer.parseInt(str);
                    validMarks.add(value);
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input ignored: " + obj);
            }
        }

        int sum = 0;
        for (Integer mark : validMarks) {
            sum += mark;
        }

        double avg = validMarks.isEmpty() ? 0.0 : (double) sum / validMarks.size();

        System.out.println("Valid Marks: " + validMarks);
        System.out.println("Average: " + avg);
    }
}