import java.util.*;
public class QuickSort {
    public static int pivot(int arr[],int piv,int n){
        
        int swap=piv;
        for(int i=piv+1;i<=n;i++){
            if(arr[i]<arr[piv]){
                swap++;
                int temp=arr[i];
                arr[i]=arr[swap];
                arr[swap]=temp;
        }
    }
    int temp=arr[swap];
    arr[swap]=arr[piv];
    arr[piv]=temp;
    return swap;
}
public static void sort(int arr[],int left,int right){
    if(left<right){
    int pividx=pivot(arr,left,right);
    sort(arr,left,pividx-1);
    sort(arr,pividx+1,right);
}   
}
public static void main(String[] args) {
    int arr[]={5,2,9,1,7,3,6,8};
    int n=arr.length-1;
    sort(arr,0,n);
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
    }
    System.out.println();
}
}
