import java.util.*;

// Base class for students (used by both Undergraduate and Graduate)
public class Student {
    protected String name;
    protected String id;
    protected ArrayList<Double> subjectMarks; // Can be raw marks or semester GPAs

    public Student(String studentName, String studentId, ArrayList<Double> subjectMarks) {
        this.name = studentName;
        this.id = studentId;
        this.subjectMarks = subjectMarks;
    }

    // Convert numeric mark to GPA based on grading scale
    public double convertToGPA(double mark) {
        if (mark >= 80) return 4.00;
        if (mark >= 75) return 3.75;
        if (mark >= 70) return 3.50;
        if (mark >= 65) return 3.25;
        if (mark >= 60) return 3.00;
        if (mark >= 55) return 2.75;
        if (mark >= 50) return 2.50;
        if (mark >= 45) return 2.25;
        if (mark >= 40) return 2.00;
        return 0.00;
    }

    // Convert GPA to letter grade
    public String convertToLetterGrade(double gpa) {
        if (gpa >= 4.00) return "A+";
        if (gpa >= 3.75) return "A";
        if (gpa >= 3.50) return "A-";
        if (gpa >= 3.25) return "B+";
        if (gpa >= 3.00) return "B";
        if (gpa >= 2.75) return "B-";
        if (gpa >= 2.50) return "C";
        if (gpa >= 2.25) return "D";
        if (gpa >= 2.00) return "E";
        return "F";
    }

    // Calculate CGPA by converting each mark to GPA and averaging
    public double calculateGrade() {
        double totalGPA = 0;
        for (double mark : subjectMarks) {
            totalGPA += convertToGPA(mark);
        }
        return subjectMarks.size() > 0 ? totalGPA / subjectMarks.size() : 0.0;
    }

    // Return type of student (default: undergraduate)
    public String getType() {
        return "Undergraduate";
    }

    // Get highest value among marks
    public double getHighestMark() {
        return Collections.max(subjectMarks);
    }

    // Return formatted string with ID, name, CGPA and grade
    public String toString() {
        double cgpa = calculateGrade();
        return id + ", " + name + ", " + getType() + ", CGPA: " +
               String.format("%.2f", cgpa) + " (" + convertToLetterGrade(cgpa) + ")";
    }

    // Return name of student
    public String getName() {
        return name;
    }
}
