package JavaCore_Practice;

interface Displayable {
    void displayInfo();
}

interface Dimensional {
    void displayDimensions();
}

abstract class Shape implements Dimensional {
    protected final double width;
    protected final double height;

    protected Shape(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Dimensions must be positive");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public void displayDimensions() {
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
    }
}

interface AreaCalculable {
    double getArea();
}

interface PerimeterCalculable {
    double getPerimeter();
}

class Rectangle extends Shape implements Displayable, AreaCalculable, PerimeterCalculable {
    public Rectangle(double width, double height) {
        super(width, height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Rectangle ===");
        displayDimensions();
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println();
    }
}

class Circle extends Shape implements Displayable, AreaCalculable {
    private final double radius;

    public Circle(double radius) {
        super(radius, radius);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== Circle ===");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
        System.out.println();
    }
}

class ShapeFactory {
    public static Rectangle createRectangle(double width, double height) {
        return new Rectangle(width, height);
    }
    
    public static Circle createCircle(double radius) {
        return new Circle(radius);
    }
}

public class Practice1 {
    public static void main(String[] args) {
        Shape shape = new Rectangle(5, 10);
        System.out.println("=== Shape ===");
        shape.displayDimensions();
        System.out.println();

        Rectangle rectangle = ShapeFactory.createRectangle(4, 6);
        rectangle.displayInfo();

        Circle circle = ShapeFactory.createCircle(3);
        circle.displayInfo();
    }
}
