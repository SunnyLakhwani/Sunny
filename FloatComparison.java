import java.util.Scanner;

public class FloatComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the first floating-point number: ");
        float num1 = scanner.nextFloat();

        System.out.print("Enter the second floating-point number: ");
        float num2 = scanner.nextFloat();


        if (areEqualUpToThreeDecimalPlaces(num1, num2)) {
            System.out.println("The numbers are the same up to three decimal places.");
        } else {
            System.out.println("The numbers are not the same up to three decimal places.");
        }


        scanner.close();
    }

    private static boolean areEqualUpToThreeDecimalPlaces(float num1, float num2) {

        float roundedNum1 = Math.round(num1 * 1000) / 1000f;
        float roundedNum2 = Math.round(num2 * 1000) / 1000f;


        return roundedNum1 == roundedNum2;
    }
}