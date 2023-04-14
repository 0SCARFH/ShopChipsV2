package com.example.petshopproject.models;

import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firestore.v1.Document;

import java.io.Serializable;

public class Shop implements Serializable {
    private String document;
    private String name;
    private String description;
    private String location;
    public Shop() {
        name = "ShopChips";
        description = "Papas a domicilio Shopschips";
        location = "Ciudad de Mexico";
    }
    public Shop(String document, String name, String description, String location) {
        this.document = document;
        this.name = name;
        this.description = description;
        this.location = location;
    }
    public String getDocument() { return document; }
    public void setDocument(String document) { this.document = document; }
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
    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() { return location; }
}
