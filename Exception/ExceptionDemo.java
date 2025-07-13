package Exception;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

interface AgeValidator {
    void validateAge(int age) throws InvalidAgeException;
}

class AdultAgeValidator implements AgeValidator {
    private static final int MINIMUM_AGE = 18;
    
    @Override
    public void validateAge(int age) throws InvalidAgeException {
        if (age < MINIMUM_AGE) {
            throw new InvalidAgeException("You must be at least " + MINIMUM_AGE + " years old.");
        }
        System.out.println("Access granted. You are eligible.");
    }
}

interface ExceptionHandler {
    void handleException(Exception e);
}

class ConsoleExceptionHandler implements ExceptionHandler {
    @Override
    public void handleException(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}

public class ExceptionDemo {
    private final AgeValidator ageValidator;
    private final ExceptionHandler exceptionHandler;
    
    public ExceptionDemo(AgeValidator ageValidator, ExceptionHandler exceptionHandler) {
        this.ageValidator = ageValidator;
        this.exceptionHandler = exceptionHandler;
    }
    
    public void demonstrateArithmeticException() {
        try {
            int a = 10;
            int b = 0;
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            exceptionHandler.handleException(new Exception("Division by zero is not allowed."));
        }
    }
    
    @SuppressWarnings("null")
    public void demonstrateNullPointerException() {
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            exceptionHandler.handleException(new Exception("Null reference encountered."));
        } finally {
            System.out.println("This block always executes (finally).");
        }
    }
    
    public void demonstrateCustomException(int age) {
        try {
            ageValidator.validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        ExceptionDemo demo = new ExceptionDemo(
            new AdultAgeValidator(),
            new ConsoleExceptionHandler()
        );
        
        demo.demonstrateArithmeticException();
        demo.demonstrateNullPointerException();
        demo.demonstrateCustomException(16);
        
        System.out.println("Program continues after exception handling.");
    }
}
