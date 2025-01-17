import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class FindFiveRepeatedIntegersinB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array (n ≥ 6): ");
        int n = scanner.nextInt();

        int[] B = new int[n];

        System.out.println("Enter " + n + " integers (1 to " + (n - 5) + "):");
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }

        ArrayList<Integer> repeatedNumbers = findFiveRepeated(B);

        if (!repeatedNumbers.isEmpty()) {
            System.out.println("The repeated integers are: " + repeatedNumbers);
        } else {
            System.out.println("No repeated integers found.");
        }

        scanner.close();
    }

    private static ArrayList<Integer> findFiveRepeated(int[] B) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        ArrayList<Integer> repeatedNumbers = new ArrayList<>();

        for (int num : B) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) == 2 && !repeatedNumbers.contains(num)) {
                repeatedNumbers.add(num);
            }
            if (repeatedNumbers.size() == 5) {
                break;
            }
        }

        return repeatedNumbers;
    }
}