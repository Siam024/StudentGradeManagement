// Main driver class that runs the whole system

import java.util.ArrayList;

public class GradeAnalyzerSystem {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        StudentManager studentManager = new StudentManager();
        FileHandler fileHandler = new FileHandler();

        while (true) {
            System.out.println("\n------ Grade Management Menu ------");
            System.out.println("1. Add Undergraduate Student");
            System.out.println("2. Add Graduate Student");
            System.out.println("3. View All Students");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Sort by GPA");
            System.out.println("6. Sort by Highest Mark");
            System.out.println("7. Delete Student by ID");
            System.out.println("8. Save Records to File");
            System.out.println("9. Exit");

            int menuChoice = inputHandler.getInt("Choose an option: ");

            switch (menuChoice) {
                case 1: {
                    String studentName = inputHandler.getString("Enter name: ");
                    String studentId = inputHandler.getString("Enter ID: ");
                    int numberOfSubjects = inputHandler.getInt("Enter number of subjects: ");
                    ArrayList<Double> subjectMarks = inputHandler.getMarks(numberOfSubjects, "subject mark");
                    Student undergradStudent = new Student(studentName, studentId, subjectMarks);
                    studentManager.addStudent(undergradStudent);
                    break;
                }
                case 2: {
                    String studentName = inputHandler.getString("Enter name: ");
                    String studentId = inputHandler.getString("Enter ID: ");
                    ArrayList<Double> semesterGPAs = inputHandler.getMarks(4, "semester GPA");
                    final Student gradStudent = new GraduateStudent(studentName, studentId, semesterGPAs);
                    studentManager.addStudent(gradStudent);
                    break;
                }
                case 3:
                    studentManager.showAll();
                    break;
                case 4:
                    studentManager.searchById(inputHandler.getString("Enter ID to search: "));
                    break;
                case 5:
                    studentManager.sortByGrade();
                    break;
                case 6:
                    studentManager.sortByHighestMark();
                    break;
                case 7:
                    studentManager.deleteById(inputHandler.getString("Enter ID to delete: "));
                    break;
                case 8:
                    fileHandler.saveToFile(studentManager.getAllStudents(), "grades.txt");
                    break;
                case 9:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
