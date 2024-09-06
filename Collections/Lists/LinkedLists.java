package Collections.Lists;
import java.util.*;
public class LinkedLists {
    // Since LinkedList class also implements List interface it will have all the methods of List Interface like to ArrayList
    public static void main(String[] args) {
        LinkedList<Integer> llist = new LinkedList<>();// internally uses doubly linked list
        llist.add(10);
        llist.add(30);
        llist.add(32);
        llist.add(310);
        llist.add(190);
        llist.add(300);
        ListIterator<Integer> itr = llist.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());// return llist[index++];
        }
        System.out.println(itr.previous()+" "+itr.previous());// return llist[--index];
    }
}
