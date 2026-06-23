import java.util.Scanner;

public class ArraySearch {
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

        System.out.print("Enter an integer (ITEM) to search: ");
        int ITEM = scanner.nextInt();

        search(LA, ITEM);

        scanner.close();
    }

    private static void search(int[] LA, int ITEM) {
        boolean found = false;

        for (int i = 0; i < LA.length; i++) {
            if (LA[i] == ITEM) {
                found = true;
                System.out.println("ITEM " + ITEM + " found at index " + i + ".");

                if (i + 1 < LA.length) {
                    System.out.print("Right neighbors: ");
                    System.out.print(LA[i + 1]);
                    if (i + 2 < LA.length) {
                        System.out.print(", " + LA[i + 2]);
                    } else {
                        System.out.print(" (no second right neighbor)");
                    }
                    System.out.println();
                } else {
                    System.out.println("No right neighbor.");
                }

                // Print two left neighbors
                if (i - 1 >= 0) {
                    System.out.print("Left neighbors: ");
                    System.out.print(LA[i - 1]);
                    if (i - 2 >= 0) {
                        System.out.print(", " + LA[i - 2]);
                    } else {
                        System.out.print(" (no second left neighbor)");
                    }
                    System.out.println();
                } else {
                    System.out.println("No left neighbor.");
                }
            }
        }

        if (!found) {
            System.out.println("ITEM " + ITEM + " does not exist in the array.");
        }
    }

    private static void displayArray() {
        for (int value : LA) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}