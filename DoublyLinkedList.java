
public class DoublyLinkedList{
    private Node head;
    private Node tail;
    private int length;
    class Node{
        int value;
        Node next;
        Node pre;
        Node(int value){
            this.value = value;
        }
    }
    public DoublyLinkedList (int value){
        Node newNode=new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
    public void getHead(){
        System.out.println("Head:"+head.value);
    }
    public void getTail(){
         System.out.println("Tail:"+tail.value);
    }
    public void getLength(){
        System.out.println("Length:"+length);
    }
    public void append(int value){
        Node newNode=new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            newNode.pre=tail;
            tail=newNode;
        }
        length++;
    }
    public Node removeLast(){
        if(length==0){
            return null;
        }
        else{
            Node temp=tail;
            tail=tail.pre;
            tail.next=null;
            temp.next=null;
            length--;
            if(length==0){
                head=null;
                tail=null;
            }
            return temp;
        }
    }
    public void prepend(int value){
        Node newNode=new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }
        else{
            newNode.next=head;
            head.pre=newNode;
            head=newNode;
        }
        length++;
    }
    public Node removeFirst(){
        if(length==0){
            return null;
        }
        else{
            Node temp=head;
            head=head.next;
            head.pre=null;
            temp.next=null;
            length--;
            if(length==0){
                head=null;
                tail=null;
        }
        return temp;
    }

}
public Node get(int index){
    if(index<0&&index>=length){
        return null;
    }
    Node temp=head;
    if(index<length/2){
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
    }
    else{
        temp =tail;
        for(int i=length-1;i> index;i--){
            temp=temp.pre;
        }
    }
    return temp;
}
public boolean set(int index,int value){
    Node temp=get(index);
    if(temp!=null){
        temp.value=value;
        return true;
    }
    return false;
}
public boolean insert(int index,int value){
    if(index<0||index>length){
        return false;
    }
    if(index==0){
        prepend(value);
        return true;
    }
    if(index==length){
        append(value);
        return true;
    }
    else{
        Node newNode=new Node(value);
        Node before=get(index-1);
        Node after=before.next;
        newNode.next=after;
        newNode.pre=before;
        before.next=newNode;
        after.pre=newNode;
        length++;
        return true;
    
}
}
public Node Remove(int index){
    if(index<0||index>=length){
        return null;
    }
    if(index==0){
       return removeFirst();
        
    }
    if(index==length-1){
        return removeLast();
        
    }
    else{
        Node before=get(index-1);
        Node temp=before.next;
        Node after= temp.next;
        temp.pre=null;
        temp.next=null;
        after.pre=before;
        before.next=after;
        length--;
        return temp;
    }
    
}
}
