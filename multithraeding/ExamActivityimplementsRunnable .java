class ExamActivityimplementsRunnable {

    private String activityName;
    private int startDelay; // in ms
    private int duration;   // in ms

    public ExamActivity(String activityName, int startDelay, int duration) {
        this.activityName = activityName;
        this.startDelay = startDelay;
        this.duration = duration;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();

        try {
            // Initial delay before starting activity
            Thread.sleep(startDelay);

            System.out.println(activityName + " STARTED | Thread: " + t.getName() +
                    " | State: " + t.getState());

            // Simulate activity duration
            Thread.sleep(duration);

            System.out.println(activityName + " COMPLETED | Thread: " + t.getName());

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class ExamHallSystem {
    public static void main(String[] args) {

        // Create threads for activities
        Thread entry = new Thread(
                new ExamActivity("Student Entry Monitoring", 0, 15000), "Entry-Thread");

        Thread question = new Thread(
                new ExamActivity("Question Paper Distribution", 5000, 3000), "Question-Thread");

        Thread attendance = new Thread(
                new ExamActivity("Attendance Marking", 10000, 4000), "Attendance-Thread");

        Thread collection = new Thread(
                new ExamActivity("Answer Sheet Collection", 20000, 3000), "Collection-Thread");

        // Set priorities
        question.setPriority(10);
        attendance.setPriority(8);
        collection.setPriority(7);
        entry.setPriority(5);

        // Show initial state
        System.out.println("Initial State:");
        System.out.println(entry.getName() + ": " + entry.getState());
        System.out.println(question.getName() + ": " + question.getState());
        System.out.println(attendance.getName() + ": " + attendance.getState());
        System.out.println(collection.getName() + ": " + collection.getState());

        // Start threads
        entry.start();
        question.start();
        attendance.start();
        collection.start();

        // Monitor states during execution
        try {
            Thread.sleep(2000);
            System.out.println("\nAfter Starting:");
            System.out.println(entry.getName() + ": " + entry.getState());
            System.out.println(question.getName() + ": " + question.getState());
            System.out.println(attendance.getName() + ": " + attendance.getState());
            System.out.println(collection.getName() + ": " + collection.getState());
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        // Wait for all threads to finish
        try {
            entry.join();
            question.join();
            attendance.join();
            collection.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("\n🎓 Exam Process Completed Successfully!");
    }
}