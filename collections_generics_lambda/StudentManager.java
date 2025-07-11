import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentManager {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("An", 9.0));
        students.add(new Student("Bình", 6.5));
        students.add(new Student("Chi", 8.5));
        students.add(new Student("Dũng", 4.8));

        System.out.println(" DANH SÁCH HỌC SINH:");
        students.forEach(System.out::println);

        System.out.println("\n HỌC SINH GIỎI (>=8 điểm):");
        Predicate<Student> isExcellent = s -> s.getScore() >= 8;
        students.stream()
                .filter(isExcellent)
                .forEach(System.out::println);

        System.out.println("\n SẮP XẾP THEO TÊN:");
        students.sort((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
        students.forEach(System.out::println);

        double avg = students.stream()
                .mapToDouble(Student::getScore)
                .average()
                .orElse(0);

        System.out.printf("\n Điểm trung bình toàn lớp: %.2f\n", avg);
    }
}
