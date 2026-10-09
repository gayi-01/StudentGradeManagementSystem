import java.util.ArrayList;
import java.util.Scanner;


public class StudentGradeManagementSystem {

    
    private static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("=================================================");
        System.out.println("   WELCOME TO STUDENT GRADE MANAGEMENT SYSTEM   ");
        System.out.println("=================================================");

                // Main application loop
        while (isRunning) {
            printMenu();
            System.out.print("Enter your choice (1-4): ");
            String input = scanner.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\n[ERROR] Invalid input! Please enter a number between 1 and 4.\n");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudentMenu(scanner);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    displayStatistics();
                    break;
                case 4:
                    System.out.println("\nThank you for using Student Grade Management System. Goodbye!\n");
                    isRunning = false;
                    break;
                default:
                    System.out.println("\n[ERROR] Invalid choice! Please select an option from 1 to 4.\n");
            }
        }

        scanner.close();
    }

    /**
     * Displays the interactive main menu.
     */
    private static void printMenu() {
        System.out.println("\n----------------- MAIN MENU -----------------");
        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Display Statistics");
        System.out.println("4. Exit");
        System.out.println("---------------------------------------------");
    }

    /**
     * Handles adding one or multiple students with validation.
     *
     * @param scanner Scanner instance for reading user input
     */
    private static void addStudentMenu(Scanner scanner) {
        boolean addMore = true;

        while (addMore) {
            System.out.println("\n--- Add New Student ---");

            // 1. Get and validate student name
            String name = "";
            while (name.isEmpty()) {
                System.out.print("Enter Student Name: ");
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("[ERROR] Student name cannot be empty. Please enter a valid name.");
                }
            }

            // 2. Get and validate student marks (must be between 0 and 100)
            double marks = -1.0;
            while (marks < 0.0 || marks > 100.0) {
                System.out.print("Enter Marks (0 - 100): ");
                String markInput = scanner.nextLine().trim();

                try {
                    marks = Double.parseDouble(markInput);
                    if (marks < 0.0 || marks > 100.0) {
                        System.out.println("[ERROR] Marks must be between 0 and 100. Please try again.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("[ERROR] Invalid number format! Please enter a numerical value.");
                }
            }

            // 3. Create Student object and add to list
            Student student = new Student(name, marks);
            studentList.add(student);

            System.out.println("\n[SUCCESS] Student added successfully!");
            System.out.printf("Name: %s | Marks: %.2f | Grade: %c%n", student.getName(), student.getMarks(), student.getGrade());

            // 4. Ask if user wants to add another student right away
            System.out.print("\nDo you want to add another student? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("y") && !response.equals("yes")) {
                addMore = false;
            }
        }
    }

    /**
     * Displays all student records in a formatted summary report table.
     * Also displays summary statistics (average, highest, lowest) at the end.
     */
    private static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("\n[INFO] No student records found. Please add students first (Option 1).");
            return;
        }

        System.out.println("\n========================================================================");
        System.out.println("                         STUDENT GRADE REPORT                           ");
        System.out.println("========================================================================");
        System.out.printf("%-6s | %-30s | %-12s | %-6s%n", "No.", "Student Name", "Marks", "Grade");
        System.out.println("------------------------------------------------------------------------");

        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            System.out.printf("%-6d | %-30s | %-12.2f | %-6c%n", (i + 1), s.getName(), s.getMarks(), s.getGrade());
        }

        System.out.println("------------------------------------------------------------------------");
        
        // Display summary statistics at the end of report
        double avg = calculateAverage();
        double highest = getHighestMarks();
        double lowest = getLowestMarks();

        System.out.printf("Total Students : %d%n", studentList.size());
        System.out.printf("Average Marks  : %.2f%n", avg);
        System.out.printf("Highest Marks  : %.2f (%s)%n", highest, getStudentsWithMarks(highest));
        System.out.printf("Lowest Marks   : %.2f (%s)%n", lowest, getStudentsWithMarks(lowest));
        System.out.println("========================================================================");
    }

    /**
     * Displays overall statistics: Average, Highest, and Lowest marks.
     */
    private static void displayStatistics() {
        if (studentList.isEmpty()) {
            System.out.println("\n[INFO] No student records available to calculate statistics. Please add students first.");
            return;
        }

        double avg = calculateAverage();
        double highest = getHighestMarks();
        double lowest = getLowestMarks();

        System.out.println("\n========================================================================");
        System.out.println("                      CLASS PERFORMANCE STATISTICS                      ");
        System.out.println("========================================================================");
        System.out.printf("Total Students Enrolled : %d%n", studentList.size());
        System.out.printf("Average Marks           : %.2f%n", avg);
        System.out.printf("Highest Marks           : %.2f (Scored by: %s)%n", highest, getStudentsWithMarks(highest));
        System.out.printf("Lowest Marks            : %.2f (Scored by: %s)%n", lowest, getStudentsWithMarks(lowest));
        System.out.println("========================================================================");
    }

    /**
     * Calculates the average marks of all students.
     *
     * @return Average marks as double
     */
    private static double calculateAverage() {
        if (studentList.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Student s : studentList) {
            sum += s.getMarks();
        }
        return sum / studentList.size();
    }

    /**
     * Finds the highest mark among all students.
     *
     * @return Highest mark as double
     */
    private static double getHighestMarks() {
        double max = studentList.get(0).getMarks();
        for (Student s : studentList) {
            if (s.getMarks() > max) {
                max = s.getMarks();
            }
        }
        return max;
    }

    /**
     * Finds the lowest mark among all students.
     *
     * @return Lowest mark as double
     */
    private static double getLowestMarks() {
        double min = studentList.get(0).getMarks();
        for (Student s : studentList) {
            if (s.getMarks() < min) {
                min = s.getMarks();
            }
        }
        return min;
    }

    /**
     * Returns student name(s) matching the target mark.
     * Useful for displaying who scored the highest or lowest mark.
     *
     * @param targetMarks The score to match
     * @return Comma-separated names of students with target score
     */
    private static String getStudentsWithMarks(double targetMarks) {
        StringBuilder names = new StringBuilder();
        for (Student s : studentList) {
            if (Double.compare(s.getMarks(), targetMarks) == 0) {
                if (names.length() > 0) {
                    names.append(", ");
                }
                names.append(s.getName());
            }
        }
        return names.toString();
    }
}
