import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StudentManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter the number of students: ");
        int n = Integer.parseInt(scanner.nextLine());

        String[] names = new String[n];
        double[] scores = new double[n];
        LocalDate[] birthDates = new LocalDate[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Enter information for student " + (i + 1) + " ---");

            System.out.print("Name: ");
            names[i] = scanner.nextLine();

            System.out.print("Score: ");
            scores[i] = Double.parseDouble(scanner.nextLine());

            System.out.print("Date of Birth (dd/MM/yyyy): ");
            String dateStr = scanner.nextLine();
            birthDates[i] = LocalDate.parse(dateStr, formatter);
        }

        System.out.println("\n===== STUDENT LIST =====");
        for (int i = 0; i < n; i++) {
            String upperName = names[i].toUpperCase(); // xử lý String
            int age = Period.between(birthDates[i], LocalDate.now()).getYears(); // tính tuổi

            System.out.println("Student " + (i + 1) + ":");
            System.out.println("  Name        : " + upperName);
            System.out.println("  Age         : " + age);
            System.out.println("  Score      : " + scores[i]);
            System.out.println("  Date of Birth: " + birthDates[i].format(formatter));
        }

        // Calculate average score
        double sum = 0;
        for (double score : scores) {
            sum += score;
        }

        double avg = sum / n;
        System.out.printf("\nAverage score of the class: %.2f\n", avg);

        scanner.close();
    }
}
