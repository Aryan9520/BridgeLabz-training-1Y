import java.util.*;

class Policy implements ComparablePolicy1 {
    int policyNumber;
    String policyHolderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

    Policy(int policyNumber, String name, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = name;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy p = (Policy) obj;
        return this.policyNumber == p.policyNumber;
    }

    public String toString() {
        return policyNumber + " | " + policyHolderName + " | " + expiryDate + " | " + coverageType + " | ₹" + premiumAmount;
    }
}

public class PolicyManager {

    Set<Policy> policies = new HashSet<>();

    public void addPolicy(Policy p) {
        policies.add(p);
    }

    public void displayAllPolicies() {
        System.out.println("All Unique Policies:");
        for (Policy p : policies) System.out.println(p);
    }

    public void policiesExpiringSoon() {
        System.out.println("\nPolicies Expiring Within 30 Days:");
        Date today = new Date();
        long millisIn30Days = 30L * 24 * 60 * 60 * 1000;

        for (Policy p : policies) {
            if (p.expiryDate.getTime() - today.getTime() <= millisIn30Days &&
                p.expiryDate.after(today)) {
                System.out.println(p);
            }
        }
    }

    public void filterByCoverage(String type) {
        System.out.println("\nPolicies with Coverage: " + type);
        for (Policy p : policies) {
            if (p.coverageType.equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    public void findDuplicates(List<Policy> list) {
        System.out.println("\nDuplicate Policies:");
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (Policy p : list) {
            if (!seen.add(p.policyNumber)) {
                duplicates.add(p.policyNumber);
            }
        }

        for (Policy p : list) {
            if (duplicates.contains(p.policyNumber)) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        Policy p1 = new Policy(101, "Aryan", new Date(126, 4, 20), "Health", 5000);
        Policy p2 = new Policy(102, "Rahul", new Date(126, 4, 10), "Auto", 3000);
        Policy p3 = new Policy(103, "Sneha", new Date(126, 6, 5), "Home", 7000);
        Policy p4 = new Policy(101, "Aryan", new Date(126, 4, 20), "Health", 5000);

        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);

        manager.displayAllPolicies();
        manager.policiesExpiringSoon();
        manager.filterByCoverage("Health");

        List<Policy> list = Arrays.asList(p1, p2, p3, p4);
        manager.findDuplicates(list);
    }
}