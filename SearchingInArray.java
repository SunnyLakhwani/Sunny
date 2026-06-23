import java.util.Scanner;

class SearchingInArray {
    public static void main(String[] args) {
        int a[] = new int [5]; int n,count=0;
        Scanner r=new Scanner(System.in);
        System.out.println("Enter Elements in Array");
        for(int i=0;i< a.length; i++){
            a[i] = r.nextInt();
        }
        System.out.println("Array Elements");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i] + " ");
        }
        System.out.println("\nEnter Search Element:");
        n=r.nextInt();
        for(int i=0;i< a.length;i++){
            if(a[i]==n){
                count++;
            }
        }
        if(count >0) {
            System.out.println("Item Found"+ count +"times");
        }
            else{
                System.out.println("Item Not Found");
            }
        }
    }

