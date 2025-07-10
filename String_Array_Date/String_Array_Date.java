package String_Array_Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class String_Array_Date {
    public static void main(String[] args) {

        // 1. Xu ly chuoi (String)
        String firstName = "Nguyen";
        String lastName = "An";
        String fullName = firstName.concat(" ").concat(lastName); // "Nguyen An"
        String greeting = "Xin chao, " + fullName;
        System.out.println("Loi chao: " + greeting);

        // 2. So sanh chuoi
        String x = "Hello";
        String y = "hello";
        System.out.println("So sanh tuyet doi equals: " + x.equals(y));
        System.out.println("So sanh khong phan biet hoa thuong: " + x.equalsIgnoreCase(y));
        System.out.println("So sanh theo bang ma unicode (compareTo): " + x.compareTo(y));

        // 3. Mang mot chieu
        String[] cities = {"Ha Noi", "Hue", "Da Nang", "Sai Gon"};
        System.out.println("Danh sach thanh pho: " + Arrays.toString(cities));

        // 4. Mang hai chieu (bang nhan 3x3)
        int[][] table = new int[3][3];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        System.out.println("Bang nhan 3x3:");
        for (int[] row : table) {
            System.out.println(Arrays.toString(row));
        }

        // 5. So sanh mang
        String[] arrA = {"Java", "C++", "Python"};
        String[] arrB = {"Java", "C++", "Python"};
        String[] arrC = {"Python", "C++", "Java"};
        System.out.println("arrA bang arrB: " + Arrays.equals(arrA, arrB));
        System.out.println("arrA bang arrC: " + Arrays.equals(arrA, arrC));

        // 6. Lam viec voi ngay/gio
        LocalDate now = LocalDate.now();
        LocalDate projectDeadline = LocalDate.of(now.getYear(), 8, 1);
        LocalDateTime dateTimeNow = LocalDateTime.now();

        System.out.println("Ngay hien tai: " + now);
        System.out.println("Han chot du an: " + projectDeadline);
        System.out.println("Thoi gian hien tai: " + dateTimeNow.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));

        if (now.isAfter(projectDeadline)) {
            System.out.println("Du an da tre han.");
        } else if (now.isEqual(projectDeadline)) {
            System.out.println("Hom nay la han chot.");
        } else {
            System.out.println("Du an van con thoi gian.");
        }
    }
}
