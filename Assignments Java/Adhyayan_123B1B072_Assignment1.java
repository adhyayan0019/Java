//Name: Adhyayan Goyal
//PRN: 123B1B072
//Batch: B1
//For executing the Java file in Windows : we have to write in CMD: javac Adhyayan_123B1B072_Assignment1.java
//After compiling with no error just write in CMD: java Adhyayan_123B1B072_Assignment1 and code will execute then.
import java.util.Scanner;

class Student{
     String name;
     int PRN;
     double SGPA;
     
     void get_data(Scanner sc){
        System.out.print("Enter Your Name:");
        name = sc.nextLine();
        System.out.print("Enter Your PRN:");
        PRN = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter SGPA:");
        SGPA = sc.nextDouble();
        sc.nextLine();
    }
     void show_data(){
        System.out.println("Name: "+name+"   "+"PRN: "+PRN+"   "+"SGPA: "+SGPA+"   ");
    }

}

    public class Adhyayan_123B1B072_Assignment1 {


    public static void insertionSort(Student s[], int size){
        for (int i = 1; i < size; i++) {
            Student key = s[i];
            int j = i - 1;
            while(j >=0 && s[j].PRN > key.PRN){
                s[j+1] = s[j];
                j--;
            }
            s[j+1] = key;
    }
}
    
    public static void shellSorting(Student s[],int size){
        Student temp;
       for(int gap = size / 2; gap >= 1; gap/=2){
        for(int i = gap;i < size; i++){
            for(int j = i - gap; j >= 0; j-=gap){
                
                if(s[j+gap].name.compareTo(s[j].name) >= 0){
                    break;
                }
                else{
                    temp = s[j];
                    s[j] = s[j+gap];
                    s[j+gap] = temp;
                }
            }
        }
       }
    }
    public static void radixSort(Student s[], int count){
        Student temp[] = new Student[s.length];
        
            int c[] = new int[count];
            int div = (int)(Math.pow(count, 0));
            for(int i = 0; i < s.length; i++){
                c[(int)((s[i].SGPA / div) % 10)]++;
            }
            for(int i = 1; i < count; i++){
                c[i] = c[i] + c[i - 1];
            }
            for(int i = s.length - 1; i >= 0; i--){
                int mod = (int)((s[i].SGPA / div) % 10);
                temp[--c[mod]] = s[i];
            }
            for(int i = 0; i < temp.length; i++){
                s[i] = temp[i];
            }
        }
    public static int TypeOfSorting(Scanner sc){
        System.out.print("Press 1 for Sorting with RollNo. or Press 2 for Sorting with Name or Press 3 for Sorting with SGPA: ");
        int x = sc.nextInt();
        if(x == 1 || x == 2 || x == 3){
        return x;
        }
        else{
            System.out.println("Invalid Input");
            return TypeOfSorting(sc);
        }
    }
     
    
    public static void main(String[] args) {
       int size = 5;
       Scanner sc= new Scanner(System.in);
       
       Student s[] = new Student[size];
       for(int i = 0; i < size; i++){
        s[i] = new Student();
        s[i].get_data(sc);
       }
       System.out.println("Before Sorting:");
       for(int i = 0;i < size; i++){
        s[i].show_data();
       }
       int result = TypeOfSorting(sc);
       if(result == 1){
        insertionSort(s, size);
       }
       else if(result == 2){
        shellSorting(s, size);
       }
       else{
        radixSort(s, 10);
       }
       System.out.println("After Sorting:");
       
       for(int i = 0;i < size; i++){
        s[i].show_data();
       }

    }
}

