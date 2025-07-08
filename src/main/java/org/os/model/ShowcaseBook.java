package org.os.model;

public class ShowcaseBook extends Book {

    public ShowcaseBook(String isbn, String title, String author, int year, double price) {
        super(author, title, isbn, year, price);
    }

    @Override
    public double purchase(int quantity, String email, String address) {
        throw new RuntimeException("This book is not for sale");
    }
}
