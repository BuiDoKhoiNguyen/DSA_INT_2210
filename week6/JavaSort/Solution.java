package week6.JavaSort;

import java.io.*;
import java.util.*;

class Student{
    private int id;
    private String firstName;
    double cgpa;
    
    public Student(int id, String firstName, double cgpa) {
        this.id = id;
        this.firstName = firstName;
        this.cgpa = cgpa;
    }
    
    public int getId() {
        return id;
    }

    public String getFname() {
        return firstName;
    }

    public double getCgpa() {
        return cgpa;
    }
}


class StudentComparator implements Comparator<Student> {
    public int compare(Student a, Student b) {
        if (a.getCgpa() != b.getCgpa()) {
            return Double.compare(b.getCgpa(), a.getCgpa());
        }
        
        if (!a.getFname().equals(b.getFname())) {
            return a.getFname().compareTo(b.getFname());
        }
        
        return a.getId() - b.getId();
    }
}
    
public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        List<Student> studentList = new ArrayList<>();
        
        while(n-- > 0){
            int age = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();
            Student student = new Student(age, name, cgpa);
            studentList.add(student);  
        }
  
        Collections.sort(studentList, new StudentComparator());
      
          for(Student st: studentList){
            System.out.println(st.getFname());
        }
         
    }
}
