import java.util.*;

class Player {
    int id;
    String name;

    Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Player)) return false;
        Player p = (Player) obj;
        return this.id == p.id;
    }

    public String toString() {
        return name;
    }
}

class Match {
    Player p1, p2;

    Match(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String toString() {
        return p1 + " vs " + p2;
    }
}

class Result {
    Player winner;
    Player loser;

    Result(Player winner, Player loser) {
        this.winner = winner;
        this.loser = loser;
    }

    public String toString() {
        return winner + " defeated " + loser;
    }
}

class Score implements Comparable<Score> {
    Player player;
    int points;

    Score(Player player, int points) {
        this.player = player;
        this.points = points;
    }

    public int compareTo(Score other) {
        return other.points - this.points;
    }

    public String toString() {
        return player + " : " + points;
    }
}

public class TournamentSystem {

    Set<Player> players = new HashSet<>();
    Queue<Match> matchQueue = new LinkedList<>();
    List<Result> results = new ArrayList<>();
    TreeSet<Score> leaderboard = new TreeSet<>();

    Map<Player, Integer> scoreMap = new HashMap<>();

    public void registerPlayer(Player p) {
        if (players.add(p)) {
            scoreMap.put(p, 0);
            System.out.println("Registered: " + p);
        } else {
            System.out.println("Duplicate Player: " + p);
        }
    }

    public void scheduleMatch(Match m) {
        matchQueue.add(m);
    }

    public void processMatches() {
        System.out.println("\nProcessing Matches:");

        while (!matchQueue.isEmpty()) {
            Match m = matchQueue.remove();

            Player winner = m.p1;
            Player loser = m.p2;

            results.add(new Result(winner, loser));

            scoreMap.put(winner, scoreMap.get(winner) + 10);

            System.out.println(winner + " won against " + loser);
        }
    }

    public void updateLeaderboard() {
        leaderboard.clear();
        for (Map.Entry<Player, Integer> entry : scoreMap.entrySet()) {
            leaderboard.add(new Score(entry.getKey(), entry.getValue()));
        }
    }

    public void displayLeaderboard() {
        System.out.println("\nLeaderboard:");
        for (Score s : leaderboard) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

        TournamentSystem system = new TournamentSystem();

        Player p1 = new Player(1, "Aryan");
        Player p2 = new Player(2, "Rahul");
        Player p3 = new Player(3, "Sneha");

        system.registerPlayer(p1);
        system.registerPlayer(p2);
        system.registerPlayer(p3);
        system.registerPlayer(p1);

        system.scheduleMatch(new Match(p1, p2));
        system.scheduleMatch(new Match(p2, p3));

        system.processMatches();

        system.updateLeaderboard();
        system.displayLeaderboard();
    }
}