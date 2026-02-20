import java.util.Random;

public class StudentScorecard {

    public static int[][] generateScores(int students) {
        Random rand = new Random();
        int[][] scores = new int[students][3];

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 10 + rand.nextInt(90);
            }
        }
        return scores;
    }

    public static double[][] calculateResult(int[][] scores) {
        int n = scores.length;
        double[][] result = new double[n][3];

        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }
        return result;
    }

    public static char calculateGrade(double percentage) {
        if (percentage >= 70)
            return 'A';
        else if (percentage >= 60)
            return 'B';
        else if (percentage >= 50)
            return 'C';
        else if (percentage >= 40)
            return 'D';
        else
            return 'E';
    }

    public static void displayScorecard(int[][] scores, double[][] result) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAvg\t%\tGrade");
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            char grade = calculateGrade(result[i][2]);

            System.out.println((i + 1) + "\t" +
                    scores[i][0] + "\t" +
                    scores[i][1] + "\t\t" +
                    scores[i][2] + "\t" +
                    (int) result[i][0] + "\t" +
                    result[i][1] + "\t" +
                    result[i][2] + "\t" +