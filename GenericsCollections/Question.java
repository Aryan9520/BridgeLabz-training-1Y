import java.util.*;

class Question {
    int id;
    String text;

    Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String toString() {
        return "Q" + id + ": " + text;
    }
}

class Student {
    String id;
    String name;

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return name + " (" + id + ")";
    }
}

public class ExamSystem {

    List<Question> questions = new ArrayList<>();
    Set<String> studentIds = new HashSet<>();
    Queue<Student> studentQueue = new LinkedList<>();
    Stack<Question> history = new Stack<>();

    public void enrollStudent(Student s) {
        if (studentIds.add(s.id)) {
            studentQueue.add(s);
            System.out.println("Enrolled: " + s);
        } else {
            System.out.println("Duplicate ID, not allowed: " + s.id);
        }
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void shuffleQuestions() {
        Collections.shuffle(questions);
    }

    public void serveStudents() {
        System.out.println("\nServing Students:");
        while (!studentQueue.isEmpty()) {
            System.out.println("Serving: " + studentQueue.remove());
        }
    }

    public void startExam() {
        System.out.println("\nExam Started:");
        for (Question q : questions) {
            System.out.println(q);
            history.push(q);
        }
    }

    public void goBack() {
        if (!history.isEmpty()) {
            history.pop();
            if (!history.isEmpty()) {
                System.out.println("Back to: " + history.peek());
            } else {
                System.out.println("No previous question");
            }
        }
    }

    public static void main(String[] args) {

        ExamSystem system = new ExamSystem();

        system.enrollStudent(new Student("S1", "Aryan"));
        system.enrollStudent(new Student("S2", "Rahul"));
        system.enrollStudent(new Student("S1", "Duplicate"));

        system.addQuestion(new Question(1, "What is Java?"));
        system.addQuestion(new Question(2, "Explain OOP."));
        system.addQuestion(new Question(3, "What is JVM?"));

        system.shuffleQuestions();

        system.serveStudents();

        system.startExam();
        system.goBack();
    }
}