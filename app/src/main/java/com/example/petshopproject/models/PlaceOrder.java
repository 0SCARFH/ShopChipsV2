package com.example.petshopproject.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrder implements Serializable {
    private String username;
    private String email;
    private String phoneNumber;
    private String location;
    private List<Order> orders;
    public PlaceOrder() {
        username = "";
        email = "";
        phoneNumber = "";
        location = "";
        orders = new ArrayList<Order>();
    }
    public PlaceOrder(String username, String email, String phoneNumber, String location) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
        orders = new ArrayList<Order>();
    }
    public PlaceOrder(String username, String email, String phoneNumber, String location, List<Order> orders) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.orders = orders;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
    public void addOrder(Order order) { orders.add(order); }
    public void removeOrder(Order order) { orders.remove(order); }
    public void clearOrders() { orders.clear(); }
}
