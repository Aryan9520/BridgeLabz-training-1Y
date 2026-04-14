import java.util.*;

abstract class JobRole {
    String role;

    JobRole(String role) {
        this.role = role;
    }

    public String toString() {
        return role;
    }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    ProductManager() {
        super("Product Manager");
    }
}

class Resume<T extends JobRole> {
    String candidateName;
    T role;

    Resume(String candidateName, T role) {
        this.candidateName = candidateName;
        this.role = role;
    }

    public T getRole() {
        return role;
    }

    public String toString() {
        return candidateName + " applied for " + role;
    }
}

public class Main {

    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println("Processing: " + resume);
    }

    public static void screeningPipeline(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Screening for role: " + role);
        }
    }

    public static void main(String[] args) {

        Resume<SoftwareEngineer> r1 = new Resume<>("Aryan", new SoftwareEngineer());
        Resume<DataScientist> r2 = new Resume<>("Rahul", new DataScientist());
        Resume<ProductManager> r3 = new Resume<>("Sneha", new ProductManager());

        processResume(r1);
        processResume(r2);
        processResume(r3);

        List<JobRole> roles = new ArrayList<>();
        roles.add(new SoftwareEngineer());
        roles.add(new DataScientist());
        roles.add(new ProductManager());

        screeningPipeline(roles);
    }
}