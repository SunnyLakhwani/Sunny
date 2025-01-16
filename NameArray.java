import java.util.Arrays;

public class NameArray {
    public static void main(String[] args) {

        String[] names = {"Adam", "Clark", "Evans", "Salim", "Jones", "Lane", "Pace", "Smith"};


        System.out.println("NAME[2]: " + names[2]);
        System.out.println("NAME[4]: " + names[4]);
        System.out.println("NAME[7]: " + names[7]);


        String newName = "Davis";
        names = insertName(names, newName);

        System.out.println("Array after inserting 'Davis': " + Arrays.toString(names));


        String nameToDelete = "Salim";
        names = deleteName(names, nameToDelete);

        System.out.println("Array after deleting 'Salim': " + Arrays.toString(names));
    }


    public static String[] insertName(String[] arr, String name) {
        int n = arr.length;
        String[] newArr = new String[n + 1];
        int i = 0;


        while (i < n && arr[i].compareTo(name) < 0) {
            newArr[i] = arr[i];
            i++;
        }


        newArr[i] = name;


        for (int j = i; j < n; j++) {
            newArr[j + 1] = arr[j];
        }

        return newArr;
    }


    public static String[] deleteName(String[] arr, String name) {
        int n = arr.length;
        String[] newArr = new String[n - 1];
        int i = 0, j = 0;

        
        while (i < n) {
            if (!arr[i].equals(name)) {
                newArr[j++] = arr[i];
            }
            i++;
        }

        return newArr;
    }
}