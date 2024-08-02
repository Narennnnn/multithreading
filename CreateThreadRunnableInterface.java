
public class CreateThreadRunnableInterface {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{//lambda function such that task is not null will call run method of Thread class
            for(int i=0;i<10;i++){
                System.out.println("Thread "+Thread.currentThread()+" "+i);
            }
        });//
        thread.start();
        System.out.println("Main thread came!");
    }
}
