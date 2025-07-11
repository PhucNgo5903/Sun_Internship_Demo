public class BankSystem {

    public static void main(String[] args) {
        BankAccount sharedAccount = new BankAccount();

        Thread user1 = new Thread(new UserThread(sharedAccount, "Người A"));
        Thread user2 = new Thread(new UserThread(sharedAccount, "Người B"));

        System.out.println("=== BẮT ĐẦU RÚT TIỀN ===");
        user1.start();
        user2.start();

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nGiao dịch kết thúc. Số dư còn lại: " + sharedAccount.getBalance() + "đ");
    }
}
