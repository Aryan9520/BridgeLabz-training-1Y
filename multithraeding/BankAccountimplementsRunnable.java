class BankAccountimplementsRunnable {

    private String accountHolder;
    private String accountType;

    public BankAccount(String accountHolder, String accountType) {
        this.accountHolder = accountHolder;
        this.accountType = accountType;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();

        for (int i = 1; i <= 3; i++) {
            System.out.println(
                "User: " + accountHolder +
                " | Type: " + accountType +
                " | Priority: " + currentThread.getPriority() +
                " | Checking balance (" + i + ")"
            );

            try {
                Thread.sleep(2000); // 2 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        // Create users
        BankAccount premiumUser = new BankAccount("Aryan", "Premium");
        BankAccount regularUser = new BankAccount("Rahul", "Regular");
        BankAccount basicUser = new BankAccount("Amit", "Basic");

        // Create threads
        Thread t1 = new Thread(premiumUser);
        Thread t2 = new Thread(regularUser);
        Thread t3 = new Thread(basicUser);

        // Set priorities
        t1.setPriority(10); // Premium
        t2.setPriority(5);  // Regular
        t3.setPriority(1);  // Basic

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}