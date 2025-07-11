public class UserThread implements Runnable {
    private BankAccount account;
    private String threadName;

    public UserThread(BankAccount account, String threadName) {
        this.account = account;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 2; i++) {
            account.withdraw(threadName, 600);
        }
    }
}
