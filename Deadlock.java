public class Deadlock {
    public static void main(String[] args) {
        System.out.println("Main starts");
        String lock1 = "narendra";//lock object can be any valid java object
        String lock2 = "maurya";
        Thread thread1 = new Thread(()->{
            synchronized(lock1){
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized(lock2){
                    System.out.println("lock acquired");
                }
            }
        },"thread1");
        Thread thread2 = new Thread(()->{
            synchronized(lock2){
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized(lock1){
                    System.out.println("lock acquired");
                }
            }
        },"thread2");
        thread1.start();
        thread2.start();

    }    
}
