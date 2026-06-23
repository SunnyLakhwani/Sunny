import java.util.Scanner;

public class NumberOrderChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter the third number: ");
        double num3 = scanner.nextDouble();

        String result = checkOrder(num1, num2, num3);
        System.out.println(result);

        scanner.close();
    }

    private static String checkOrder(double num1, double num2, double num3) {
        if (num1 < num2 && num2 < num3) {
            return "increasing";
        } else if (num1 > num2 && num2 > num3) {
            return "decreasing";
        } else {
            return "Neither increasing nor decreasing order";
        }
    }
}