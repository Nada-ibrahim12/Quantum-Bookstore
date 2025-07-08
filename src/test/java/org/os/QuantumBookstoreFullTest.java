package org.os;

import org.os.model.*;
import org.os.service.MailService;
import org.os.service.ShippingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuantumBookstoreFullTest {
    private QuantumBookstore store;
    private Book paperBook;
    private Book ebook;
    private Book showcase;
    private Book oldBook;

    @BeforeEach
    void setUp() {
        store = new QuantumBookstore();

        int currentYear = Year.now().getValue();

        paperBook = new PaperBook("0", "Beginner Java", "A", currentYear - 5, 20.0, 10);
        ebook = new EBook("1", "Advanced Java", "Jane Smith", 2021, 19.99, "PDF");
        showcase = new ShowcaseBook("2", "Future Books", "Quantum Author", 2022, 10);
        oldBook = new PaperBook("00", "Old", "bju", 1990, 10.20, 2);

        store.addBook(paperBook);
        store.addBook(ebook);
        store.addBook(showcase);
        store.addBook(oldBook);
    }

    @Test
    void testAddBook() {
        assertEquals(4, store.getInventorySize());
    }

    @Test
    void testBuyPaperBookSuccessfully() {
        double amount = store.buyBook("0", 2, "test@example.com", "El Sheikh Zayed");
        assertEquals(40.0, amount);
    }

    @Test
    void testBuyEBookSuccessfully() {
        double amount = store.buyBook("1", 1, "any@example.com", "");
        assertEquals(19.99, amount);
    }

    @Test
    void testBuyShowcaseBookFails() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            store.buyBook("2", 1, "any@example.com", "anywhere");
        });
        assertTrue(exception.getMessage().contains("not for sale"));
    }

    @Test
    void testRemoveOutdatedBooks() {
        int currentYear = Year.now().getValue();
        Book oldBook = new PaperBook("5", "mm", "Author", currentYear - 20, 10.0, 5);
        store.addBook(oldBook);

        assertEquals(5, store.getInventorySize());

        List<Book> outdatedBooks = store.removeOutdatedBooks(10);

        assertEquals(2, outdatedBooks.size());
        assertEquals(3, store.getInventorySize());
    }

    @Test
    void testBuyNonExistentBookFails() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            store.buyBook("9", 1, "test@example.com", "hoh");
        });
        assertTrue(exception.getMessage().contains("not found"));
    }

    @Test
    void testBuyWithInsufficientStockFails() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            store.buyBook("0", 100, "test@example.com", "El Sheikh Zayed");
        });
        assertTrue(exception.getMessage().contains("Not enough books in stock"));
    }
}