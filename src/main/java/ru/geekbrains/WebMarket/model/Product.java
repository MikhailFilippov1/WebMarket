package ru.geekbrains.WebMarket.model;

public class Product {
    Long id;
    String title;
    float price;

    public Product(Long id, String title, float price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
