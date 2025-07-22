//Phân biệt constructor và method
class Person {
    String name;
    int age;

    // Constructor - tên trùng class, không có kiểu trả về
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Constructor called: Object created.");
    }

    // Method - có tên bất kỳ và có kiểu trả về (ở đây là void)
    public void introduce() {
        System.out.println("Hi, I'm " + name + " and I'm " + age + " years old.");
    }
}
public class JavaIntroduction {
    public static void main(String[] args) {
        // Gọi constructor (tự động gọi khi dùng từ khóa new)
        Person p = new Person("Duc", 22); 
        
        // Gọi method bằng đối tượng
        p.introduce(); // Đây là method
    }
}
