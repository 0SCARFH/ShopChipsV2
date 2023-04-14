package com.example.petshopproject.models;

public class Product {
    private String name;
    private String description;
    private Float price;
    public Product()
    {
        name = "";
        description = "";
        price = 0F;
    }
    public Product(String name, String description, Float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Float getPrice() {
        return price;
    }
}
