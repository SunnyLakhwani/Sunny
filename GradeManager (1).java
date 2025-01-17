import java.util.Scanner;

public class GradeManager {
    private int[] grades;
    private int size;

    public GradeManager(int capacity) {
        grades = new int[capacity];
        size = 0;
    }

    public void insertGrade(int index, int grade) {
        if (grade < 0) {
            System.out.println("Please enter a valid positive integer.");
            return;
        }
        if (index < 0 || index >= grades.length) {
            System.out.println("Index out of bounds.");
            return;
        }
        if (size <= index) {
            System.out.println("Index is beyond current size. Expanding the size.");
            size = index + 1;
        }
        if (grades[index] == 0 || grade < grades[index]) {
            grades[index] = grade;
            System.out.println("Grade inserted successfully.");
        } else {
            System.out.println("Entered grade is greater than the existing grade at index " + index + ".");
        }
    }

    public void searchGrade(int grade) {
        for (int i = 0; i < size; i++) {
            if (grades[i] == grade) {
                System.out.print("Grade found: " + grade + ". ");
                // Print neighbors
                if (i > 0) {
                    System.out.print("Left neighbor: " + grades[i - 1] + ". ");
                } else {
                    System.out.print("No left neighbor. ");
                }
                if (i < size - 1) {
                    System.out.print("Right neighbor: " + grades[i + 1] + ". ");
                } else {
                    System.out.print("No right neighbor. ");
                }
                System.out.println();
                return;
            }
        }
        System.out.println("Grades Not Found");
    }

    public void findAverageGrade() {
        if (size == 0) {
            System.out.println("No grades available to calculate average.");
            return;
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += grades[i];
        }
        double average = (double) sum / size;
        System.out.printf("Average grade: %.2f%n", average);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeManager manager = new GradeManager(10); // Initial capacity of 10

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Insert Grade");
            System.out.println("2. Search for a Grade");
            System.out.println("3. Find Average Grade");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter index to insert grade: ");
                    int index = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    int grade = scanner.nextInt();
                    manager.insertGrade(index, grade);
                    break;
                case 2:
                    System.out.print("Enter grade to search: ");
                    int searchGrade = scanner.nextInt();
                    manager.searchGrade(searchGrade);
                    break;
                case 3:
                    manager.findAverageGrade();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
