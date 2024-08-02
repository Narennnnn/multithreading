class Stack {
    private int[] array;
    private int stackTop;
    Object lock;
    public Stack(int capacity){
        array = new int[capacity];
        stackTop = -1;
        lock = new Object();
    }
    public boolean push(int element){
        synchronized(lock){
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
    }
    public int pop(){
        synchronized(lock){
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
    }
    public boolean isEmpty(){
        return stackTop<0;
    }
    public boolean isFull(){
        return stackTop >= array.length-1;
    }
}
public class SynchronisedBlock{
    public static void main(String[] args) {
        System.out.println("main is starting");
        Stack stack=new Stack(5);
        new Thread(()->{
            int counter=0;
            while(++counter<10){
                System.out.println("Pushed "+stack.push(100));
            }
        },"Pusher").start();

        new Thread(()->{
            int counter=0;
            while(++counter<10){
                System.out.println("Popped  "+stack.pop());
            }
        },"Popper").start();   
        System.out.println("main is exiting");  
    }
}