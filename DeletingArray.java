import java.util.Scanner;

class DeletingArray {
    public static void main(String[] args) {
        int size, loc, i;
        Scanner n = new Scanner(System.in);

        System.out.println("Enter Array Size:");
        size = n.nextInt();

        int a[] = new int[size];
        System.out.println("Enter Array Elements:");
        for (i = 0; i < size; i++) {
            a[i] = n.nextInt();
        }

        System.out.println("Enter Array Location (0 to " + (size - 1) + "):");
        loc = n.nextInt();

        // Check if location is valid
        if (loc < 0 || loc >= size) {
            System.out.println("Invalid location! Please enter a number between 0 and " + (size - 1));
            return; // Exit if invalid
        }

        // Shift elements left from the specified location
        for (i = loc; i < size - 1; i++) {
            a[i] = a[i + 1];
        }

        // Decrease size by one
        size--;

        // Display the updated array
        System.out.println("Array after deletion:");
        for (i = 0; i < size; i++) {
            System.out.println(a[i] + " ");
        }
    }
}