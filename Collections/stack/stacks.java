package Collections.stack;
import java.util.*;

public class stacks {
    public static void main(String[] args) {
        // Whenever you want to use Normal Queue use LinkedList
        // Whenever you want to use Stack use Stack class
        Stack<Integer> stack = new Stack<>();
        
        // Populating the stack 
        for (int i = 0; i < 10; i++) {
            stack.push(i * 2);
        }
        
        // Printing and emptying the stack - LIFO
        while (!stack.isEmpty()) {
            int val = stack.peek();
            stack.pop();
            System.out.print(val + ", ");
        }
    }
}
