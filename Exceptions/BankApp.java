import java.util.InputMismatchException;
import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(1000000);

        System.out.println("Xin chào! Tài khoản hiện có: " + account.getBalance() + "đ");

        try {
            System.out.print("Nhập số tiền bạn muốn rút: ");
            int amount = scanner.nextInt();

            account.withdraw(amount); 

        } catch (InvalidAmountException e) {
            System.out.println("Lỗi: " + e.getMessage());

        } catch (InputMismatchException e) {
            System.out.println("Lỗi: Bạn phải nhập một số nguyên!");

        } catch (Exception e) {
            System.out.println("Lỗi không xác định: " + e.getMessage());

        } finally {
            System.out.println("Giao dịch kết thúc. Số dư: " + account.getBalance() + "đ");
            scanner.close();
        }
    }
}
