package String_Array_Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StringArrayDate {
    public static void main(String[] args) {
        demonstrateStringOperations();
        demonstrateArrayOperations();
        demonstrateDateTimeOperations();
    }

    private static void demonstrateStringOperations() {
        String str1 = "Hello";
        String str2 = "World";
        String joined = String.join(" ", str1, str2);
        StringBuilder sb = new StringBuilder(joined);
        sb.append("! Welcome to Java.");

        System.out.println("Joined & Appended String: " + sb.toString());

        String a = "java";
        String b = "Java";
        System.out.println("Equals: " + a.equals(b));
        System.out.println("Equals Ignore Case: " + a.equalsIgnoreCase(b));
        System.out.println("CompareTo: " + a.compareTo(b));
    }

    private static void demonstrateArrayOperations() {
        int[] scores = {85, 90, 78};
        System.out.println("Single Dimensional Array: " + Arrays.toString(scores));

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("Two Dimensional Array:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {3, 2, 1};
        System.out.println("arr1 equals arr2: " + Arrays.equals(arr1, arr2));
        System.out.println("arr1 equals arr3: " + Arrays.equals(arr1, arr3));
    }

    private static void demonstrateDateTimeOperations() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(today.getYear(), 7, 9);
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Today: " + today);
        System.out.println("Birthday: " + birthday);
        System.out.println("Current DateTime: " + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        if (today.isAfter(birthday)) {
            System.out.println("Today is after your birthday.");
        } else if (today.isEqual(birthday)) {
            System.out.println("Happy birthday!");
        } else {
            System.out.println("Today is before your birthday");
        }
    }
}
