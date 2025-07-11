package Thread;

public class ThreadDemo {
    public static void main(String[] args) {
        Runnable person1 = () -> {
            for (int i = 0; i < 5; i++) {
                sayHello("Nguoi 1");
                sleep(1000);
            }
        };

        Runnable person2 = () -> {
            for (int i = 0; i < 5; i++) {
                sayHello("Nguoi 2");
                sleep(1000);
            }
        };

        Thread t1 = new Thread(person1);
        Thread t2 = new Thread(person2);

        t1.start();
        t2.start();
    }

    // KHÔNG synchronized → dễ bị chồng lẫn
    public static void sayHello(String name) {
        System.out.println(name + " dang ghi loi chao...");
        sleep(500); // mô phỏng đang ghi
        System.out.println(name + " da ghi xong loi chao!");
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
