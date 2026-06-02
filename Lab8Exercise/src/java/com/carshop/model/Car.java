/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carshop.model;

/**
 *
 * @author idil
 */

public class Car {
    private int carId;
    private String brand;
    private String model;
    private int cylinder;
    private double price;

    // Constructor for creating/updating a car (with ID)
    public Car(int carId, String brand, String model, int cylinder, double price) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.cylinder = cylinder;
        this.price = price;
    }

    // Constructor for adding a new car (without ID, since DB auto-increments)
    public Car(String brand, String model, int cylinder, double price) {
        this.brand = brand;
        this.model = model;
        this.cylinder = cylinder;
        this.price = price;
    }

    // Getters and Setters
    public int getCarId() { return carId; }
    public void setCarId(int carId) { this.carId = carId; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getCylinder() { return cylinder; }
    public void setCylinder(int cylinder) { this.cylinder = cylinder; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
