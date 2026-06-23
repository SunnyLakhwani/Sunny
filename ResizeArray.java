class ResizeArray {
    public static void resize(int[] arr,int capacity){
        int temp[] = new int[capacity];
        for(int i=0; i<arr.length;i++){
            temp[i]=arr[i];
        }
        arr=temp;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        resize(arr, arr.length*2);
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i] + " ");
        }
       System.out.println(arr.length);
    }
}
