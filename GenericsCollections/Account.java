import java.util.*;

class Account {
    int accountId;
    String name;
    double balance;

    Account(int accountId, String name, double balance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

    public int hashCode() {
        return Objects.hash(accountId);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Account)) return false;
        Account a = (Account) obj;
        return this.accountId == a.accountId;
    }

    public String toString() {
        return accountId + " (" + name + ") Balance: ₹" + balance;
    }
}

class Transaction {
    int accountId;
    double amount;
    String type;

    Transaction(int accountId, double amount, String type) {
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
    }

    public String toString() {
        return type + " ₹" + amount + " for Account " + accountId;
    }
}

public class BankingSystem {

    List<Transaction> allTransactions = new ArrayList<>();
    Queue<Transaction> pendingQueue = new LinkedList<>();
    Set<Account> validAccounts = new HashSet<>();
    Stack<Transaction> history = new Stack<>();

    public void addAccount(Account acc) {
        validAccounts.add(acc);
    }

    public void addTransaction(Transaction t) {
        pendingQueue.add(t);
    }

    public Account findAccount(int id) {
        for (Account acc : validAccounts) {
            if (acc.accountId == id) return acc;
        }
        return null;
    }

    public void processTransactions() {
        System.out.println("Processing Transactions:");

        while (!pendingQueue.isEmpty()) {
            Transaction t = pendingQueue.remove();
            Account acc = findAccount(t.accountId);

            if (acc == null) {
                System.out.println("Invalid Account: " + t.accountId);
                continue;
            }

            if (t.type.equalsIgnoreCase("deposit")) {
                acc.balance += t.amount;
            } else if (t.type.equalsIgnoreCase("withdraw")) {
                if (acc.balance >= t.amount) {
                    acc.balance -= t.amount;
                } else {
                    System.out.println("Insufficient Balance for " + acc.accountId);
                    continue;
                }
            }

            allTransactions.add(t);
            history.push(t);

            System.out.println("Processed: " + t);
        }
    }

    public void rollback() {
        if (!history.isEmpty()) {
            Transaction t = history.pop();
            Account acc = findAccount(t.accountId);

            if (t.type.equalsIgnoreCase("deposit")) {
                acc.balance -= t.amount;
            } else if (t.type.equalsIgnoreCase("withdraw")) {
                acc.balance += t.amount;
            }

            System.out.println("Rolled Back: " + t);
        }
    }

    public static void main(String[] args) {

        BankingSystem bank = new BankingSystem();

        bank.addAccount(new Account(1, "Aryan", 10000));
        bank.addAccount(new Account(2, "Rahul", 5000));

        bank.addTransaction(new Transaction(1, 2000, "deposit"));
        bank.addTransaction(new Transaction(2, 1000, "withdraw"));
        bank.addTransaction(new Transaction(3, 500, "deposit"));

        bank.processTransactions();

        bank.rollback();
    }
}