package Collection_Generics_Lambda;

import java.util.*;
import java.util.stream.Collectors;

interface Printer<T> {
    void printAll(List<T> items);
}

class ConsolePrinter<T> implements Printer<T> {
    @Override
    public void printAll(List<T> items) {
        items.forEach(System.out::println);
    }
}

interface DataProcessor<T> {
    List<T> process(List<T> data);
}

class SortProcessor implements DataProcessor<String> {
    @Override
    public List<String> process(List<String> data) {
        return data.stream().sorted().collect(Collectors.toList());
    }
}

class UppercaseProcessor implements DataProcessor<String> {
    @Override
    public List<String> process(List<String> data) {
        return data.stream()
                   .map(String::toUpperCase)
                   .collect(Collectors.toList());
    }
}

class FilterProcessor implements DataProcessor<String> {
    private final String prefix;
    
    public FilterProcessor(String prefix) {
        this.prefix = prefix;
    }
    
    @Override
    public List<String> process(List<String> data) {
        return data.stream()
                   .filter(item -> item.startsWith(prefix))
                   .collect(Collectors.toList());
    }
}

public class CollectionDemo {
    private final Printer<String> printer;
    
    public CollectionDemo(Printer<String> printer) {
        this.printer = printer;
    }
    
    public void demonstrateCollections() {
        List<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Banana", "Mango", "Orange"));
        
        System.out.println("Original List:");
        System.out.println(fruits);
        
        SortProcessor sortProcessor = new SortProcessor();
        List<String> sortedFruits = sortProcessor.process(fruits);
        System.out.println("Sorted List:");
        System.out.println(sortedFruits);
    }
    
    public void demonstrateGenerics() {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Mango", "Orange");
        System.out.println("\nGenericPrinter Output:");
        printer.printAll(fruits);
    }
    
    public void demonstrateLambdaOperations() {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Mango", "Orange");
        
        FilterProcessor filterProcessor = new FilterProcessor("A");
        List<String> filteredFruits = filterProcessor.process(fruits);
        System.out.println("\nFruits that start with 'A':");
        printer.printAll(filteredFruits);
        
        UppercaseProcessor uppercaseProcessor = new UppercaseProcessor();
        List<String> uppercaseFruits = uppercaseProcessor.process(fruits);
        System.out.println("\nConvert all fruits to uppercase:");
        printer.printAll(uppercaseFruits);
    }
    
    public static void main(String[] args) {
        CollectionDemo demo = new CollectionDemo(new ConsolePrinter<>());
        demo.demonstrateCollections();
        demo.demonstrateGenerics();
        demo.demonstrateLambdaOperations();
    }
}
