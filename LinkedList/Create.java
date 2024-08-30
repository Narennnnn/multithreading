package LinkedList;
class LinkedList{
        int data;
        LinkedList next;
        LinkedList(int data){
            this.data=data;
            next=null;
        }
}
public class Create{
    public static void main(String[] args) {
        LinkedList n1= new LinkedList(10);
        LinkedList n2= new LinkedList(20);
        LinkedList n3= new LinkedList(30);
        LinkedList head = n1;
        head.next=n2;
        n2.next=n3;
        n3.next=null;
        // traversal
        LinkedList dummyHead = head;
        while(dummyHead != null){
            System.out.println(dummyHead.data);
            dummyHead = dummyHead.next;
        }
      
    }
}
/*
 run:
    ⚡➜ multithreading (! main) javac LinkedList/Create.java                 
    ⚡➜ multithreading (! main) java LinkedList.Create 
 */