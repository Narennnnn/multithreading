package Collections.queue;
import java.util.*;
public class queues {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<10;i++){
            q.offer(i*10+1);
        }
        while(!q.isEmpty()){
            int val = q.peek(); 
            q.poll();
            System.out.print(val+", ");
        }
    }
}
// Whenever you want to use Normal Queue use Linked list class
// Whenever you want to use Stack use Stack class