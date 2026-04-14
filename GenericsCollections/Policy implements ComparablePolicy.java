import java.util.*;

class Policy implements ComparablePolicy {
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

    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy p) {
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
    }

    public void displayHashSet() {
        System.out.println("HashSet:");
        for (Policy p : hashSet) System.out.println(p);
    }

    public void displayLinkedHashSet() {
        System.out.println("\nLinkedHashSet:");
        for (Policy p : linkedHashSet) System.out.println(p);
    }

    public void displayTreeSet() {
        System.out.println("\nTreeSet (Sorted by Expiry Date):");
        for (Policy p : treeSet) System.out.println(p);
    }

    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy(101, "Aryan", new Date(126, 5, 10), "Health", 5000));
        manager.addPolicy(new Policy(102, "Rahul", new Date(125, 8, 15), "Auto", 3000));
        manager.addPolicy(new Policy(103, "Sneha", new Date(127, 2, 20), "Home", 7000));

        manager.displayHashSet();
        manager.displayLinkedHashSet();
        manager.displayTreeSet();
    }
}