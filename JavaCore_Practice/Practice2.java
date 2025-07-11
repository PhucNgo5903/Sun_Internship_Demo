package JavaCore_Practice;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

// Abstract base class for goods
abstract class Product {
    protected String code;
    protected String name;
    protected int quantity;
    protected double unitPrice;

    public Product(String code, String name, int quantity, double unitPrice) {
        this.code = code;
        this.name = name;
        this.quantity = quantity >= 0 ? quantity : 0;
        this.unitPrice = unitPrice;
    }

    public abstract double calculateVAT();
    public abstract void evaluateConsumption();

    public String getCode() {
        return code;
    }

    public void display() {
        System.out.println("Code: " + code + " | Name: " + name + " | Quantity: " + quantity + " | Unit Price: " + unitPrice);
    }
}

// Food subclass
class Food extends Product {
    private LocalDate manufactureDate;
    private LocalDate expirationDate;
    private String supplier;

    public Food(String code, String name, int quantity, double unitPrice,
                LocalDate mfgDate, LocalDate expDate, String supplier) {
        super(code, name, quantity, unitPrice);
        if (expDate.isBefore(mfgDate)) {
            throw new IllegalArgumentException("Expiration date must be after manufacture date.");
        }
        this.manufactureDate = mfgDate;
        this.expirationDate = expDate;
        this.supplier = supplier;
    }

    @Override
    public double calculateVAT() {
        return unitPrice * 0.05;
    }

    @Override
    public void evaluateConsumption() {
        if (quantity > 0 && expirationDate.isBefore(LocalDate.now())) {
            System.out.println("=> Hard to sell (expired)");
        } else {
            System.out.println("=> No evaluation");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Manufacture: " + manufactureDate + " | Expiration: " + expirationDate + " | Supplier: " + supplier);
    }
}

// Electronics subclass
class Electronics extends Product {
    private int warrantyMonths;
    private double capacityKW;

    public Electronics(String code, String name, int quantity, double unitPrice,
                       int warrantyMonths, double capacityKW) {
        super(code, name, quantity, unitPrice);
        this.warrantyMonths = Math.max(0, warrantyMonths);
        this.capacityKW = Math.max(0, capacityKW);
    }

    @Override
    public double calculateVAT() {
        return unitPrice * 0.10;
    }

    @Override
    public void evaluateConsumption() {
        if (quantity < 3) {
            System.out.println("=> Considered sold (low stock)");
        } else {
            System.out.println("=> No evaluation");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Warranty: " + warrantyMonths + " months | Capacity: " + capacityKW + " KW");
    }
}

// Crockery subclass
class Crockery extends Product {
    private String manufacturer;
    private LocalDate dateArrival;

    public Crockery(String code, String name, int quantity, double unitPrice,
                    String manufacturer, LocalDate dateArrival) {
        super(code, name, quantity, unitPrice);
        this.manufacturer = manufacturer;
        this.dateArrival = dateArrival;
    }

    @Override
    public double calculateVAT() {
        return unitPrice * 0.10;
    }

    @Override
    public void evaluateConsumption() {
        long daysStored = ChronoUnit.DAYS.between(dateArrival, LocalDate.now());
        if (quantity > 50 && daysStored > 10) {
            System.out.println("=> Slow sale (stock > 50 & stored > 10 days)");
        } else {
            System.out.println("=> No evaluation");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Manufacturer: " + manufacturer + " | Arrival Date: " + dateArrival);
    }
}

// Inventory Management
class InventoryManager {
    private Product[] products;
    private int count;

    public InventoryManager(int size) {
        products = new Product[size];
        count = 0;
    }

    public boolean addProduct(Product p) {
        for (int i = 0; i < count; i++) {
            if (products[i].getCode().equalsIgnoreCase(p.getCode())) {
                return false; // Duplicate code
            }
        }
        if (count < products.length) {
            products[count++] = p;
            return true;
        }
        return false;
    }

    public void displayAll() {
        System.out.println("=== Product List ===");
        for (int i = 0; i < count; i++) {
            products[i].display();
            System.out.println("VAT: " + products[i].calculateVAT());
            products[i].evaluateConsumption();
            System.out.println("--------------------");
        }
    }
}

// Main
public class Practice2 {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager(100);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Food");
            System.out.println("2. Add Electronics");
            System.out.println("3. Add Crockery");
            System.out.println("4. Show All");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (choice == 0) break;

            System.out.print("Enter code: ");
            String code = sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            System.out.print("Enter unit price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter manufacture date (yyyy-mm-dd): ");
                    LocalDate mfg = LocalDate.parse(sc.nextLine());
                    System.out.print("Enter expiration date (yyyy-mm-dd): ");
                    LocalDate exp = LocalDate.parse(sc.nextLine());
                    System.out.print("Enter supplier: ");
                    String sup = sc.nextLine();
                    try {
                        Food food = new Food(code, name, quantity, price, mfg, exp, sup);
                        if (manager.addProduct(food)) {
                            System.out.println("Food added.");
                        } else {
                            System.out.println("Duplicate product code!");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid dates: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Enter warranty months: ");
                    int months = sc.nextInt();
                    System.out.print("Enter capacity (kW): ");
                    double kw = sc.nextDouble();
                    Electronics elec = new Electronics(code, name, quantity, price, months, kw);
                    if (manager.addProduct(elec)) {
                        System.out.println("Electronics added.");
                    } else {
                        System.out.println("Duplicate product code!");
                    }
                }
                case 3 -> {
                    System.out.print("Enter manufacturer: ");
                    String mfg = sc.nextLine();
                    System.out.print("Enter arrival date (yyyy-mm-dd): ");
                    LocalDate arr = LocalDate.parse(sc.nextLine());
                    Crockery crockery = new Crockery(code, name, quantity, price, mfg, arr);
                    if (manager.addProduct(crockery)) {
                        System.out.println("Crockery added.");
                    } else {
                        System.out.println("Duplicate product code!");
                    }
                }
                case 4 -> manager.displayAll();
                default -> System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}

