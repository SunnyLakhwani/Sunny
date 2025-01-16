import java.util.Scanner;

 class Insertion {
     public static void main(String[] args) {
         int a[] = new int[50];
         Scanner in = new Scanner(System.in);
         System.out.println("Enter The Size Of A Array: ");
         int size = in.nextInt();
         System.out.println("Array Before Insertion: ");
         for(int i=0; i<size; i++)
         {
             a[i] = in.nextInt();
         }
         // Insertion
         System.out.println("\n Enter the Element to be Inserted: ");
         int x= in.nextInt();
         System.out.println("Enter the Position or index where you want To Insert: ");
         int pos = in.nextInt();
         for(int i=size; i>pos; i--){
            a[i]=a[i-1];
         }
         a[pos] = x;
         size++;

         System.out.println("Array After Insertion: ");
         for(int i=0; i<size; i++){
             System.out.println(a[i] + ", ");
         }
     }
}
