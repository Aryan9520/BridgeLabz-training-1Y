import java.util.*;

class Team implements ComparableTeam{
    int id;
    String name;
    int points;

    Team(int id, String name) {
        this.id = id;
        this.name = name;
        this.points = 0;
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Team)) return false;
        Team t = (Team) obj;
        return this.id == t.id;
    }

    public int compareTo(Team other) {
        return other.points - this.points;
    }

    public String toString() {
        return name + " | Points: " + points;
    }
}

class Match {
    Team t1, t2;

    Match(Team t1, Team t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public String toString() {
        return t1.name + " vs " + t2.name;
    }
}

class Result {
    Team winner;
    Team loser;

    Result(Team winner, Team loser) {
        this.winner = winner;
        this.loser = loser;
    }

    public String toString() {
        return winner.name + " defeated " + loser.name;
    }
}

public class TournamentScheduler {

    Set<Team> teams = new HashSet<>();
    Queue<Match> matchQueue = new LinkedList<>();
    List<Result> results = new ArrayList<>();
    TreeSet<Team> leaderboard = new TreeSet<>();

    public void registerTeam(Team t) {
        if (teams.add(t)) {
            System.out.println("Registered: " + t.name);
        } else {
            System.out.println("Duplicate Team: " + t.name);
        }
    }

    public void scheduleMatch(Match m) {
        matchQueue.add(m);
    }

    public void processMatches() {
        System.out.println("\nProcessing Matches:");

        while (!matchQueue.isEmpty()) {
            Match m = matchQueue.remove();

            Team winner = m.t1;
            Team loser = m.t2;

            winner.points += 2;

            results.add(new Result(winner, loser));

            System.out.println(winner.name + " won against " + loser.name);
        }
    }

    public void updateLeaderboard() {
        leaderboard.clear();
        leaderboard.addAll(teams);
    }

    public void displayLeaderboard() {
        System.out.println("\nLeaderboard:");
        for (Team t : leaderboard) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {

        TournamentScheduler system = new TournamentScheduler();

        Team t1 = new Team(1, "Team A");
        Team t2 = new Team(2, "Team B");
        Team t3 = new Team(3, "Team C");

        system.registerTeam(t1);
        system.registerTeam(t2);
        system.registerTeam(t3);
        system.registerTeam(t1);

        system.scheduleMatch(new Match(t1, t2));
        system.scheduleMatch(new Match(t2, t3));

        system.processMatches();

        system.updateLeaderboard();
        system.displayLeaderboard();
    }
}