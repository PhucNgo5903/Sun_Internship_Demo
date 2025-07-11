package JavaCore_Practice;

// Base class Shape with width and height
class Shape {
    protected double width;
    protected double height;

    public Shape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void displayDimensions() {
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
    }
}

// Subclass Rectangle inherits from Shape
class Rectangle extends Shape {

    public Rectangle(double width, double height) {
        super(width, height);
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public void displayInfo() {
        System.out.println("=== Rectangle ===");
        displayDimensions();
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println();
    }
}

// Subclass Circle inherits from Shape
class Circle extends Shape {

    public Circle(double radius) {
        super(radius, radius); // Use width as radius
    }

    public double getArea() {
        return Math.PI * width * width; // πr²
    }

    public double getCircumference() {
        return 2 * Math.PI * width; // 2πr or d*π
    }

    public void displayInfo() {
        System.out.println("=== Circle ===");
        System.out.println("Radius: " + width);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
        System.out.println();
    }
}

// Main class
public class Practice1 {
    public static void main(String[] args) {
        // Create Shape (can be abstract in real-world scenarios)
        Shape shape = new Shape(5, 10);
        System.out.println("=== Shape ===");
        shape.displayDimensions();
        System.out.println();

        // Create Rectangle
        Rectangle rectangle = new Rectangle(4, 6);
        rectangle.displayInfo();

        // Create Circle
        Circle circle = new Circle(3);
        circle.displayInfo();
    }
}
