import java.util.Scanner;

public class ArrayInsertion {
    private static int[] LA;
    private static int size;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        size = 10;
        LA = new int[size];

        for (int i = 0; i < size; i++) {
            LA[i] = i + 1;
        }

        System.out.println("Current array: ");
        displayArray();

        System.out.print("Enter the index (K) to insert ITEM: ");
        int K = scanner.nextInt();

        System.out.print("Enter a positive integer (ITEM): ");
        int ITEM = scanner.nextInt();

        insert(LA, K, ITEM);

        System.out.println("Updated array: ");
        displayArray();

        scanner.close();
    }

    private static void insert(int[] LA, int K, int ITEM) {

        if (K < 0 || K >= size) {
            System.out.println("Error: Index K is out of range.");
            return;
        }

        if (ITEM <= 0) {
            System.out.println("Error: ITEM must be a positive integer.");
            return;
        }

        if (ITEM < LA[K]) {
            LA[K] = ITEM;
            System.out.println("ITEM inserted at index " + K + ".");
        } else {
            System.out.println("ITEM at index " + K + " is greater than user's entered ITEM.");
        }
    }

    private static void displayArray() {
        for (int value : LA) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}