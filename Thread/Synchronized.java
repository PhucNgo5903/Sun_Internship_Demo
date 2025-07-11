package Thread;

public class Synchronized {
     public static void main(String[] args) {
        GreetingBoard board = new GreetingBoard();

        Thread person1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                board.sayHello("Nguoi 1");
                sleep(500);
            }
        });

        Thread person2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                board.sayHello("Nguoi 2");
                sleep(500);
            }
        });

        person1.start();
        person2.start();
    }

    // sleep tiện dùng
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Lớp bảng thông báo
class GreetingBoard {
    // Phương thức synchronized để đảm bảo chỉ 1 người ghi 1 lúc
    public synchronized void sayHello(String name) {
        System.out.println(name + " dang ghi loi chao...");
        try {
            Thread.sleep(300); // mô phỏng thời gian viết
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " da ghi xong loi chao!");
    }
}
