package com.studentinfo;

public class Student {
    private int id;
    private String name;
    private String email;

    public Student(int id, String name, String email) {
        if (id <= 0) throw new IllegalArgumentException("ID must be a positive number.");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty.");
        if (!email.contains("@")) throw new IllegalArgumentException("Invalid email format.");

        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID must be a positive number.");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty.");
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.contains("@")) throw new IllegalArgumentException("Invalid email format.");
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
