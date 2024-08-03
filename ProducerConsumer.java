import java.util.*;
class BlockingQueue {
    private Queue<Integer> q;
    private int capacity;
    public BlockingQueue(int cap){
        capacity=cap;
        q=new LinkedList<>();
    }
    public boolean add(int item){
        synchronized(q){
            while(q.size() == capacity){
                try{
                    q.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            q.add(item);
            q.notifyAll();
            return true;
        }
    }
    public int remove(){
        synchronized(q){
            while(q.size() == 0 ){
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // do something
            int element=q.poll();
            q.notifyAll();
            return element;
        }
    }
}
public class ProducerConsumer{
    public static void main(String[] args) {
        System.out.println("Main starts");
        BlockingQueue queue = new BlockingQueue(5);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.add(i);
                System.out.println("Produced: " + i);
                try {
                    Thread.sleep(100); // Simulate some delay in producing
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                int item = queue.remove();
                System.out.println("Consumed: " + item);
                try {
                    Thread.sleep(150); // Simulate some delay in consuming
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main ends");
    }
}