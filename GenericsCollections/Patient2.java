import java.util.*;

class Patient2 {
    int id;
    String name;

    Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Patient)) return false;
        Patient p = (Patient) obj;
        return this.id == p.id;
    }

    public String toString() {
        return id + " | " + name;
    }
}

public class HospitalSystem {

    Set<Patient> admittedPatients = new HashSet<>();
    Queue<Patient> treatmentQueue = new LinkedList<>();
    Stack<Patient> dischargedStack = new Stack<>();
    List<Patient> history = new ArrayList<>();

    public void admitPatient(Patient p) {
        if (admittedPatients.add(p)) {
            treatmentQueue.add(p);
            history.add(p);
            System.out.println("Admitted: " + p);
        } else {
            System.out.println("Duplicate Patient: " + p);
        }
    }

    public void treatPatients() {
        System.out.println("\nTreating Patients:");

        while (!treatmentQueue.isEmpty()) {
            Patient p = treatmentQueue.remove();
            System.out.println("Treated: " + p);
            dischargePatient(p);
        }
    }

    public void dischargePatient(Patient p) {
        admittedPatients.remove(p);
        dischargedStack.push(p);
        System.out.println("Discharged: " + p);
    }

    public void readmitLastPatient() {
        if (!dischargedStack.isEmpty()) {
            Patient p = dischargedStack.pop();
            admitPatient(p);
            System.out.println("Re-admitted: " + p);
        }
    }

    public void showHistory() {
        System.out.println("\nPatient History:");
        for (Patient p : history) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {

        HospitalSystem system = new HospitalSystem();

        system.admitPatient(new Patient(1, "Aryan"));
        system.admitPatient(new Patient(2, "Rahul"));
        system.admitPatient(new Patient(1, "Duplicate"));

        system.treatPatients();

        system.readmitLastPatient();

        system.showHistory();
    }
}