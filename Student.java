/**
 * Student.java
 * 
 * This class represents a single student in the system.
 * It encapsulates the student's name, marks, and calculated letter grade.
 */
public class Student {

    // Private fields to ensure encapsulation
    private String name;
    private double marks;
    private char grade;

    /**
     * Constructor to initialize a student with a name and marks.
     * The letter grade is calculated automatically based on the marks.
     *
     * @param name  The full name of the student
     * @param marks The marks obtained by the student (0 to 100)
     */
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    /**
     * Helper method to determine the letter grade based on the grading scale:
     * - 90 to 100 : A
     * - 80 to 89  : B
     * - 70 to 79  : C
     * - 60 to 69  : D
     * - Below 60  : F
     *
     * @param marks The student's numerical marks
     * @return Letter grade as a character ('A', 'B', 'C', 'D', or 'F')
     */
    private char calculateGrade(double marks) {
        if (marks >= 90.0) {
            return 'A';
        } else if (marks >= 80.0) {
            return 'B';
        } else if (marks >= 70.0) {
            return 'C';
        } else if (marks >= 60.0) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Getter methods to access private attributes
    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public char getGrade() {
        return grade;
    }
}
