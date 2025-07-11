abstract class Vehicle {
    protected String name;
    protected String color;

    public Vehicle(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public abstract void move();


    public void info() {
        System.out.println("Tên phương tiện: " + name);
        System.out.println("Màu sắc: " + color);
    }
}


class Car extends Vehicle {

    public Car(String name, String color) {
        super(name, color); 
    }

    @Override
    public void move() {
        System.out.println("Ô tô di chuyển bằng 4 bánh");
    }
}


class Bike extends Vehicle {

    public Bike(String name, String color) {
        super(name, color);
    }

    @Override
    public void move() {
        System.out.println("Xe đạp di chuyển bằng 2 bánh");
    }
}


class Horse extends Vehicle {

    public Horse(String name, String color) {
        super(name, color);
    }

    @Override
    public void move() {
        System.out.println("Ngựa chạy bằng 4 chân");
    }
}

public class InheritanceDemo {

    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", "Đỏ");
        Vehicle bike = new Bike("Martin", "Xanh");
        Vehicle horse = new Horse("Chiến mã", "Nâu");


        Vehicle[] vehicles = {car, bike, horse};

        for (Vehicle v : vehicles) {
            v.info();       
            v.move();       
            System.out.println();
        }
    }
}
