package org.os.service;

public class ShippingService {
    public static void ship(String address, String title, int quantity) {
        System.out.printf("Shipping Service: Shipping %d copy/copies of '%s' to %s%n",
                quantity, title, address);
    }
}
