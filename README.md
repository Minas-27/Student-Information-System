# Student Information System

## Overview
The Student Information System is a simple, console-based Java application that helps manage student records. It allows users to perform basic CRUD (Create, Read, Update, Delete) operations on student data, including saving and retrieving data from a file for persistence.

## Features
- Add new students with ID, name, and email validation.
- View all students in a well-formatted table.
- Update existing student information.
- Delete student records.
- Save student data to a file for future use.
- Load student data from a file at startup.

## File Structure
```
src/com/studentinfo
├── Main.java           # Entry point of the application
├── Student.java        # Represents the student entity
├── StudentService.java # Handles student CRUD operations
├── FileHandler.java    # Manages file I/O operations
```

## Prerequisites
- Java Development Kit (JDK) 8 or higher
- A code editor or IDE like IntelliJ IDEA, Eclipse, or VS Code

## How to Run
1. Clone this repository or download the source files.
2. Navigate to the project directory in your terminal.
3. Compile the project:
   ```bash
   javac -d bin src/com/studentinfo/*.java
   ```
4. Run the application:
   ```bash
   java -cp bin com.studentinfo.Main
   ```

## How It Works

### Main Menu
The application starts with a menu offering the following options:
```
--- Student Information System ---
1. Add Student
2. View Students
3. Update Student
4. Delete Student
5. Save & Exit
```

### Adding Students
The user is prompted to enter:
- ID: A positive integer.
- Name: A non-empty string.
- Email: A valid email address (e.g., `user@example.com`).

Validation ensures that only correct inputs are accepted.

### Viewing Students
Displays the list of students in a tabular format:
```
==============================================
ID         Name                 Email
==============================================
1        Abraham Addisu    abraham21@gmail.com
2        Minas             minas27@gmail.com
==============================================
```

### Updating Students
The user enters the ID of the student to update, followed by the new name and email.

### Deleting Students
The user enters the ID of the student to delete. If the ID exists, the record is removed; otherwise, an error message is displayed.

### Saving and Loading Data
- Save: Data is saved to `data/students.csv`.
- Load: Data is automatically loaded from the file at startup.

## Classes

### 1. `Student`
Represents a student entity with:
- `id`: Integer (must be positive)
- `name`: String (non-empty)
- `email`: String (valid email format)

**Methods:**
- Getters and setters for each field
- `toString()` method for a readable representation

### 2. `StudentService`
Handles student-related operations:
- `addStudent(Student student)`
- `getAllStudents()`: Returns a list of all students
- `updateStudent(int id, String name, String email)`
- `deleteStudent(int id)`

### 3. `FileHandler`
Manages file input and output:
- `saveToFile(List<Student> students)`
- `loadFromFile()`: Returns a list of students

### 4. `Main`
The entry point of the application, handling user interactions and menu navigation.

## Example Usage
Adding a Student:
```
Enter ID (numeric only): 1
Enter Name: Abraham Addisu
Enter Email: abraham21@gmail.com
Student added successfully!
```

Viewing Students:
```
==============================================
ID         Name                Email
==============================================
1          Abraham Addisu      abraham21@gmail.com
==============================================
```

Updating a Student:
```
Enter ID of student to update: 1
Enter New Name: Abuka Addisu
Enter New Email: abuka@gmail.com
Student updated successfully!
```

Deleting a Student:
```
Enter ID of student to delete: 1
Student deleted successfully!
```

## Improvements
- Enhanced validation for user inputs.
- Better error handling for file operations.
- Clean and tabular display of student data.

## Future Enhancements
- Add GUI for better user experience.
- Implement search functionality.
- Add support for exporting data to multiple file formats (e.g., JSON, Excel).

## Author
**Abraham Addisu**

Feel free to contribute or suggest improvements!

