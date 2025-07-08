package org.os.model;

import org.os.service.MailService;

public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, String author, int year, double price, String fileType) {
        super(author, title, isbn, year, price);
        this.fileType = fileType;
    }

    @Override
    public double purchase(int quantity, String email, String address) {
        MailService.sendMail(email, getTitle(), getFileType());
        return getPrice() * quantity;
    }

    public String getFileType() {
        return fileType;
    }
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
