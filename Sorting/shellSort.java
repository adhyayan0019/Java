public class shellSort {
    public static void Shellsort(int arr[]){
        int n=arr.length;
        for(int gap=n/2;gap>=1;gap/=2){
            for(int i=gap;i<n;i++){
                // int temp=arr[i];
            for(int j=i-gap;j>=0;j-=gap){
                int temp=0;
                if(arr[j+gap]>arr[j]){
                    break;
                }
                else{
                    temp=arr[j];
                    arr[j]=arr[j+gap];
                    arr[j+gap]=temp;
                    
                }
            }    
                

    }
}
for(int i=0;i<n;i++){
    System.out.print(arr[i]+" ");
}
    }
    public static void main(String[] args) {
        int arr[]={2,7,4,1,5,3};
        Shellsort(arr);
    }
}
