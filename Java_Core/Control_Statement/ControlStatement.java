package Control_Statement;
import java.util.Scanner;

public class ControlStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your score (0 - 100): ");
        int score = scanner.nextInt();
        scanner.close();

        classifyScore(score);
        reward(score);
        printScoreMilestones(score);
    }

    private static void classifyScore(int score) {
        if (score >= 90) {
            System.out.println("Grade: Excellent");
        } else if (score >= 80) {
            System.out.println("Grade: Good");
        } else if (score >= 70) {
            System.out.println("Grade: Fair");
        } else if (score >= 50) {
            System.out.println("Grade: Average");
        } else {
            System.out.println("Grade: Poor");
        }
    }

    private static void reward(int score) {
        switch (score / 10) {
            case 10:
            case 9:
                System.out.println("Reward: Full scholarship");
                break;
            case 8:
                System.out.println("Reward: Partial scholarship");
                break;
            case 7:
                System.out.println("Reward: Certificate of merit");
                break;
            default:
                System.out.println("No reward");
        }
    }

    private static void printScoreMilestones(int score) {
        System.out.println("Score milestones:");
        for (int i = 0; i <= score; i += 20) {
            System.out.println("Milestone: " + i);
        }
    }
}
