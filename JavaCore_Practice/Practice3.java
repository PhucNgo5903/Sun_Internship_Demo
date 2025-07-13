package JavaCore_Practice;

import java.util.*;

class Owner {
    private String idNumber; // exactly 12 digits
    private String fullName;
    private String email;

    public Owner(String idNumber, String fullName, String email) {
        if (!idNumber.matches("\\d{12}")) {
            throw new IllegalArgumentException("ID number must be exactly 12 digits.");
        }
        if (!email.matches("^\\w+@\\w+\\.\\w+$")) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        this.idNumber = idNumber;
        this.fullName = fullName;
        this.email = email;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void display() {
        System.out.println("Owner ID: " + idNumber + " | Name: " + fullName + " | Email: " + email);
    }
}

abstract class Vehicle {
    protected String number; // exactly 5 characters
    protected String manufacturer; // Honda, Yamaha, Toyota, Suzuki
    protected int year;
    protected String color;
    protected Owner owner;

    public Vehicle(String number, String manufacturer, int year, String color, Owner owner) {
        if (!number.matches(".{5}")) throw new IllegalArgumentException("Vehicle number must be exactly 5 characters.");
        if (!List.of("Honda", "Yamaha", "Toyota", "Suzuki").contains(manufacturer))
            throw new IllegalArgumentException("Manufacturer must be Honda, Yamaha, Toyota, or Suzuki.");
        if (year > Calendar.getInstance().get(Calendar.YEAR) || year < 2001)
            throw new IllegalArgumentException("Year must be from 2001 to current year.");

        this.number = number;
        this.manufacturer = manufacturer;
        this.year = year;
        this.color = color;
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Owner getOwner() {
        return owner;
    }

    public abstract void display();
}

class Car extends Vehicle {
    private int seats;
    private String engineType;

    public Car(String number, String manufacturer, int year, String color, Owner owner,
               int seats, String engineType) {
        super(number, manufacturer, year, color, owner);
        this.seats = seats;
        this.engineType = engineType;
    }

    @Override
    public void display() {
        System.out.println("[CAR] Number: " + number + ", Mfr: " + manufacturer + ", Year: " + year + ", Color: " + color);
        owner.display();
        System.out.println("Seats: " + seats + ", Engine: " + engineType);
    }
}

class Motorbike extends Vehicle {
    private int capacity;

    public Motorbike(String number, String manufacturer, int year, String color, Owner owner, int capacity) {
        super(number, manufacturer, year, color, owner);
        this.capacity = capacity;
    }

    @Override
    public void display() {
        System.out.println("[MOTORBIKE] Number: " + number + ", Mfr: " + manufacturer + ", Year: " + year + ", Color: " + color);
        owner.display();
        System.out.println("Capacity: " + capacity + "cc");
    }
}

class Truck extends Vehicle {
    private double tonnage;

    public Truck(String number, String manufacturer, int year, String color, Owner owner, double tonnage) {
        super(number, manufacturer, year, color, owner);
        this.tonnage = tonnage;
    }

    @Override
    public void display() {
        System.out.println("[TRUCK] Number: " + number + ", Mfr: " + manufacturer + ", Year: " + year + ", Color: " + color);
        owner.display();
        System.out.println("Tonnage: " + tonnage + " tons");
    }
}

// Manager class
class TransportManager {
    private List<Vehicle> vehicles = new ArrayList<>();

