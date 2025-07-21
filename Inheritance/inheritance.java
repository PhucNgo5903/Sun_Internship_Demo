package Inheritance;

// Interface with abstract, default, and static methods
interface CanRun {
    void run(); // abstract method

    // Default method (Java 8+)
    default void jump() {
        System.out.println("This animal can jump.");
    }

    // Static method (Java 8+)
    static void showRunningGuide() {
        System.out.println("Running guide: Warm-up, then run steadily.");
    }
}

// Final class: cannot be extended
final class Constants {
    public static final double PI = 3.14159;
    public static final String SCHOOL_NAME = "Sun Java Academy";
}

// Abstract class and method
abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    // Abstract method (must be overridden)
    public abstract void makeSound();

    // Final method (cannot be overridden)
    public final void info() {
        System.out.println("This is an animal named " + name);
    }
}

// Subclass Dog implements interface CanRun
class Dog extends Animal implements CanRun {
    public Dog(String name) {
        super(name);
    }

    // Overriding method
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }

    // Overloading method
    public void makeSound(String mood) {
        if (mood.equals("happy")) {
            System.out.println(name + " is happy, says: Woof woof!");
        } else {
            System.out.println(name + " growls...");
        }
    }

    // Implement run() method from CanRun
    @Override
    public void run() {
        System.out.println(name + " is running fast!");
    }
}

// Another subclass Cat
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

public class inheritance {
    public static void main(String[] args) {
        System.out.println("Final constant - School: " + Constants.SCHOOL_NAME);
        System.out.println("Final constant - PI: " + Constants.PI);

        // Polymorphism
        Animal a1 = new Dog("Dog1");
        Animal a2 = new Cat("Cat1");

        a1.makeSound();
        a2.makeSound();

        // Casting
        if (a1 instanceof Dog) {
            Dog d = (Dog) a1;
            d.makeSound("happy");  // Overloaded
            d.run();               // Interface method
            d.jump();              // Default method from interface
        }

        // Static method from interface
        CanRun.showRunningGuide();

        // Final method
        a1.info();
    }
}
