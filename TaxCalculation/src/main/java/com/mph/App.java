package com.mph;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AssetManager manager = new AssetManager();
        UIManager ui = new UIManager(manager);

        // ------------------------------------------------------------
        // WELCOME SCREEN
        // ------------------------------------------------------------
        System.out.println("+---------------------------------------+");
        System.out.println("|      WELCOME TO TAX CALCULATION APP   |");
        System.out.println("+---------------------------------------+");

        // ------------------------------------------------------------
        // LOGIN
        // ------------------------------------------------------------
        InputValidator.validateLogin(sc);

        // ------------------------------------------------------------
        // MAIN MENU LOOP
        // ------------------------------------------------------------
        while (true) {
            System.out.println("\n+-----------------------------+");
            System.out.println("|          MAIN MENU          |");
            System.out.println("+-----------------------------+");
            System.out.println("1. PROPERTY TAX");
            System.out.println("2. VEHICLE TAX");
            System.out.println("3. TOTAL");
            System.out.println("4. EXIT");
            System.out.print("Enter your choice: ");

            int choice = InputValidator.getValidInt(sc);

            switch (choice) {

                case 1:
                    ui.propertyMenu();
                    break;

                case 2:
                    ui.vehicleMenu();
                    break;

                case 3:
                    ui.viewData();
                    break;

                case 4:
                    System.out.println("\nThank you for using the application!");
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } 
    }      
}          
