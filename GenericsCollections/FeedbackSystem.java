import java.util.*;

public class FeedbackSystem {

    List<String> allFeedback = new ArrayList<>();
    Set<String> uniqueFeedback = new HashSet<>();
    Queue<String> processingQueue = new LinkedList<>();
    Stack<String> recentFeedback = new Stack<>();

    public void addFeedback(String feedback) {
        allFeedback.add(feedback);
        System.out.println("Added: " + feedback);
    }

    public void processFeedback() {
        System.out.println("\nProcessing Feedback:");

        for (String fb : allFeedback) {
            if (uniqueFeedback.add(fb)) {
                processingQueue.add(fb);
            }
        }

        while (!processingQueue.isEmpty()) {
            String fb = processingQueue.remove();
            System.out.println("Processed: " + fb);
            recentFeedback.push(fb);
        }
    }

    public void showRecentFeedback(int count) {
        System.out.println("\nRecent Feedback:");

        int size = recentFeedback.size();
        for (int i = size - 1; i >= Math.max(size - count, 0); i--) {
            System.out.println(recentFeedback.get(i));
        }
    }

    public static void main(String[] args) {

        FeedbackSystem system = new FeedbackSystem();

        system.addFeedback("Good service");
        system.addFeedback("Fast delivery");
        system.addFeedback("Good service");
        system.addFeedback("Nice app");

        system.processFeedback();

        system.showRecentFeedback(2);
    }
}