public class BankTransaction {

    public static double getRemainingLimit(Double limit) {
        if (limit == null) {
            return 0.0;
        }
        return limit;
    }

    public static void main(String[] args) {
        System.out.println(getRemainingLimit(5000.0));
        System.out.println(getRemainingLimit(null));
    }
}