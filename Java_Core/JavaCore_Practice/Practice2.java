package JavaCore_Practice;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

interface TaxCalculable {
    double calculateVAT();
}

interface ConsumptionEvaluable {
    void evaluateConsumption();
}

interface Displayable {
    void display();
}

abstract class Product implements TaxCalculable, ConsumptionEvaluable, Displayable {
    protected final String code;
    protected final String name;
    protected final int quantity;
    protected final double unitPrice;

    protected Product(String code, String name, int quantity, double unitPrice) {
        this.code = code;
        this.name = name;
        this.quantity = Math.max(quantity, 0);
        this.unitPrice = unitPrice;
    }

    public String getCode() {
        return code;
    }

    @Override
    public void display() {
        System.out.println("Code: " + code + " | Name: " + name + " | Quantity: " + quantity + " | Unit Price: " + unitPrice);
    }
}

class Food extends Product {
    private static final double VAT_RATE = 0.05;
    private final LocalDate manufactureDate;
    private final LocalDate expirationDate;
    private final String supplier;

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
        return unitPrice * VAT_RATE;
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

class Electronics extends Product {
    private static final double VAT_RATE = 0.10;
    private static final int LOW_STOCK_THRESHOLD = 3;
    private final int warrantyMonths;
    private final double capacityKW;

    public Electronics(String code, String name, int quantity, double unitPrice,
                       int warrantyMonths, double capacityKW) {
        super(code, name, quantity, unitPrice);
        this.warrantyMonths = Math.max(0, warrantyMonths);
        this.capacityKW = Math.max(0, capacityKW);
    }

    @Override
    public double calculateVAT() {
        return unitPrice * VAT_RATE;
    }

    @Override
    public void evaluateConsumption() {
        if (quantity < LOW_STOCK_THRESHOLD) {
            System.out.println("=> Considered sold (low stock)");
        } else {
            System.out.println("=> No evaluation");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Warranty: " + warrantyMonths + " months | Capacity: " + capacityKW + " KW");
    }}

class Crockery extends Product {
    private static final double VAT_RATE = 0.10;
    private static final int HIGH_STOCK_THRESHOLD = 50;
    private static final int STORAGE_DAYS_THRESHOLD = 10;
    private final String manufacturer;
    private final LocalDate dateArrival;

    public Crockery(String code, String name, int quantity, double unitPrice,
                    String manufacturer, LocalDate dateArrival) {
        super(code, name, quantity, unitPrice);
        this.manufacturer = manufacturer;
        this.dateArrival = dateArrival;
    }

    @Override
    public double calculateVAT() {
        return unitPrice * VAT_RATE;
    }

    @Override
    public void evaluateConsumption() {
        long daysStored = ChronoUnit.DAYS.between(dateArrival, LocalDate.now());
        if (quantity > HIGH_STOCK_THRESHOLD && daysStored > STORAGE_DAYS_THRESHOLD) {
            System.out.println("=> Slow sale (stock > " + HIGH_STOCK_THRESHOLD + " & stored > " + STORAGE_DAYS_THRESHOLD + " days)");
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

interface ProductRepository {
    boolean addProduct(Product product);
    void displayAll();
}

class InventoryManager implements ProductRepository {
    private final Product[] products;
    private int count;

    public InventoryManager(int size) {
        products = new Product[size];
        count = 0;
    }

    @Override
    public boolean addProduct(Product product) {
        for (int i = 0; i < count; i++) {
            if (products[i].getCode().equalsIgnoreCase(product.getCode())) {
                return false;
            }
        }
        if (count < products.length) {
            products[count++] = product;
            return true;
        }
        return false;
    }

    @Override
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

interface UserInputHandler {
    void handleUserInput();
}

class InventoryInputHandler implements UserInputHandler {
    private final Scanner scanner;
    private final ProductRepository repository;

    public InventoryInputHandler(Scanner scanner, ProductRepository repository) {
        this.scanner = scanner;
        this.repository = repository;
    }

    @Override
    public void handleUserInput() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            processChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("\n1. Add Food");
        System.out.println("2. Add Electronics");
        System.out.println("3. Add Crockery");
        System.out.println("4. Show All");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private void processChoice(int choice) {
        if (choice >= 1 && choice <= 3) {
            handleProductCreation(choice);
        } else if (choice == 4) {
            repository.displayAll();
        } else {
            System.out.println("Invalid choice!");
        }
    }

    private void handleProductCreation(int type) {
        try {
            String code = getInput("Enter code: ");
            String name = getInput("Enter name: ");
            int quantity = Integer.parseInt(getInput("Enter quantity: "));
            double price = Double.parseDouble(getInput("Enter unit price: "));

            Product product = createProduct(type, code, name, quantity, price);
            if (repository.addProduct(product)) {
                System.out.println("Product added successfully.");
            } else {
                System.out.println("Duplicate product code!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private Product createProduct(int type, String code, String name, int quantity, double price) {
        switch (type) {
            case 1:
                return createFood(code, name, quantity, price);
            case 2:
                return createElectronics(code, name, quantity, price);
            case 3:
                return createCrockery(code, name, quantity, price);
            default:
                throw new IllegalArgumentException("Invalid product type");
        }
    }

    private Food createFood(String code, String name, int quantity, double price) {
        LocalDate mfg = LocalDate.parse(getInput("Enter manufacture date (yyyy-mm-dd): "));
        LocalDate exp = LocalDate.parse(getInput("Enter expiration date (yyyy-mm-dd): "));
        String supplier = getInput("Enter supplier: ");
        return new Food(code, name, quantity, price, mfg, exp, supplier);
    }

    private Electronics createElectronics(String code, String name, int quantity, double price) {
        int months = Integer.parseInt(getInput("Enter warranty months: "));
        double kw = Double.parseDouble(getInput("Enter capacity (kW): "));
        return new Electronics(code, name, quantity, price, months, kw);
    }

    private Crockery createCrockery(String code, String name, int quantity, double price) {
        String manufacturer = getInput("Enter manufacturer: ");
        LocalDate arrival = LocalDate.parse(getInput("Enter arrival date (yyyy-mm-dd): "));
        return new Crockery(code, name, quantity, price, manufacturer, arrival);
    }

    private String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}

public class Practice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductRepository repository = new InventoryManager(100);
        UserInputHandler inputHandler = new InventoryInputHandler(scanner, repository);

        inputHandler.handleUserInput();
        scanner.close();
    }
}

