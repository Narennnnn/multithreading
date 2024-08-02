class Thread2 implements Runnable{
    @Override
    public void run(){
        try{
            Thread.sleep(1000);
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread()+" "+i);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
public class CreateThreadRunnableInterface {
    public static void main(String[] args) {
        Thread thread = new Thread(new Thread2());
        thread.start();
        System.out.println("Main thread came!");
    }
}
