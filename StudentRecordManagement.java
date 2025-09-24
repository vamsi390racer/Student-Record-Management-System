import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a student with an ID, name, and marks.
 */
class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

/**
 * Manages the student records using a CLI.
 */
public class StudentRecordManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("\n--- Student Record Management System ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Update Student Record");
        System.out.println("4. Delete Student Record");
        System.out.println("5. Exit");
        System.out.println("----------------------------------------");
    }

    /**
     * Adds a new student record to the list.
     */
    private static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();

        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    /**
     * Displays all student records in the list.
     */
    private static void viewStudents() {
        System.out.println("\n--- All Student Records ---");
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    /**
     * Updates an existing student's name and marks based on their ID.
     */
    private static void updateStudent() {
        System.out.println("\n--- Update Student Record ---");
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Student student : studentList) {
            if (student.getId() == id) {
                System.out.print("Enter new name: ");
                student.setName(scanner.nextLine());
                System.out.print("Enter new marks: ");
                student.setMarks(scanner.nextDouble());
                scanner.nextLine();
                System.out.println("Student record updated successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    /**
     * Deletes a student record based on their ID.
     */
    private static void deleteStudent() {
        System.out.println("\n--- Delete Student Record ---");
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removed = studentList.removeIf(student -> student.getId() == id);
        if (removed) {
            System.out.println("Student record deleted successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}