import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class Node{
    String value;
    Node next;
    Node pre;
    Node(String value){
        this.value = value;
    }
}
public class text {
    private Node head;
    private Node tail;
    text(){
        head = null;
        tail = null;
    }
    public void append(String value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.pre = tail;
            tail = tail.next;
        }
    }
    public void prepend(String value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.pre = newNode;
            head = newNode;
        }
    }
    public Node RemoveFirst(){
        Node temp = head;
        if(head == null){
            return null;
        }
       
        else{
            head = head.next;
            head.pre = null;
        }
        return temp;
    }
    public Node RemoveLast(){
        Node temp = tail;
        if(tail == null){
            return null;
        }
        else{
            tail = tail.pre;
            tail.next = null;
        }
        return temp;
    }
    public Node Remove(String value){
        Node temp = head;
        Node before;
        Node after;
        while(temp != null){
            before = temp.pre;
            after = temp.next;
            if(temp.value == value){
               if(before != null && after != null){
                before.next = after;
                after.pre = before;
               }
               else if(temp == tail){
                return RemoveLast();
               }
               else if(temp == head){
                return RemoveFirst();
               }
               else{
               head = null;
               tail = null;
               }
               return null;
            }
            
            else{
                temp = temp.next;
            }
           
            
        }
        return temp;
        
    }
    public void print_list(){
        Node temp = head;
        while(temp != null){
            System.out.println("Text:"+temp.value);
            temp = temp.next;
        }
    }
    public void search(String value){
        Node temp = head;
        int length = 0;
        while(temp != null){
            if (temp.value == value){
                System.out.println("Found at:"+length);
                return;
        }
        else{
        temp = temp.next;
        }
        length++;
    }
    
        System.out.println("Not found");
    
    }
    public void Reverse() {
        Node temp = head;
        int length = 0;
        while(temp != null){
            prepend(temp.value);
            temp = temp.next;
            length++;
        }
        for(int i = 0; i < length; i++){
            RemoveLast();
        }
        print_list();
    }
    public void RemoveAll(){
        head = null;
        tail = null;
        return;
    }
    public void Sort(){
        int size = 0;
        Node temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        String s[] = new String[size];
        temp = head;
        for(int i = 0 ; i < size; i++){
            s[i] = temp.value;
            temp = temp.next;
        }
        RemoveAll();
        for(int i = 0; i < size; i++){
            String key = s[i];
            int j = i-1;
            while(j >= 0 && s[j].compareTo(key) > 0){
                s[j+1] = s[j];
                j--;
        }
        s[j+1] = key;
        }
        for(int i = 0; i < size; i++){
            append(s[i]);
        }
    
}
    
    public static void main(String[] args){
        text t = new text();
        t.append("Hello My name is Adhyayan Goyal");
        t.append("I am Currently in SY btech");
        t.prepend("My age is 18");
        t.append("Soham");
        t.append("Aditya");
        t.print_list();
        System.out.println();
        // t.Remove("Hello My name is Adhyayan Goyal");
        t.print_list();
        
        
        t.search("My age is 18");
         t.Reverse();
         System.out.println();
         t.search("My age is 18");
        //  System.out.println(t.Array());
        System.out.println();
        t.Sort();
        t.print_list();
        t.search("My age is 18");
    }

}
