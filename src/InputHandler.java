import java.util.*;

// Handles and validates user input
public class InputHandler {
    Scanner scanner = new Scanner(System.in);

    public String getString(String promptMessage) {
        System.out.print(promptMessage);
        return scanner.nextLine();
    }

    public int getInt(String promptMessage) {
        while (true) {
            try {
                System.out.print(promptMessage);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    public double getDouble(String promptMessage) {
        while (true) {
            try {
                System.out.print(promptMessage);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    // Get list of marks/GPA values
    public ArrayList<Double> getMarks(int numberOfEntries, String label) {
        ArrayList<Double> marksList = new ArrayList<>();
        for (int i = 0; i < numberOfEntries; i++) {
            marksList.add(getDouble("Enter " + label + " for subject/semester " + (i + 1) + ": "));
        }
        return marksList;
    }
}
