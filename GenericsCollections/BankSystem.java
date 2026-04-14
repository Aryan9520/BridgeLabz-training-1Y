import java.util.*;

public class BankSystem {

    public static void main(String[] args) {

        Map<String, Double> accounts = new HashMap<>();

        accounts.put("ACC101", 50000.0);
        accounts.put("ACC102", 75000.0);
        accounts.put("ACC103", 30000.0);
        accounts.put("ACC104", 90000.0);
        accounts.put("ACC105", 65000.0);

        deposit(accounts, "ACC101", 10000);
        withdraw(accounts, "ACC103", 5000);
        withdraw(accounts, "ACC103", 50000);

        List<Map.Entry<String, Double>> list = new ArrayList<>(accounts.entrySet());
        list.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        System.out.println("\nCustomers Sorted by Balance:");
        for (Map.Entry<String, Double> entry : list) {
            System.out.println(entry.getKey() + " : ₹" + entry.getValue());
        }

        System.out.println("\nTop 3 Customers:");
        for (int i = 0; i < Math.min(3, list.size()); i++) {
            System.out.println(list.get(i).getKey() + " : ₹" + list.get(i).getValue());
        }
    }

    public static void deposit(Map<String, Double> accounts, String acc, double amount) {
        if (accounts.containsKey(acc)) {
            accounts.put(acc, accounts.get(acc) + amount);
            System.out.println("Deposited ₹" + amount + " to " + acc);
        }
    }

    public static void withdraw(Map<String, Double> accounts, String acc, double amount) {
        if (accounts.containsKey(acc)) {
            double balance = accounts.get(acc);
            if (balance >= amount) {
                accounts.put(acc, balance - amount);
                System.out.println("Withdrawn ₹" + amount + " from " + acc);
            } else {
                System.out.println("Insufficient balance in " + acc);
            }
        }
    }
}