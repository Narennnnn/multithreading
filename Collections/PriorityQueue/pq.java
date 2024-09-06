package Collections.PriorityQueue;

import java.util.*;

public class pq {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();// by defualt min heap
        priorityQueue.add(100);
        priorityQueue.add(90);
        priorityQueue.add(210);
        while(!priorityQueue.isEmpty()){
            int top = priorityQueue.peek();
            priorityQueue.poll();
            System.out.print(top+", ");
        }
        System.out.println();
        PriorityQueue<Integer> priorityQueue1=new PriorityQueue<>((a,b)->b-a);
        // making max heap by passing custom comparator(lambda expression)
        // total ordering >>> natural ordering
        priorityQueue1.add(101);
        priorityQueue1.add(10);
        priorityQueue1.add(200);
        while(!priorityQueue1.isEmpty()){
            int top = priorityQueue1.peek();
            priorityQueue1.poll();
            System.out.print(top+", ");
        }
    }
    
}
