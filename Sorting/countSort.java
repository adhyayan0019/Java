import java.util.*;

public class countSort {
    public static void counting(int arr[],int count){
        
        int Temp[]=new int[arr.length];
        for(int d=0;d<3;d++){
            int c[]=new int[count];
            int div=(int)Math.pow(count, d);
        
        for(int i=0;i<arr.length;i++){
            c[(arr[i]/div)%10]++;
    }
    for(int i=1;i<count;i++){
       c[i]=c[i]+c[i-1];
    }
    for(int i=arr.length-1;i>=0;i--){
        int mod =(arr[i]/div)%10;
        Temp[--c[mod]]=arr[i];
       
    }
    
}
for(int i=0;i<Temp.length;i++){
    System.out.print(Temp[i]+" ");
}

}
    
   
public static void main(String[] args) {
    int arr[]={634, 459, 287, 391, 490, 672, 339, 450, 600, 250, 117, 554};
    int count=10;
     counting(arr, count);
}
}
