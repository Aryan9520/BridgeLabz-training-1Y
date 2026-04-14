import java.util.*;

class Student implements ComparableStudent {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        return this.id == s.id;
    }

    public int compareTo(Student other) {
        return Double.compare(other.marks, this.marks);
    }

    public String toString() {
        return id + " | " + name + " | Marks: " + marks;
    }
}

public class AdmissionSystem {

    List<Student> applicants = new ArrayList<>();
    Set<Student> shortlisted = new HashSet<>();
    Queue<Student> interviewQueue = new LinkedList<>();
    TreeSet<Student> meritList = new TreeSet<>();

    public void apply(Student s) {
        applicants.add(s);
    }

    public void shortlist(double cutoff) {
        System.out.println("Shortlisted Students:");
        for (Student s : applicants) {
            if (s.marks >= cutoff) {
                shortlisted.add(s);
                System.out.println(s);
            }
        }
    }

    public void prepareInterviews() {
        interviewQueue.addAll(shortlisted);
    }

    public void conductInterviews() {
        System.out.println("\nInterview Process:");

        while (!interviewQueue.isEmpty()) {
            Student s = interviewQueue.remove();

            if (s.marks >= 75) {
                meritList.add(s);
                System.out.println("Selected: " + s);
            } else {
                System.out.println("Rejected: " + s);
            }
        }
    }

    public void displayMeritList() {
        System.out.println("\nFinal Merit List:");
        for (Student s : meritList) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {

        AdmissionSystem system = new AdmissionSystem();

        system.apply(new Student(1, "Aryan", 85));
        system.apply(new Student(2, "Rahul", 70));
        system.apply(new Student(3, "Sneha", 90));
        system.apply(new Student(1, "Duplicate", 85));

        system.shortlist(70);
        system.prepareInterviews();
        system.conductInterviews();
        system.displayMeritList();
    }
}