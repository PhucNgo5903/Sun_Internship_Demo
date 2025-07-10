package Inheritance;

final class Constants {
    public static final double PI = 3.14159;
    public static final String SCHOOL_NAME = "Sun Java Academy";
}

abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public final void info() {
        System.out.println("This is an animal named " + name);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }

    public void makeSound(String mood) {
        if (mood.equals("happy")) {
            System.out.println(name + " is happy, says: Woof woof!");
        } else {
            System.out.println(name + " growls...");
        }
    }
}

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

        Animal a1 = new Dog("Dog1");
        Animal a2 = new Cat("Cat1");

        a1.makeSound();
        a2.makeSound();

        if (a1 instanceof Dog) {
            Dog d = (Dog) a1;
            d.makeSound("happy");
        }

        a1.info();
    }
}
