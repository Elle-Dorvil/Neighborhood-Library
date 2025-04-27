package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    public static void main(String[] args) {
        Book[] inventory = initializedInventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Neighborhood Library");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.println("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // show available books
                    showAvailableBooks(inventory);
                    break;
                case 2:
                    showCheckedOutBooks(inventory);
                    break;
                case 3: {
                    System.out.println("You are now exiting the Library.");
                    scanner.close();
                    System.exit(0);
                }
                default:
                    System.out.println("Error. Incorrect Option. Please Try Again");
            }
        }
    }
        private static Book[] initializedInventory() {
            Scanner scanner = new Scanner(System.in);
            Book[] inventory = new Book[5];
            inventory[0] = new Book(1, 978156781, "Harry Potter");
            inventory[1] = new Book(2, 100323456, "Cat and the Hat");
            inventory[2] = new Book(3, 456887456, "Twinkle Twinkle Little Star");
            inventory[3] = new Book(4, 743276231, "The Mountain is You");
            inventory[4] = new Book(5, 564745609, "Get Out of Your Own Way");
            return inventory;
        }


        private static void showAvailableBooks (Book[]inventory){
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nAvailable Books: ");
            boolean hasAvailable = false;

            for (Book book : inventory) {
                if (!book.isCheckedOut()) {
                    System.out.printf(" ID: %d | ISBN: %s | Title: %s\n", book.getId(), book.getIsbn(), book.getTitle());
                    hasAvailable = true;
                } else {
                    System.out.println("No books available.");
                    return;
                }
            }

            System.out.println("\nEnter book ID to check out or 0 to go back: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            if (id == 0) return;

            for (Book book : inventory) {
                if (book.getId() == id && book.isCheckedOut()) {
                    System.out.print("Enter name to check out book: ");
                    String name = scanner.nextLine();
//                    book.checkOut(name);
                    System.out.println("Your book has been checked out by: " + name);
                    return;
                }
            }
            System.out.println("Invalid book ID or selection has been checked out: ");
        }
        private static void showCheckedOutBooks (Book[] inventory){
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nChecked Out Books: ");
            boolean hasCheckedOut = false;

            for (Book book : inventory) {
                if(book != null && book.isCheckedOut()) {
                    System.out.printf("ID: %d" + book.getId() + "ISBN: %s" + book.getIsbn() + "Title: %s\n" + book.getTitle() + "Checked out to: %s\n " + book.getCheckedOutTo());
                    return;
                }else
                    {System.out.println("Nothing has been checked out: ");
            }
                return;
            }
            while (true) {
                System.out.println("\nOptions:");
                System.out.println("C - Check in book: ");
                System.out.println("X - Return to home screen: ");
                String option = scanner.nextLine();

                if (option.equalsIgnoreCase("X")) {
                    return;
                } else if (option.equalsIgnoreCase("C")) {
                    System.out.println("Enter book ID to check in: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    for (Book book : inventory) {
                        if (book.getId() == id && book.isCheckedOut()) {
//                            book.checkIn();
                            System.out.println("Book is checked in: ");
                            return;
                        }
                    }
                    System.out.println("Invalid ID or book is not checked out");
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }


            }

        }


    }
