package HandleExceptions;
import java.util.Scanner;

// Custom Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class HandleExceptions{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhap tuoi cua ban: ");
            int age = scanner.nextInt();

            checkAge(age);  // Gọi hàm có thể ném exception

            System.out.println("Tuoi hop le: " + age);

        } catch (InvalidAgeException e) {
            System.out.println("Loi: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Dùng `throws` để báo rằng hàm này có thể ném ra InvalidAgeException
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 0) {
            // Dùng `throw` để phát sinh lỗi cụ thể
            throw new InvalidAgeException("Tuoi khong the < 0!");
        }
    }
}
