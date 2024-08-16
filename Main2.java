
public class Main2{
    public static void main(String[] args) {
        LinkedList lt= new LinkedList(5);
        lt.append(9);
        lt.append(19);
        
        lt.printList();
        System.out.println(lt.RemoveLast().value);
        lt.prepend(99);
        lt.printList();
        System.out.println(lt.removeFirst().value);
        lt.printList();
        lt.set(0,69);
        lt.printList();
        lt.Remove(0);
        lt.printList();
        
        
    }
}
