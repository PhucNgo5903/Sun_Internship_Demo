package Thread;

interface TaskRunner {
    void execute();
}

abstract class BaseTask implements TaskRunner {
    protected final String taskName;
    
    protected BaseTask(String taskName) {
        this.taskName = taskName;
    }
    
    protected void handleInterruption() {
        System.out.println(taskName + " was interrupted.");
    }
    
    protected void announceCompletion() {
        System.out.println(taskName + " finished.");
    }
}

class CountUpTask extends BaseTask implements Runnable {
    private static final int SLEEP_DURATION = 500;
    
    public CountUpTask(String taskName) {
        super(taskName);
    }
    
    @Override
    public void run() {
        execute();
    }
    
    @Override
    public void execute() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " - Count: " + i);
            try {
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                handleInterruption();
                Thread.currentThread().interrupt();
                return;
            }
        }
        announceCompletion();
    }
}

class CountDownTask extends BaseTask implements Runnable {
    private static final int SLEEP_DURATION = 700;
    
    public CountDownTask(String taskName) {
        super(taskName);
    }
    
    @Override
    public void run() {
        execute();
    }
    
    @Override
    public void execute() {
        for (int i = 10; i >= 6; i--) {
            System.out.println(taskName + " - Count: " + i);
            try {
                Thread.sleep(SLEEP_DURATION);
            } catch (InterruptedException e) {
                handleInterruption();
                Thread.currentThread().interrupt();
                return;
            }
        }
        announceCompletion();
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new CountUpTask("Thread-1"));
        Thread thread2 = new Thread(new CountDownTask("Thread-2"));

        System.out.println("Starting threads...");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
            Thread.currentThread().interrupt();
        }

        System.out.println("All threads finished.");
    }
}
