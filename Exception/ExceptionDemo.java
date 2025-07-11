package Exception;

// Custom Exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ExceptionDemo {

    // Method that throws a custom exception
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("You must be at least 18 years old.");
        }
        System.out.println("Access granted. You are eligible.");
    }

    public static void main(String[] args) {
        // 1. Basic try-catch block
        try {
            int a = 10;
            int b = 0;
            int result = a / b;  // ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        }

        // 2. Try-catch-finally block
        try {
            String s = null;
            System.out.println(s.length());  // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Error: Null reference encountered.");
        } finally {
            System.out.println("This block always executes (finally).");
        }

        // 3. Handling custom exception
        try {
            checkAge(16);
        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        }

        System.out.println("Program continues after exception handling.");
    }
}
