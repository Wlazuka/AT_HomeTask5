package com.amazon.valueObject;

public class Book {

    private final String title;
    private final String type;
    private final double price;

    public Book(String title, String type, double price) {
        this.title = title;
        this.type = type;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }


}
