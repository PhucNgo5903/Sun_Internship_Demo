public interface Runnable {
    void run();

    default void stop() {
        System.out.println("Đã dừng chạy.");
    }
}
