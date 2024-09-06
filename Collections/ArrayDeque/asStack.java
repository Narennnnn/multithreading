package Collections.ArrayDeque;

import java.util.*;

public class asStack {
    public static void main(String[] args) {
        Deque<Integer> stk = new ArrayDeque<>();
        for(int i=0;i<5;i++){
            stk.offerFirst(i*2);
        }
        while(!stk.isEmpty()){
            int val = stk.peekFirst();
            stk.pollFirst();
            System.out.print(val + ", ");
        }
    }
}
