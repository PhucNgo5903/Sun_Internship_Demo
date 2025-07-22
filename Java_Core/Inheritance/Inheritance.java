package Inheritance;

// Final class: khong the ke thua
final class VehicleConstants {
    public static final int MAX_SPEED = 180;
    public static final String BRAND = "OpenMotors";
}

// Lop truu tuong
abstract class Vehicle {
    String model;

    public Vehicle(String model) {
        this.model = model;
    }

    // Phuong thuc truu tuong
    public abstract void start();

    // Phuong thuc final: khong the override
    public final void info() {
        System.out.println("Model: " + model + " - Thuong hieu: " + VehicleConstants.BRAND);
    }
}

// Lop con: Car
class Car extends Vehicle {
    public Car(String model) {
        super(model);
    }

    @Override
    public void start() {
        System.out.println(model + " bat dau chay bang khoa tu dong.");
    }

    // Overload: nap chong
    public void start(String mode) {
        if (mode.equals("eco")) {
            System.out.println(model + " khoi dong o che do tiet kiem.");
        } else {
            System.out.println(model + " khoi dong o che do binh thuong.");
        }
    }
}

// Lop con: Bike
class Bike extends Vehicle {
    public Bike(String model) {
        super(model);
    }

    @Override
    public void start() {
        System.out.println(model + " khoi dong bang de chan.");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        System.out.println("Hang xe: " + VehicleConstants.BRAND);
        System.out.println("Toc do toi da: " + VehicleConstants.MAX_SPEED);

        // Da hinh
        Vehicle v1 = new Car("Toyota Camry");
        Vehicle v2 = new Bike("Yamaha Sirius");

        v1.start(); // goi phuong thuc override cua Car
        v2.start(); // goi phuong thuc override cua Bike

        // Ep kieu
        if (v1 instanceof Car) {
            Car c = (Car) v1;
            c.start("eco"); // goi overload
        }

        // Phuong thuc final
        v1.info();

        // Loi: khong the tao doi tuong abstract
        // Vehicle v = new Vehicle("Generic"); // Compilation error
    }
}
