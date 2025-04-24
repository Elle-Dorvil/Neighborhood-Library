package com.pluralsight;

import java.util.Scanner;

public class LibraryApplication {
    private static Book[] books = new Book[20];

    public static void main (String[]args) {
        initializedBooks();
        showHomeScreen();
    }
    public static void initializedBooks(){
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book(i + 1, "IBSN" + (1000 + i), "Book Title " + (i + 1));
        }
    }
    public static void showHomeScreen() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Neighborhood Library ---");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.println("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case 1 -> showAvailableBooks(scanner);
                case 2 -> showCheckedOutBooks(scanner);
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Error. Incorrect Option. Please Try Again");
            }
        }
    }
}

