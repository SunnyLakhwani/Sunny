 class SearchMin {
     public static void main(String[] args) {
         int[] a={4,2,3,6,8,1,7};

         int min=a[0];
         for(int i=1;i<a.length;i++){
             if(min > a[i]){
                 min=a[i];
             }
         }
         System.out.println("Minimum Value Is :" + min);
     }
}
