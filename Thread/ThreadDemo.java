package Thread;

// Thread class by extending Thread
class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " - Count: " + i);
            try {
                Thread.sleep(500); // sleep 0.5 second
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted.");
            }
        }
        System.out.println(name + " finished.");
    }
}

// Thread class by implementing Runnable
class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 10; i >= 6; i--) {
            System.out.println(name + " - Count: " + i);
            try {
                Thread.sleep(700); // sleep 0.7 second
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted.");
            }
        }
        System.out.println(name + " finished.");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        // Using Thread subclass
        MyThread thread1 = new MyThread("Thread-1");

        // Using Runnable interface
        Thread thread2 = new Thread(new MyRunnable("Thread-2"));

        System.out.println("Starting threads...");

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // wait for thread1 to finish
            thread2.join(); // wait for thread2 to finish
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("All threads finished.");
    }
}
