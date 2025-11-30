package com.mph;

import java.util.Scanner;

public class UIManager {

    private final Scanner sc = new Scanner(System.in);
    private final AssetManager manager;

    public UIManager(AssetManager manager) {
        this.manager = manager;
    }

    // ------------------------------------------------------------
    // PROPERTY MENU
    // ------------------------------------------------------------
    public void propertyMenu() {

        while (true) {
            System.out.println("\n--- PROPERTY TAX MENU ---");
            System.out.println("1. ADD PROPERTY DETAILS");
            System.out.println("2. CALCULATE PROPERTY TAX");
            System.out.println("3. DISPLAY ALL PROPERTIES");
            System.out.println("4. BACK TO MAIN MENU");
            System.out.print("Enter choice: ");

            int choice = InputValidator.getValidInt(sc);

            switch (choice) {
                case 1 -> addProperty();
                case 2 -> calculatePropertyTax();
                case 3 -> displayProperties();
                case 4 -> { return; }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // ------------------------------------------------------------
    // ADD PROPERTY DETAILS
    // ------------------------------------------------------------
    public void addProperty() {

        double area = InputValidator.getValidDouble(sc, "Enter Built-up Area: ");
        double base = InputValidator.getValidDouble(sc, "Enter Base Value: ");
        int age = InputValidator.getValidInt(sc, "Enter Age of Construction: ");
        boolean city = InputValidator.getYesNo(sc, "Is it in main city? (Y/N): ");

        Property p = new Property(area, base, age, city);
        manager.addProperty(p);

        System.out.println("Property added successfully!");
    }

    // ------------------------------------------------------------
    // CALCULATE PROPERTY TAX
    // ------------------------------------------------------------
    public void calculatePropertyTax() {

        if (manager.getProperties().isEmpty()) {
            System.out.println("No properties to calculate tax!");
            return;
        }

        System.out.println("\n--- PROPERTY TAX DETAILS ---");

        for (Property p : manager.getProperties()) {
            System.out.println(p + " | TAX = " + String.format("%.2f", p.calculateTax()));
        }
    }

    // ------------------------------------------------------------
    // DISPLAY PROPERTIES
    // ------------------------------------------------------------
    public void displayProperties() {

        if (manager.getProperties().isEmpty()) {
            System.out.println("No properties added yet!");
            return;
        }

        System.out.println("\n--- PROPERTY LIST ---");

        manager.getProperties()
                .forEach(p -> System.out.println(p + " | TAX = " + String.format("%.2f", p.calculateTax())));
    }

    // ------------------------------------------------------------
    // VEHICLE MENU
    // ------------------------------------------------------------
    public void vehicleMenu() {

        while (true) {
            System.out.println("\n--- VEHICLE TAX MENU ---");
            System.out.println("1. ADD VEHICLE DETAILS");
            System.out.println("2. CALCULATE VEHICLE TAX");
            System.out.println("3. DISPLAY ALL VEHICLES");
            System.out.println("4. BACK TO MAIN MENU");
            System.out.print("Enter choice: ");

            int choice = InputValidator.getValidInt(sc);

            switch (choice) {
                case 1 -> addVehicle();
                case 2 -> calculateVehicleTax();
                case 3 -> displayVehicles();
                case 4 -> { return; }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // ------------------------------------------------------------
    // ADD VEHICLE DETAILS
    // ------------------------------------------------------------
    public void addVehicle() {

        String reg = InputValidator.getValidRegNumber(sc, "Enter Registration No (4 digits): ");
        String brand = InputValidator.getValidString(sc, "Enter Brand: ");
        double cost = InputValidator.getValidDouble(sc, "Enter Cost: ");
        int vel = InputValidator.getValidInt(sc, "Enter Max Velocity: ");
        int cap = InputValidator.getValidInt(sc, "Enter Capacity: ");

        System.out.println("Select Type:");
        System.out.println("1. Petrol");
        System.out.println("2. Diesel");
        System.out.println("3. CNG/LPG");
        int type = InputValidator.getValidInt(sc, "Enter choice (1-3): ");

        Vehicle v = new Vehicle(reg, brand, cost, vel, cap, type);
        manager.addVehicle(v);

        System.out.println("Vehicle added successfully!");
    }

    // ------------------------------------------------------------
    // CALCULATE VEHICLE TAX
    // ------------------------------------------------------------
    public void calculateVehicleTax() {

        if (manager.getVehicles().isEmpty()) {
            System.out.println("No vehicles to calculate tax!");
            return;
        }

        System.out.println("\n--- VEHICLE TAX DETAILS ---");

        for (Vehicle v : manager.getVehicles()) {
            System.out.println(v + " | TAX = " + String.format("%.2f", v.calculateTax()));
        }
    }

    // ------------------------------------------------------------
    // DISPLAY VEHICLES
    // ------------------------------------------------------------
    public void displayVehicles() {

        if (manager.getVehicles().isEmpty()) {
            System.out.println("No vehicles added yet!");
            return;
        }

        System.out.println("\n--- VEHICLE LIST ---");

        manager.getVehicles()
                .forEach(v -> System.out.println(v + " | TAX = " + String.format("%.2f", v.calculateTax())));
    }

    // ------------------------------------------------------------
    // TOTAL TAX SUMMARY
    // ------------------------------------------------------------
    public void viewData() {

        double totalProperties = manager.getProperties()
                .stream()
                .mapToDouble(Property::calculateTax)
                .sum();

        double totalVehicles = manager.getVehicles()
                .stream()
                .mapToDouble(Vehicle::calculateTax)
                .sum();

        System.out.println("\n--- TOTAL TAX SUMMARY ---");
        System.out.println("Total Property Tax : " + String.format("%.2f", totalProperties));
        System.out.println("Total Vehicle Tax  : " + String.format("%.2f", totalVehicles));
        System.out.println("--------------------------------");
        System.out.println("TOTAL TAX PAYABLE  : " + String.format("%.2f", (totalProperties + totalVehicles)));
    }
}
