package Inheritance;

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

// Subclass of Animal, demonstrating overriding and super keyword
class Dog extends Animal {
    public Dog(String name) {
        super(name); // call superclass constructor
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
}

// Another subclass
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

        // Polymorphism: Animal reference to Dog and Cat
        Animal a1 = new Dog("Dog1");
        Animal a2 = new Cat("Cat1");

        a1.makeSound(); // Woof!
        a2.makeSound(); // Meow!

        // Casting: from Animal to Dog
        if (a1 instanceof Dog) {
            Dog d = (Dog) a1;
            d.makeSound("happy"); // Overloaded method
        }

        // Final method
        a1.info();

        // Abstract class cannot be instantiated
        // Animal animal = new Animal("Test"); // Compilation error
    }
}
