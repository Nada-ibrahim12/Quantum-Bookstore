package org.os.model;

public abstract class Book {
    private String isbn;
    private String author;
    private String title;
    private int year;
    private double price;

    public Book(String author, String title, String isbn, int year, double price) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.year = year;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double purchase(int quantity, String email, String address);
}
