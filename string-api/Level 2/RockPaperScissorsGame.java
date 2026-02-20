import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String getComputerChoice() {
        int random = (int) (Math.random() * 3);
        if (random == 0) {
            return "rock";
        } else if (random == 1) {
            return "paper";
        } else {
            return "scissors";
        }
    }

    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "Draw";
        } else if ((user.equals("rock") && computer.equals("scissors")) ||
                   (user.equals("paper") && computer.equals("rock")) ||
                   (user.equals("scissors") && computer.equals("paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }

    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][3];

        double userPercentage = ((double) userWins / totalGames) * 100;
        double computerPercentage = ((double) computerWins / totalGames) * 100;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userPercentage) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", computerPercentage) + "%";

        return stats;
    }

    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.println("\nGame\tUser\tComputer\tWinner");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.println((i + 1) + "\t" + gameResults[i][0] + "\t" + gameResults[i][1] + "\t\t" + gameResults[i][2]);
        }

        System.out.println("\nStatistics:");
        System.out.println("Player\tWins\tWinning Percentage");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[][] gameResults = new String[n][3];
        int userWins = 0;
        int computerWins = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String userChoice = sc.nextLine().toLowerCase();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;

            if (winner.equals("User")) {
                userWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }
        }

        String[][] stats = calculateStats(userWins, computerWins, n);
        displayResults(gameResults, stats);

        sc.close();
    }
}
