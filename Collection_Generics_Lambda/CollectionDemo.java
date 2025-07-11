package Collection_Generics_Lambda;

import java.util.*;

// A generic class to store and print any type of list
class GenericPrinter<T> {
    private List<T> items;

    public GenericPrinter(List<T> items) {
        this.items = items;
    }

    public void printAll() {
        items.forEach(item -> System.out.println(item));
    }
}

public class CollectionDemo {
    public static void main(String[] args) {
        // === 1. Working with Collections ===
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");

        System.out.println("Original List:");
        System.out.println(fruits);

        // Sort using Collections
        Collections.sort(fruits);
        System.out.println("Sorted List:");
        System.out.println(fruits);

        // === 2. Working with Generics ===
        System.out.println("\nGenericPrinter Output:");
        GenericPrinter<String> fruitPrinter = new GenericPrinter<>(fruits);
        fruitPrinter.printAll();

        // === 3. Using Lambda Expression ===
        System.out.println("\nUsing Lambda to filter and print fruits that start with 'A':");
        fruits.stream()
              .filter(fruit -> fruit.startsWith("A"))
              .forEach(fruit -> System.out.println(fruit));

        // Another lambda example: convert to uppercase
        System.out.println("\nConvert all fruits to uppercase using Lambda:");
        fruits.stream()
              .map(fruit -> fruit.toUpperCase())
              .forEach(fruit -> System.out.println(fruit));
    }
}
