package org.os.model;

import org.os.service.ShippingService;

public class PaperBook extends Book {
    private int quantityInStock;

    public PaperBook(String isbn, String title, String author, int year, double price, int quantityInStock) {
        super(author, title, isbn, year, price);
        this.quantityInStock = quantityInStock;
    }

    @Override
    public double purchase(int neededQuantity, String email, String address) {
        if (neededQuantity > quantityInStock) {
            throw new RuntimeException("Not enough books in stock");
        }
        quantityInStock -= neededQuantity;
        ShippingService.ship(address, getTitle(), neededQuantity);
        return getPrice() * neededQuantity;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

}
