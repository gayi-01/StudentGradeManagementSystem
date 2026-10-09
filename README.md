# Student Grade Management System

A beginner-friendly Java console application developed to manage and analyze student grades using Core Java.

---

## 📌 Project Features
- **Add Student Records**: Input student name and marks with interactive prompts.
- **Dynamic Data Storage**: Uses Java's `ArrayList<Student>` to store records dynamically in memory.
- **Data Validation**:
  - Restricts marks strictly between `0` and `100`.
  - Handles invalid numerical input (preventing runtime crashes).
  - Validates non-empty student names.
- **Automatic Grade Calculation**:
  - `90 - 100` : **A**
  - `80 - 89`  : **B**
  - `70 - 79`  : **C**
  - `60 - 69`  : **D**
  - `Below 60` : **F**
- **Formatted Tabular Report**: Neatly aligns student names, marks, and grades using `System.out.printf`.
- **Statistical Analysis**:
  - Computes class average marks.
  - Identifies highest mark and student name(s).
  - Identifies lowest mark and student name(s).

---

## 📂 Project Structure
```
internship task-02/
│
├── Student.java                     # Model class representing student data & grade logic
├── StudentGradeManagementSystem.java# Main class containing menu, ArrayList & statistics
└── README.md                        # Documentation and run instructions
```

---

## 🚀 How to Run the Project

1. Open your terminal / command prompt in the project root directory (`internship task-02`).
2. Compile all Java files:
   ```bash
   javac *.java
   ```
3. Run the application:
   ```bash
   java StudentGradeManagementSystem
   ```

---

## 💻 Sample Menu
```
----------------- MAIN MENU -----------------
1. Add Student
2. Display Students
3. Display Statistics
4. Exit
---------------------------------------------
```
