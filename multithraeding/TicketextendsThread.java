import java.util.*;

class TicketextendsThread {

    private int ticketId;
    private String type;
    private int priority;
    private int queuePosition;

    // Shared tracking
    static long totalProcessingTime = 0;

    // Stats per priority
    static Map<Integer, List<Long>> stats = new HashMap<>();

    public Ticket(int ticketId, String type, int priority, int queuePosition) {
        this.ticketId = ticketId;
        this.type = type;
        this.priority = priority;
        this.queuePosition = queuePosition;

        this.setPriority(priority);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        String agent = Thread.currentThread().getName();

        System.out.println("🎫 Ticket " + ticketId +
                " | Type: " + type +
                " | Priority: " + priority +
                " | Agent: " + agent +
                " | Queue Position: " + queuePosition +
                " → STARTED");

        try {
            int processTime = new Random().nextInt(5) + 1; // 1–5 sec
            Thread.sleep(processTime * 1000);

        } catch (InterruptedException e) {
            System.out.println(e);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        // Update stats
        synchronized (Ticket.class) {
            totalProcessingTime += duration;

            stats.putIfAbsent(priority, new ArrayList<>());
            stats.get(priority).add(duration);
        }

        System.out.println("✅ Ticket " + ticketId +
                " COMPLETED by " + agent +
                " | Time: " + duration / 1000.0 + " sec");
    }
}

public class TicketSystem {
    public static void main(String[] args) {

        List<Ticket> tickets = new ArrayList<>();

        // Create 10 mixed tickets
        tickets.add(new Ticket(1, "Critical Bug", 10, 1));
        tickets.add(new Ticket(2, "Feature Request", 4, 5));
        tickets.add(new Ticket(3, "General Query", 2, 7));
        tickets.add(new Ticket(4, "Feedback", 1, 10));
        tickets.add(new Ticket(5, "Critical Bug", 10, 2));
        tickets.add(new Ticket(6, "Feature Request", 4, 6));
        tickets.add(new Ticket(7, "General Query", 2, 8));
        tickets.add(new Ticket(8, "Feedback", 1, 9));
        tickets.add(new Ticket(9, "Critical Bug", 10, 3));
        tickets.add(new Ticket(10, "Feature Request", 4, 4));

        // Assign agent names
        int agentCount = 1;
        for (Ticket t : tickets) {
            t.setName("Agent-" + agentCount++);
        }

        // Sort by priority (High → Low)
        tickets.sort((a, b) -> b.getPriority() - a.getPriority());

        System.out.println("🚀 Processing Tickets...\n");

        // Start all tickets
        for (Ticket t : tickets) {
            t.start();
        }

        // Wait for completion
        for (Ticket t : tickets) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        // Display statistics
        System.out.println("\n📊 STATISTICS");

        System.out.println("Total Processing Time: " +
                Ticket.totalProcessingTime / 1000.0 + " sec");

        for (int p : Ticket.stats.keySet()) {
            List<Long> times = Ticket.stats.get(p);

            long sum = 0;
            for (long t : times) sum += t;

            double avg = (sum / (double) times.size()) / 1000.0;

            System.out.println("Priority " + p +
                    " → Avg Time: " + avg + " sec");
        }

        System.out.println("\n🎉 All Tickets Processed!");
    }
}