public class BankAccount {
    private int balance = 1000;

    public synchronized void withdraw(String threadName, int amount) {
        System.out.println(threadName + " yêu cầu rút " + amount + "đ...");

        if (balance >= amount) {
            System.out.println(threadName + " đang rút tiền...");
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Lỗi sleep");
            }
            balance -= amount;
            System.out.println(threadName + " đã rút xong. Số dư còn lại: " + balance + "đ");
        } else {
            System.out.println(threadName + " không đủ tiền! Số dư: " + balance + "đ");
        }
    }

    public int getBalance() {
        return balance;
    }
}
