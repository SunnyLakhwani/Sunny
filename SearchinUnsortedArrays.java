  class searchinUnsortedArrays {
     // Function to implement
     // search operation
     static int findElements(int arr[], int n, int key) {
         for (int i = 0; i < n; i++)
             if (arr[i] == key)
                 return i;

         // If the key is not found
         return -1;
     }
 }

 public static void main(String[] args) {

     int arr[] = {12, 34, 10, 6, 40};
     int n = arr.length;

     // Using a last element as search element
     int key = 40;

     // Function call
     int position = searchinUnsortedArrays.findElements(arr, n, key);

         if (position == -1)
             System.out.println("Element not found");
         else
             System.out.println("Element Found at Position: " + (position + 1));
     }
 




