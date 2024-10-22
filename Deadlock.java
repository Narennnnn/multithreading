public class Deadlock {
    public static void main(String[] args) {
        System.out.println("Main starts");

        // Two lock objects
        String lock1 = "narendra";
        String lock2 = "maurya";

        // First thread
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) { // Thread 1 locks lock1 first
                System.out.println("Thread 1: Holding lock1...");
                try { Thread.sleep(100); } catch (Exception e) {} // Simulate some work
                System.out.println("Thread 1: Waiting for lock2...");
                synchronized (lock2) { // Tries to lock lock2
                    System.out.println("Thread 1: Acquired lock2!");
                }
            }
        });

        // Second thread
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) { // Thread 2 locks lock2 first
                System.out.println("Thread 2: Holding lock2...");
                try { Thread.sleep(100); } catch (Exception e) {} // Simulate some work
                System.out.println("Thread 2: Waiting for lock1...");
                synchronized (lock1) { // Tries to lock lock1
                    System.out.println("Thread 2: Acquired lock1!");
                }
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();
    }
}


/*  Serialise lock acquire to avoid deadlock
public class Deadlock {
    public static void main(String[] args) {
        System.out.println("Main starts");

        // Two lock objects
        String lock1 = "narendra";
        String lock2 = "maurya";

        // First thread
        Thread thread1 = new Thread(() -> {
            // Always lock lock1 first, then lock2
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock1...");
                try { Thread.sleep(100); } catch (Exception e) {} // Simulate some work
                System.out.println("Thread 1: Waiting for lock2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired lock2!");
                }
            }
        });

        // Second thread
        Thread thread2 = new Thread(() -> {
            // Always lock lock1 first, then lock2
            synchronized (lock1) { // Changed the order here
                System.out.println("Thread 2: Holding lock1...");
                try { Thread.sleep(100); } catch (Exception e) {} // Simulate some work
                System.out.println("Thread 2: Waiting for lock2...");
                synchronized (lock2) {
                    System.out.println("Thread 2: Acquired lock2!");
                }
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
*/