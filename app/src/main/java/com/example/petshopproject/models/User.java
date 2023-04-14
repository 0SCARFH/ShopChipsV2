package com.example.petshopproject.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String location;
    private List<Order> orders;
    public User() {
        username = "";
        password = "";
        email = "";
        phoneNumber = "";
        location = "";
        orders = new ArrayList<Order>();
    }

    public User(String username, String password, String email, String phoneNumber, String location) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
        orders = new ArrayList<Order>();
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