    public boolean addVehicle(Vehicle v) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getNumber().equals(v.getNumber())) return false; // Duplicate number
        }
        vehicles.add(v);
        return true;
    }

    public void searchByNumber(String number) {
        for (Vehicle v : vehicles) {
            if (v.getNumber().equalsIgnoreCase(number)) {
                v.display();
                return;
            }
        }
        System.out.println("No vehicle with number: " + number);
    }

    public void findByOwnerID(String id) {
        boolean found = false;
        for (Vehicle v : vehicles) {
            if (v.getOwner().getIdNumber().equals(id)) {
                v.display();
                found = true;
            }
        }
        if (!found) System.out.println("No vehicle found for owner ID: " + id);
    }

    public void deleteByManufacturer(String mfr) {
        vehicles.removeIf(v -> v.getManufacturer().equalsIgnoreCase(mfr));
        System.out.println("All vehicles from " + mfr + " deleted.");
    }

    public void manufacturerWithMostVehicles() {
        Map<String, Integer> countMap = new HashMap<>();
        for (Vehicle v : vehicles) {
            countMap.put(v.getManufacturer(), countMap.getOrDefault(v.getManufacturer(), 0) + 1);
        }
        String maxMfr = null;
        int max = 0;
        for (var e : countMap.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                maxMfr = e.getKey();
            }
        }
        if (maxMfr != null) {
            System.out.println("Manufacturer with most vehicles: " + maxMfr + " (" + max + ")");
        } else {
            System.out.println("No data available.");
        }
    }

    public void sortByManufacturerCount() {
        Map<String, Integer> mfrCount = new HashMap<>();
        for (Vehicle v : vehicles) {
            mfrCount.put(v.getManufacturer(), mfrCount.getOrDefault(v.getManufacturer(), 0) + 1);
        }

        mfrCount.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " vehicles"));
    }

    public void showStats() {
        int cars = 0, bikes = 0, trucks = 0;
        for (Vehicle v : vehicles) {
            if (v instanceof Car) cars++;
            else if (v instanceof Motorbike) bikes++;
            else if (v instanceof Truck) trucks++;
        }
        System.out.println("Total cars: " + cars);
        System.out.println("Total motorbikes: " + bikes);
        System.out.println("Total trucks: " + trucks);
    }
}

// Main class
public class Practice3 {
    public static void main(String[] args) {
        TransportManager tm = new TransportManager();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
            System.out.println("\n1. Add vehicle");
            System.out.println("2. Search by vehicle number");
            System.out.println("3. Find by owner ID");
            System.out.println("4. Delete by manufacturer");
            System.out.println("5. Manufacturer with most vehicles");
            System.out.println("6. Sort manufacturers by vehicle count");
            System.out.println("7. Show vehicle type statistics");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("Enter owner ID (12 digits): ");
                        String id = sc.nextLine();
                        System.out.print("Full name: ");
                        String name = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        Owner owner = new Owner(id, name, email);

                        System.out.print("Enter vehicle number (5 chars): ");
                        String num = sc.nextLine();
                        System.out.print("Manufacturer (Honda/Yamaha/Toyota/Suzuki): ");
                        String mfr = sc.nextLine();
                        System.out.print("Year of manufacture: ");
                        int year = Integer.parseInt(sc.nextLine());
                        System.out.print("Color: ");
                        String color = sc.nextLine();

                        System.out.print("Type (car/motorbike/truck): ");
                        String type = sc.nextLine();

                        Vehicle v = null;
                        if (type.equalsIgnoreCase("car")) {
                            System.out.print("Seats: ");
                            int seats = Integer.parseInt(sc.nextLine());
                            System.out.print("Engine type: ");
                            String engine = sc.nextLine();
                            v = new Car(num, mfr, year, color, owner, seats, engine);
                        } else if (type.equalsIgnoreCase("motorbike")) {
                            System.out.print("Capacity (cc): ");
                            int cap = Integer.parseInt(sc.nextLine());
                            v = new Motorbike(num, mfr, year, color, owner, cap);
                        } else if (type.equalsIgnoreCase("truck")) {
                            System.out.print("Tonnage: ");
                            double ton = Double.parseDouble(sc.nextLine());
                            v = new Truck(num, mfr, year, color, owner, ton);
                        }

                        if (tm.addVehicle(v)) {
                            System.out.println("Vehicle added.");
                        } else {
                            System.out.println("Duplicate vehicle number!");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Enter vehicle number: ");
                    tm.searchByNumber(sc.nextLine());
                }
                case 3 -> {
                    System.out.print("Enter owner ID: ");
                    tm.findByOwnerID(sc.nextLine());
                }
                case 4 -> {
                    System.out.print("Enter manufacturer to delete: ");
                    tm.deleteByManufacturer(sc.nextLine());
                }
                case 5 -> tm.manufacturerWithMostVehicles();
                case 6 -> tm.sortByManufacturerCount();
                case 7 -> tm.showStats();
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
        }
    }
}