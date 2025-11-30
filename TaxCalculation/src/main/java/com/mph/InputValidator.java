package com.mph;

import java.util.Scanner;

public class InputValidator {

    // ------------------------------------------------------------
    // SAFE INTEGER INPUT
    // ------------------------------------------------------------
    public static int getValidInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Invalid input! Enter a number: ");
            }
        }
    }

    public static int getValidInt(Scanner sc, String msg) {
        System.out.print(msg);
        return getValidInt(sc);
    }

    // ------------------------------------------------------------
    // SAFE DOUBLE INPUT
    // ------------------------------------------------------------
    public static double getValidDouble(Scanner sc, String msg) {
        System.out.print(msg);
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Invalid input! Enter a valid number: ");
            }
        }
    }

    // ------------------------------------------------------------
    // YES / NO INPUT
    // ------------------------------------------------------------
    public static boolean getYesNo(Scanner sc, String msg) {
        System.out.print(msg);
        while (true) {
            String in = sc.nextLine().trim().toLowerCase();
            if (in.equals("y") || in.equals("yes")) return true;
            if (in.equals("n") || in.equals("no")) return false;
            System.out.print("Invalid input! Enter Y/N: ");
        }
    }

    // ------------------------------------------------------------
    // STRING VALIDATION (no blank input)
    // ------------------------------------------------------------
    public static String getValidString(Scanner sc, String msg) {
        System.out.print(msg);
        while (true) {
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.print("Input cannot be empty! Re-enter: ");
        }
    }

    // ------------------------------------------------------------
    // REGISTRATION NUMBER VALIDATION (4 digits)
    // ------------------------------------------------------------
    public static String getValidRegNumber(Scanner sc, String msg) {
        System.out.print(msg);
        while (true) {
            String s = sc.nextLine().trim();
            if (s.matches("\\d{4}") && !s.equals("0000")) return s;
            System.out.print("Invalid! Enter a 4-digit number (0001–9999): ");
        }
    }

    // ------------------------------------------------------------
    // LOGIN VALIDATION
    // ------------------------------------------------------------
    public static boolean validateLogin(Scanner sc) {

        final String USER = "admin";
        final String PASS = "admin123";

        while (true) {
            System.out.println("PLEASE LOGIN TO CONTINUE -");
            System.out.print("Enter username: ");
            String u = sc.nextLine().trim();

            System.out.print("Enter password: ");
            String p = sc.nextLine().trim();

            if (u.equals(USER) && p.equals(PASS)) {
                System.out.println("\nLogin Successful!\n");
                return true;
            }

            System.out.println("\nIncorrect username or password!\nPlease try again.\n");
        }
    }
}
