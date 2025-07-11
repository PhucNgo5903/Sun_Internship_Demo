import java.util.Scanner;

public class ScoreManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean keepRunning = true;

        while (keepRunning) {
            System.out.print("Please enter the number of tests: ");
            int n = scanner.nextInt();

            // Kiểm tra n hợp lệ
            if (n <= 0) {
                System.out.println("The number must be greater than 0.");
                continue;
            }

            int[] scores = new int[n];

            // Nhập điểm cho học sinh
            for (int i = 0; i < n; i++) {
                while (true) {
                    System.out.print("Enter the score for test " + (i + 1) + ": ");
                    int score = scanner.nextInt();

                    if (score >= 0 && score <= 100) {
                        scores[i] = score;
                        break; 
                    } else {
                        System.out.println("The score must be between 0 and 100. Please enter again.");
                    }
                }
            }

            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            double average = (double) sum / n;

            System.out.println("\n===== Result =====");
            System.out.println("List of scores:");
            for (int i = 0; i < n; i++) {
                System.out.println("Test " + (i + 1) + ": " + scores[i]);
            }
            System.out.println("Average score: " + average);

            System.out.print("Classification: ");
            if (average >= 90) {
                System.out.println("A");
            } else if (average >= 70) {
                System.out.println("B+");
            } else if (average >= 50) {
                System.out.println("B");
            } else {
                System.out.println("C");
            }

            System.out.print("\nDo you want to continue? (y/n): ");
            char choice = scanner.next().charAt(0);

            switch (choice) {
                case 'y':
                case 'Y':
                    break; 
                case 'n':
                case 'N':
                    System.out.println("Ending the program.");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Exiting.");
                    return; 
            }

            System.out.println(); 
        }

        scanner.close();
    }
}
