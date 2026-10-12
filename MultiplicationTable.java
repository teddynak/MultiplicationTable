import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MultiplicationTable {
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        int[][] table = new int[MAX_NUMBER + 1][MAX_NUMBER + 1];

        // Store every product from 0 x 0 through 100 x 100.
        for (int i = 0; i <= MAX_NUMBER; i++) {
            for (int j = 0; j <= MAX_NUMBER; j++) {
                table[i][j] = i * j;
            }
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Choose a multiplication table (1-100): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a whole number.");
                return;
            }

            int chosenTable = scanner.nextInt();
            if (chosenTable < 1 || chosenTable > MAX_NUMBER) {
                System.out.println("The table number must be from 1 to 100.");
                return;
            }

            System.out.println("Multiplication table for " + chosenTable + ":");
            for (int j = 1; j <= MAX_NUMBER; j++) {
                System.out.println(chosenTable + " x " + j + " = " + table[chosenTable][j]);
            }

            System.out.print("Save all 10,000 equations to multiplication_table.txt? (y/n): ");
            String answer = scanner.next().trim();
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                saveFullTable(table);
            } else {
                System.out.println("The full table was not saved.");
            }
        }
    }

    private static void saveFullTable(int[][] table) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("multiplication_table.txt"))) {
            for (int i = 1; i <= MAX_NUMBER; i++) {
                for (int j = 1; j <= MAX_NUMBER; j++) {
                    writer.write(i + " x " + j + " = " + table[i][j]);
                    writer.newLine();
                }
            }
            System.out.println("Saved all 10,000 equations to multiplication_table.txt.");
        } catch (IOException e) {
            System.out.println("Could not save the table: " + e.getMessage());
        }
    }
}
