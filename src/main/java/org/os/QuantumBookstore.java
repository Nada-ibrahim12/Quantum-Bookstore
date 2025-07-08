package org.os;

import org.os.model.Book;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class QuantumBookstore {
    private final Map<String, Book> store = new HashMap<>();

    public void addBook(Book book) {
        store.put(book.getIsbn(), book);
        System.out.println("Book added successfully: " + book.getIsbn());
    }

    public Book getBook(String isbn) {
        return store.get(isbn);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(store.values());
    }

    public List<Book> removeOutdatedBooks(int years) {
        List<Book> outdatedBooks = new ArrayList<>();
        int currentYear = Year.now().getValue();

        store.entrySet().removeIf(entry -> {
            if ((currentYear - entry.getValue().getYear()) > years) {
                outdatedBooks.add(entry.getValue());
                System.out.println("Outdated book: " + entry.getKey());
                return true;
            }
            return false;
        });
        return outdatedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) {
        Book book = store.get(isbn);
        if (book == null) {
            throw new RuntimeException("Book not found: " + isbn);
        }
        return book.purchase(quantity, email, address);
    }

    public int getInventorySize() {
        return store.size();
    }
}