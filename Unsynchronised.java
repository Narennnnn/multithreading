class Stack {
    private int[] array;
    private int stackTop;
    public Stack(int capacity){
        array = new int[capacity];
        stackTop = -1;
    }
    public boolean push(int element){
        if(isFull()){
            return false;
        }
        ++ stackTop;
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        array[stackTop]=element;
        return true;
    }
    public int pop(){
        if(isEmpty()){
            return Integer.MIN_VALUE;//random value
        }
        int obj= array[stackTop];
        array[stackTop]=Integer.MIN_VALUE;//set to random value
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        stackTop--;
        return obj;
    }
    public boolean isEmpty(){
        return stackTop<0;
    }
    public boolean isFull(){
        return stackTop >= array.length-1;
    }
}
public class Unsynchronised{
    public static void main(String[] args) {
        System.out.println("main is starting");
        Stack stack=new Stack(5);
        new Thread(()->{
            int counter=0;
            while(++counter<10){
                System.out.println("Pushed"+stack.push(100));
            }
        },"Pusher").start();

        new Thread(()->{
            int counter=0;
            while(++counter<10){
                System.out.println("Popped"+stack.pop());
            }
        },"Popper").start();   
        System.out.println("main is exiting");  
        // race around condition may arise where push and pop both try to access resources of Stack class, thus may cause IndexOutOfBound Exception as well as in case of push 
        // it must be sleeping but on the same time pop() must be decrementing stackTop to less than 0
        // we need synchronised approach so that only operation takes place in synchronised manner
        /*
         ➜  multithreading git:(main) java Unsynchronised      
        main is starting
        main is exiting
        Pushedtrue
        Popped0
        Pushedtrue
        Popped100
        Popped100
        Popped-2147483648
        Popped-2147483648
        Popped-2147483648
        Popped-2147483648
        Popped-2147483648
        Popped-2147483648
        Exception in thread "Pusher" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 5
        at Stack.push(Unsynchronised.java:18)
        at Unsynchronised.lambda$main$0(Unsynchronised.java:49)
        at java.base/java.lang.Thread.run(Thread.java:1570)
         */  
    }
}