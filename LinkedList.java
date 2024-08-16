import java.util.*;
public class LinkedList{
    private Node head;
    private Node tail;
    private int length;
    class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
        }
    }
    public LinkedList(int value){
        Node newNode= new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }
    public void append(int value){
        Node newNode= new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            tail=newNode;
        }
        length++;
    }
    public void printList(){
        Node temp=head;
        while (temp!=null) {
            System.out.println(temp.value);
            temp=temp.next;
        }
    }
    public void prepend(int value){
        Node newNode = new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
        length++;

    }
    public Node RemoveLast(){
        if(length==0)
            return null;
        
        Node temp=head;
        Node pre=head;
        while(temp.next!=null){
            pre=temp;
            temp=temp.next;
        }
        tail=pre;
        tail.next=null;
        length--;
        if(length==0){
            head=null;
            tail=null;
            
        }
        return temp;
    }
    public Node removeFirst(){
        if(length==0){
            return null;
        }
        Node temp=head;
        head=head.next;
        temp.next=null;
        length--;
        if(length==0){
            tail=null;
        }
        return temp;
    }
    public Node get(int index){
        if(index<0||index>=length){
            return null;
        }
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
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
        Node newNode= new Node(value);
        Node temp= get(index-1);
        newNode.next=temp.next;
        temp.next=newNode;
        length++;
        return true;
    }
    public Node Remove(int index){
        if(index<0||index>=length){
            return null;
        }
        if(index==0){
           return removeFirst();
        }
        if(index==length-1){
            return RemoveLast();
        }
        else{
            Node pre=get(index-1);
            Node temp=pre.next;
            pre.next=temp.next;
            temp.next=null;
            return temp;
        }
    }
    public void Reverse(){
        Node temp=null;
        temp=head;
        head=tail;
        tail=temp;
        Node pre=null;
        Node post=temp.next;
        for(int i=0;i<length;i++){
            post=temp.next;
            temp.next=pre;
            pre=temp;
            temp=post;
        }
    }
}

