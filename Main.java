import java.util.*;
public class Main{
    public static void main(String[] args) {
        DoublyLinkedList dll=new DoublyLinkedList(5);
        dll.append(4);
        dll.prepend(69);
        dll.printList();
        System.out.println();
        dll.removeFirst();
        dll.printList();
        System.out.println();
        dll.get(2);
        dll.set(1,7);
        dll.insert(2,78);
        dll.Remove(0);
        dll.printList();
        
}   
}