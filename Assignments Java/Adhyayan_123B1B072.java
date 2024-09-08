//Name: Adhyayan Goyal
//PRN: 123B1B072
//Batch: B1
//For executing the Java file in Windows : we have to write in CMD: javac Adhyayan_123B1B072.java
//After compiling with no error just write in CMD: java Adhyayan_123B1B072 and code will execute then.
import java.util.*;
class Employee{
    int EmpID;
    String EmpName;
    float EmpSalary;
    public void get_data(Scanner sc){
        System.out.print("Enter your Name: ");
        EmpName = sc.nextLine();
        System.out.print("Enter your Salary: ");
        EmpSalary = sc.nextFloat();
        sc.nextLine(); 
        EmpID = (int)(Math.random()*100);
    }
    public void show_data(){
        System.out.println("ID: "+EmpID+"   "+"Name: "+EmpName+"   "+"Salary: "+EmpSalary);
    }
}
public class Adhyayan_123B1B072{
    public static void mergePartition(Employee e[], int left, int right){
        int mid = (left + right) / 2;
        if(left < right){
            mergePartition(e, left, mid);
            mergePartition(e, mid + 1, right);
            MergeSort(e, left , right , mid);
        }
    }
    public static void MergeSort(Employee e[], int left, int right, int mid){
        int i = left;
        int j = mid + 1;
        int k = 0;
        Employee merge[] = new Employee[right - left + 1];
        while(i <= mid && j <= right){
            if(e[i].EmpName.compareTo(e[j].EmpName) <= 0){
                merge[k] = e[i];
                i++;
                k++;
            }
            else{
                merge[k] = e[j];
                k++;
                j++;
            }

        }
        while(i <= mid){
            merge[k] = e[i];
            k++;
            i++;
        }
        while(j <= right) {
            merge[k] = e[j];
            k++;
            j++;
        }
        for(int m = 0 , n = left; m<k; m++,n++){
            e[n] = merge[m];
        }
    }
    public static int partition(Employee e[], int left , int right){
        int pivot = e[left].EmpID;
        int i = left + 1;
        int j = right;
        while(i <= j){
            while(i <= j && e[i].EmpID <= pivot){
                i++;
            }
            while(i <= j && e[j].EmpID > pivot){
                j--;
            }
            if(i <= j){
                Employee temp = e[i];
                e[i] = e[j];
                e[j] = temp;
            }
        }
        Employee temp = e[left];
        e[left] = e[j];
        e[j] = temp;
        return j;
    }
    public static void QuickSort(Employee e[], int left ,int right){
        if(left < right){
            int pividx = partition(e, left, right);
            QuickSort(e, left, pividx-1);
            QuickSort(e, pividx+1, right);
    }
}
    public static int TypeOfSorting(Scanner sc){
        System.out.print("Press 1 for Sorting with EmpId or Press 2 for Sorting with EmpName: ");
        int x = sc.nextInt();
        if(x == 1 || x == 2){
        return x;
        }
        else{
            System.out.println("Invalid Input");
            return TypeOfSorting(sc);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of Employee class you want to store the information: ");
        int size = sc.nextInt();
        sc.nextLine();
        Employee e[] = new Employee[size];
        for(int i = 0; i < size; i++){
            e[i] = new Employee();
            e[i].get_data(sc);
        }
        System.out.println("Data before Sorting: ");
        for(int i = 0; i < size; i++){
            e[i].show_data();
        }
        int result = TypeOfSorting(sc);
        
        if(result == 1){
            QuickSort(e, 0, size - 1);
        }
        else{
            mergePartition(e, 0, size-1);
        }
        
        System.out.println("Data After Sorting: ");

        
        for(int i = 0; i < size; i++){
            e[i].show_data();
        }
    }
}