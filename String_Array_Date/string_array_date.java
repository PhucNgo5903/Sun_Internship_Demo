    package String_Array_Date;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.time.format.DateTimeFormatter;
    import java.util.Arrays;

    public class string_array_date {
        public static void main(String[] args) {

            // 1. Create, Join, and Append String
            String str1 = "Hello";
            String str2 = "World";
            String joined = String.join(" ", str1, str2);  // "Hello World"
            StringBuilder sb = new StringBuilder(joined);
            sb.append("! Welcome to Java.");               // Append string

            System.out.println("Joined & Appended String: " + sb.toString());

            // 2. String Comparison
            String a = "java";
            String b = "Java";
            System.out.println("Equals: " + a.equals(b));                 // false
            System.out.println("Equals Ignore Case: " + a.equalsIgnoreCase(b)); // true
            System.out.println("CompareTo: " + a.compareTo(b));           // j : 106, J: 74 => return 106-74=32

            // 3. Single Dimensional Array
            int[] scores = {85, 90, 78};
            System.out.println("Single Dimensional Array: " + Arrays.toString(scores));

            // 4. Two Dimensional Array
            int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
            };
            System.out.println("Two Dimensional Array:");
            for (int[] row : matrix) {
                System.out.println(Arrays.toString(row));
            }

            // 5. Compare Two Arrays
            int[] arr1 = {1, 2, 3};
            int[] arr2 = {1, 2, 3};
            int[] arr3 = {3, 2, 1};
            System.out.println("arr1 equals arr2: " + Arrays.equals(arr1, arr2)); // true
            System.out.println("arr1 equals arr3: " + Arrays.equals(arr1, arr3)); // false

            // 6. Working with Date/Time APIs
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
