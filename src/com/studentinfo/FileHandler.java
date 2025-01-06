package com.studentinfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_PATH = "data/students.csv";

    // Save students to file
    public void saveToFile(List<Student> students) {
        File file = new File(FILE_PATH);
        File parentDir = file.getParentFile(); // Get the parent directory

        // Create the directory if it doesn't exist
        if (parentDir != null && !parentDir.exists()) {
            if (parentDir.mkdirs()) {
                System.out.println("Directory created: " + parentDir.getAbsolutePath());
            } else {
                System.err.println("Failed to create directory: " + parentDir.getAbsolutePath());
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Student student : students) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getEmail());
                writer.newLine();
            }
            System.out.println("Data saved to file successfully!");
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }


    // Load students from file
    public List<Student> loadFromFile() {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("No data file found. Starting fresh.");
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String email = parts[2];
                    students.add(new Student(id, name, email));
                } catch (Exception e) {
                    System.err.println("Error parsing record: " + line);
                }
            }
            System.out.println("Data loaded from file successfully!");
        } catch (IOException e) {
            System.err.println("Error loading data from file: " + e.getMessage());
        }

        return students;
    }
}
