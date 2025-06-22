import java.util.*;

// Manages all student records and operations
public class StudentManager {
    ArrayList<Student> studentList = new ArrayList<>();

    // Add student and confirm by name
    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Student added: " + student.getName());
    }

    // Show all students
    public void showAll() {
        if (studentList.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    // Search by ID
    public void searchById(String searchId) {
        for (Student student : studentList) {
            if (student.id.equalsIgnoreCase(searchId)) {
                System.out.println("Found: " + student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Sort students by CGPA in descending order using selection sort
    public void sortByGrade() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < studentList.size(); j++) {
                if (studentList.get(j).calculateGrade() > studentList.get(maxIndex).calculateGrade()) {
                    maxIndex = j;
                }
            }
            // Swap students at i and maxIndex
            Student temp = studentList.get(i);
            studentList.set(i, studentList.get(maxIndex));
            studentList.set(maxIndex, temp);
        }
        System.out.println("Sorted by grade (CGPA).");
    }

    // Sort students by highest mark/GPA in descending order using selection sort
    public void sortByHighestMark() {
        for (int i = 0; i < studentList.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < studentList.size(); j++) {
                if (studentList.get(j).getHighestMark() > studentList.get(maxIndex).getHighestMark()) {
                    maxIndex = j;
                }
            }
            // Swap students at i and maxIndex
            Student temp = studentList.get(i);
            studentList.set(i, studentList.get(maxIndex));
            studentList.set(maxIndex, temp);
        }
        System.out.println("Sorted by highest mark.");
    }

    // Delete student by ID and confirm by name
    public void deleteById(String deleteId) {
        Iterator<Student> iterator = studentList.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.id.equalsIgnoreCase(deleteId)) {
                iterator.remove();
                System.out.println("Deleted student: " + student.getName());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public ArrayList<Student> getAllStudents() {
        return studentList;
    }
}
