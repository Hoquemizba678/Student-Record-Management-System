import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

// Student class to represent individual student records
class Student {
    private int rollNo;
    private String name;
    private double marks;

    public Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public double getMarks() { return marks; }

    public void setName(String name) { this.name = name; }
    public void setMarks(double marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks;
    }
}

// CRUD system logic
class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(int rollNo, String name, double marks) {
        students.add(new Student(rollNo, name, marks));
        System.out.println("Student added successfully.");
    }

    public void displayStudents() {
        if (students.size() == 0) {
            System.out.println("No students found!");
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void updateStudent(int rollNo, String newName, double newMarks) {
        for (Student student : students) {
            if (student.getRollNo() == rollNo) {
                student.setName(newName);
                student.setMarks(newMarks);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public void deleteStudent(int rollNo) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getRollNo() == rollNo) {
                it.remove();
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}

// Main UI class
public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            int rollNo;
            String name;
            double marks;

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    rollNo = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter Marks: ");
                    marks = scanner.nextDouble();
                    sms.addStudent(rollNo, name, marks);
                    break;
                case 2:
                    sms.displayStudents();
                    break;
                case 3:
                    System.out.print("Enter Roll Number to Update: ");
                    rollNo = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter New Marks: ");
                    marks = scanner.nextDouble();
                    sms.updateStudent(rollNo, name, marks);
                    break;
                case 4:
                    System.out.print("Enter Roll Number to Delete: ");
                    rollNo = scanner.nextInt();
                    sms.deleteStudent(rollNo);
                    break;
            }
        } while (choice != 5);
        scanner.close();
    }
}
