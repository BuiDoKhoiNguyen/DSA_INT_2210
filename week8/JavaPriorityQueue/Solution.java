import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
/**
 * Create the Student and Priorities classes here.
 */
    
class Student {
    private int ID;
    private String name;
    private double CGPA;

    public Student(int ID, String name, double CGPA) {
        this.ID = ID;
        this.name = name;
        this.CGPA = CGPA;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<Student>(Comparator.comparing(Student::getCGPA).reversed().thenComparing(Student::getName).thenComparing(Student::getID));
        List<Student> students = new ArrayList<Student>();
        for (String event : events) {
            Scanner scanner = new Scanner(event);
            String e = scanner.next();
            if (e.equals("ENTER")) {
                String name = scanner.next();
                double CGPA = scanner.nextDouble();
                int ID = scanner.nextInt();
                Student student = new Student(ID, name, CGPA);
                priorityQueue.add(student);
            }
            else if (e.equals("SERVED")) priorityQueue.poll();
        }
        while (priorityQueue.size() > 0) students.add(priorityQueue.poll());
        return students;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}