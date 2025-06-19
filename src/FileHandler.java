import java.io.*;
import java.util.*;

// Saves student list to a text file
public class FileHandler {
    public void saveToFile(ArrayList<Student> studentsToSave, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Student student : studentsToSave) {
                writer.println(student.toString());
            }
            System.out.println("Saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}
