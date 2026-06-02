/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Model;

/**
 *
 * @author idil
 */
import java.io.Serializable;

/**
 * Employee model representing the business object.
 * Implements Serializable to fully adhere to modern JavaBean standards 
 * required by enterprise containers like Tomcat 11.
 */
public class Employee implements Serializable {
    
    private static final long serialVersionUID = 1L;

    // Encapsulation: Fields changed from protected to private to prevent leakage
    private int id;
    private String name;
    private String email;
    private String position;

    // No-argument constructor (Required for JavaBeans specification)
    public Employee() {
        super();
    }

    // Constructor without ID (Useful for database auto-increment insertions)
    public Employee(String name, String email, String position) {
        this.name = name;
        this.email = email;
        this.position = position;
    }

    // Full constructor with ID (Useful for database data retrieval)
    public Employee(int id, String name, String email, String position) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.position = position;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
