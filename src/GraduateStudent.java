// Subclass of Student — used when GPA is entered directly

import java.util.ArrayList;

public class GraduateStudent extends Student {

    public GraduateStudent(String studentName, String studentId, ArrayList<Double> semesterGPAs) {
        super(studentName, studentId, semesterGPAs);
    }

    // Calculate CGPA by averaging entered GPA values
    @Override
    public double calculateGrade() {
        double total = 0;
        for (double gpa : subjectMarks) {
            total += gpa;
        }
        return subjectMarks.size() > 0 ? total / subjectMarks.size() : 0.0;
    }

    // Return student type
    @Override
    public String getType() {
        return "Graduate";
    }
}
