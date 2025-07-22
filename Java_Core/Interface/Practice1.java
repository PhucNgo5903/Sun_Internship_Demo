package Interface;

interface AreaCalculable {
    double calculateArea();
}

interface PerimeterCalculable {
    double calculatePerimeter();
}

interface Shape extends AreaCalculable, PerimeterCalculable {
}

abstract class AbstractShape implements Shape {
    protected void displayCalculation(String shapeName, double area, double perimeter) {
        System.out.println("=== " + shapeName + " ===");
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}

class Square extends AbstractShape {
    private final double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side must be positive");
        }
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
    
    public void display() {
        displayCalculation("Square", calculateArea(), calculatePerimeter());
    }
}

class Rectangle extends AbstractShape {
    private final double length;
    private final double width;

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive");
        }
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
    
    public void display() {
        displayCalculation("Rectangle", calculateArea(), calculatePerimeter());
    }
}

class ShapeCalculator {
    public void calculateAndDisplay(Shape shape, String shapeName) {
        System.out.println("=== " + shapeName + " ===");
        System.out.println("Area: " + shape.calculateArea());
        System.out.println("Perimeter: " + shape.calculatePerimeter());
    }
}

public class Practice1 {
    public static void main(String[] args) {
        ShapeCalculator calculator = new ShapeCalculator();
        
        Shape square = new Square(5);
        Shape rectangle = new Rectangle(4, 6);

        calculator.calculateAndDisplay(square, "Square");
        System.out.println();
        calculator.calculateAndDisplay(rectangle, "Rectangle");
    }
}