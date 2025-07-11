package Interface;

// Interface định nghĩa hành vi tính diện tích và chu vi
interface Shape {
    double calculateArea();
    double calculatePerimeter();
}

// Lớp Square implements giao diện Shape
class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}

// Lớp Rectangle implements giao diện Shape
class Rectangle implements Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Lớp main để chạy chương trình
public class Practice1{
    public static void main(String[] args) {
        Shape square = new Square(5);
        Shape rectangle = new Rectangle(4, 6);

        System.out.println("=== Square ===");
        System.out.println("Area: " + square.calculateArea());
        System.out.println("Perimeter: " + square.calculatePerimeter());

        System.out.println("\n=== Rectangle ===");
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
    }
}