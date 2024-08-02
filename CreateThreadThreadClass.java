class Thread1 extends Thread{
    public Thread1(String threadName){
        super(threadName);
    }
    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Thread "+Thread.currentThread()+i);
        }
    }
}
public class CreateThreadThreadClass {
    public static void main(String[] args) {
        System.out.println("Main thread starting!");
        Thread1 thread1=new Thread1("thread1");
        thread1.start();
        System.out.println("Main thread exiting!");
    }
}
