package com.studentinfo;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        FileHandler fileHandler = new FileHandler();
        Scanner scanner = new Scanner(System.in);

        try {
            // Load data from file
            studentService.getAllStudents().addAll(fileHandler.loadFromFile());
        } catch (Exception e) {
            System.err.println("Error loading data: " + e.getMessage());
        }

        while (true) {
            try {
                System.out.println("\n--- Student Information System ---");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Save & Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        // Variable to store valid inputs
                        int id;
                        String name;
                        String email;

                        // Validate ID
                        while (true) {
                            System.out.print("Enter ID (numeric only): ");
                            if (scanner.hasNextInt()) {
                                id = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                if (id > 0) {
                                    break; // Valid ID entered
                                } else {
                                    System.out.println("ID must be a positive number. Please try again.");
                                }
                            } else {
                                System.out.println("Invalid input. ID must be a number. Please try again.");
                                scanner.nextLine(); // Clear invalid input
                            }
                        }

                        // Validate Name
                        while (true) {
                            System.out.print("Enter Name: ");
                            name = scanner.nextLine().trim();
                            if (!name.isEmpty()) {
                                break; // Valid name entered
                            } else {
                                System.out.println("Name cannot be empty. Please enter a valid name.");
                            }
                        }

                        // Validate Email
                        while (true) {
                            System.out.print("Enter Email: ");
                            email = scanner.nextLine().trim();
                            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
                                break; // Valid email entered
                            } else {
                                System.out.println("Invalid email format. Please enter a valid email (e.g., user@example.com).");
                            }
                        }

                        // Add student to the list
                        studentService.addStudent(new Student(id, name, email));

                    }


                    case 2 -> {
                        List<Student> students = studentService.getAllStudents();
                        if (students.isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            System.out.println("==============================================");
                            System.out.printf("%-10s %-20s %-30s%n", "ID", "Name", "Email");
                            System.out.println("==============================================");

                            for (Student student : students) {
                                System.out.printf("%-10d %-20s %-30s%n", student.getId(), student.getName(), student.getEmail());
                            }

                            System.out.println("==============================================");
                        }
                    }

                    case 3 -> {
                        try {
                            System.out.print("Enter ID of student to update: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Enter New Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter New Email: ");
                            String email = scanner.nextLine();
                            studentService.updateStudent(id, name, email);
                        } catch (Exception e) {
                            System.err.println("Error updating student: " + e.getMessage());
                        }
                    }
                    case 4 -> {
                        try {
                            System.out.print("Enter ID of student to delete: ");
                            int id = scanner.nextInt();
                            studentService.deleteStudent(id);
                        } catch (Exception e) {
                            System.err.println("Error deleting student: " + e.getMessage());
                        }
                    }
                    case 5 -> {
                        fileHandler.saveToFile(studentService.getAllStudents());
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }
}
