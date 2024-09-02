import java.util.*;
public class mergesort{
    public static void divide(int arr[],int l,int r){
       if(l<r){
        int mid=(l+r)/2;
        divide(arr, l, mid);//Dividing the left part of original array into 2 halves then performing recursion function to divide till we get the element only one. 
        divide(arr, mid+1, r);//Dividing the right part of original array into 2 halves then performing recursion function to divide till we get the element only one.
        merge(arr, l, mid, r);//in first recursion tha half arrays get filled in the merge array I made in the function.
       }

    }
    public static void merge(int arr[],int l,int mid,int r){
        int n1=mid-l+1;//initialising the size from 0 to mid+1
        int n2=r-mid;//iniatilizing the size from right-mid
        int merge[]=new int[n1+n2];//adding both size
        int i=l;//l=0
        int j=mid+1;//Midpoint of array
        int k=0;//for putting values in merge array
        while(i<=mid&&j<=r){//putting condition for i should be more than or equal to mid and j should not be greater than equal to right.
            if(arr[i]<=arr[j]){
                merge[k++]=arr[i++];//putting the values in merge array and incrementing i and k at the same time.

        }
        else{
            merge[k++]=arr[j++];//putting the values in merge array and incrementing j and k at the same time.
        }
    }
    //Now putting rest of the elements in the merge array.
    while(i<=mid){
        merge[k++]=arr[i++];
    }
    while (j<=r) {
        merge[k++]=arr[j++];
        
    }
    for(int m=0, n=l;m<merge.length;m++,n++){
        arr[n]=merge[m];
    }
        
    }
    public static void main(String[] args) {

        int arr[]={5,3,7,1,7,2,6,9,3,4};
        int left=0;
        int right=arr.length-1;
        divide(arr,left,right);
        for(int m=0;m<arr.length;m++){
            System.out.print(arr[m]+" ");
        }
        System.out.println();
    }
}