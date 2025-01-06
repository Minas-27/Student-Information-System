package com.studentinfo;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    // Create a student
    public void addStudent(Student student) {
        try {
            students.add(student);
            System.out.println("Student added successfully!");
        } catch (Exception e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }

    // Read all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Update a student
    public void updateStudent(int id, String name, String email) {
        try {
            for (Student student : students) {
                if (student.getId() == id) {
                    student.setName(name);
                    student.setEmail(email);
                    System.out.println("Student updated successfully!");
                    return;
                }
            }
            System.out.println("Student not found!");
        } catch (Exception e) {
            System.err.println("Error updating student: " + e.getMessage());
        }
    }

    // Delete a student
    public void deleteStudent(int id) {
        try {
            if (students.removeIf(student -> student.getId() == id)) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found!");
            }
        } catch (Exception e) {
            System.err.println("Error deleting student: " + e.getMessage());
        }
    }
}
