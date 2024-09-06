package Collections.ArrayDeque;

import java.util.*;

public class asQueue{
    public static void main(String[] args) {
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<4;i++){
            q.offerLast(i*i);
        }
        while(!q.isEmpty()){
            int val = q.peekFirst();
            q.pollFirst();
            System.out.print(val+", ");
        }
    }
}