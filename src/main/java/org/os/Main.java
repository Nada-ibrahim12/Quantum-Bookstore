package org.os;

import org.os.model.*;

import java.time.Year;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuantumBookstore bookstore = new QuantumBookstore();
        Scanner scanner = new Scanner(System.in);

        initializeSampleBooks(bookstore);

        while (true) {
            System.out.println("\n=== Quantum Bookstore ===");
            System.out.println("1. View all books");
            System.out.println("2. Add a new book");
            System.out.println("3. Buy a book");
            System.out.println("4. Remove outdated books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    displayAllBooks(bookstore);
                    break;
                case 2:
                    addNewBook(bookstore, scanner);
                    break;
                case 3:
                    buyBook(bookstore, scanner);
                    break;
                case 4:
                    removeOutdatedBooks(bookstore, scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using Quantum Bookstore!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeSampleBooks(QuantumBookstore bookstore) {
        bookstore.addBook(new PaperBook("0", "Beginner Java", "A. Programmer", 2020, 29.99, 10));
        bookstore.addBook(new EBook("1", "Advanced Java", "J. Expert", 2022, 19.99, "PDF"));
        bookstore.addBook(new ShowcaseBook("2", "Quantum Computing", "Q. Scientist", 2023, 5 ));
        bookstore.addBook(new PaperBook("3", "Ancient Programming", "O. Developer", 1995, 9.99, 2));
    }

    private static void displayAllBooks(QuantumBookstore bookstore) {
        System.out.println("\n=== Current Store ===");
        System.out.printf("%-5s %-25s %-20s %-6s %-8s %-10s%n",
                "ISBN", "Title", "Author", "Year", "Price", "Type/Stock");

        for (Book book : bookstore.getBooks()) {
            if (book instanceof PaperBook) {
                System.out.printf("%-5s %-25s %-20s %-6d $%-7.2f Paper (%d)%n",
                        book.getIsbn(), book.getTitle(), book.getAuthor(), book.getYear(),
                        book.getPrice(), ((PaperBook) book).getQuantityInStock());
            } else if (book instanceof EBook) {
                System.out.printf("%-5s %-25s %-20s %-6d $%-7.2f eBook (%s)%n",
                        book.getIsbn(), book.getTitle(), book.getAuthor(), book.getYear(),
                        book.getPrice(), ((EBook) book).getFileType());
            } else if (book instanceof ShowcaseBook) {
                System.out.printf("%-5s %-25s %-20s %-6d $%-7.2f Showcase %n",
                        book.getIsbn(), book.getTitle(), book.getAuthor(), book.getYear(),
                        book.getPrice());
            }
        }
        System.out.println("Total books: " + bookstore.getInventorySize());
    }

    private static void addNewBook(QuantumBookstore bookstore, Scanner scanner) {
        System.out.println("\n=== Add New Book ===");
        System.out.println("Choose book type:");
        System.out.println("1. Paper Book");
        System.out.println("2. EBook");
        System.out.println("3. Showcase Book");
        System.out.print("Enter choice: ");

        int typeChoice;
        try {
            typeChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine());

        try {
            switch (typeChoice) {
                case 1:
                    System.out.print("Enter stock quantity: ");
                    int stock = Integer.parseInt(scanner.nextLine());
                    bookstore.addBook(new PaperBook(isbn, title, author, year, price, stock));
                    break;
                case 2:
                    System.out.print("Enter format (PDF/EPUB): ");
                    String format = scanner.nextLine();
                    bookstore.addBook(new EBook(isbn, title, author, year, price, format));
                    break;
                case 3:
                    System.out.print("Enter display count: ");
                    int displayCount = Integer.parseInt(scanner.nextLine());
                    bookstore.addBook(new ShowcaseBook(isbn, title, author, year, price));
                    break;
                default:
                    System.out.println("Invalid book type.");
                    return;
            }
            System.out.println("Book added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
        }
    }

    private static void buyBook(QuantumBookstore bookstore, Scanner scanner) {
        System.out.println("\n=== Buy a Book ===");
        System.out.print("Enter ISBN of the book: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        try {
            if (bookstore.getBook(isbn) instanceof ShowcaseBook) {
                System.out.println("Error: Showcase books cannot be purchased!");
                return;
            }

            System.out.print("Enter shipping address (leave empty for eBooks): ");
            String address = scanner.nextLine();

            double total = bookstore.buyBook(isbn, quantity, email, address);
            System.out.printf("Purchase successful! Total: $%.2f%n", total);
        } catch (Exception e) {
            System.out.println("Error during purchase: " + e.getMessage());
        }
    }

    private static void removeOutdatedBooks(QuantumBookstore bookstore, Scanner scanner) {
        System.out.println("\n=== Remove Outdated Books ===");
        System.out.print("Enter minimum years to consider as outdated: ");
        int years = Integer.parseInt(scanner.nextLine());

        List<Book> removedBooks = bookstore.removeOutdatedBooks(years);
        if (removedBooks.isEmpty()) {
            System.out.println("No outdated books found.");
        } else {
            System.out.println("Removed " + removedBooks.size() + " outdated books:");
            for (Book book : removedBooks) {
                System.out.println("- " + book.getTitle() + " (" + book.getYear() + ")");
            }
        }
    }
}