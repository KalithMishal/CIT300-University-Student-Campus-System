import java.util.Scanner;

/** Small console input helpers that keep prompting until input is valid. */
public class InputValidator {
    private InputValidator() { }

    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    public static double readMarks(Scanner scanner) {
        while (true) {
            System.out.print("Marks (0-100): ");
            try {
                double marks = Double.parseDouble(scanner.nextLine().trim());
                if (Double.isFinite(marks) && marks >= 0 && marks <= 100) return marks;
            } catch (NumberFormatException exception) {
                // Show the same helpful message for non-numeric input.
            }
            System.out.println("Enter a number between 0 and 100.");
        }
    }

    public static String readRequiredText(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("This field cannot be empty.");
        }
    }
}
