public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Số tiền phải lớn hơn 0.");
        }

        if (amount > balance) {
            throw new InvalidAmountException("Số dư không đủ để rút.");
        }

        balance -= amount;
        System.out.println("Rút thành công " + amount + "đ. Số dư còn lại: " + balance + "đ");
    }
}
