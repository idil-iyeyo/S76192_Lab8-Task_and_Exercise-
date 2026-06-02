/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carshop.dao;

/**
 *
 * @author idil
 */

import com.carshop.model.Car;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/carshop?useSSL=false&serverTimezone=UTC";
    private String jdbcUsername = "root"; // Change to your MySQL username
    private String jdbcPassword = "";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // CREATE: Insert a new car
    public void insertCar(Car car) throws SQLException {
        String sql = "INSERT INTO CarPricelist (Brand, Model, Cyclinder, Price) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, car.getBrand());
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getCylinder());
            statement.setDouble(4, car.getPrice());
            statement.executeUpdate();
        }
    }

    // READ: Select a single car by ID (for editing)
    public Car selectCar(int id) {
        Car car = null;
        String sql = "SELECT * FROM CarPricelist WHERE Car_id = ?";
        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String brand = rs.getString("Brand");
                String model = rs.getString("Model");
                int cylinder = rs.getInt("Cyclinder");
                double price = rs.getDouble("Price");
                car = new Car(id, brand, model, cylinder, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    // READ: Select all cars
    public List<Car> selectAllCars() {
        List<Car> cars = new ArrayList<>();
        String sql = "SELECT * FROM CarPricelist";
        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql); ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("Car_id");
                String brand = rs.getString("Brand");
                String model = rs.getString("Model");
                int cylinder = rs.getInt("Cyclinder");
                double price = rs.getDouble("Price");
                cars.add(new Car(id, brand, model, cylinder, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    // UPDATE: Update an existing car record
    public boolean updateCar(Car car) throws SQLException {
        boolean rowUpdated;
        String sql = "UPDATE CarPricelist SET Brand = ?, Model = ?, Cyclinder = ?, Price = ? WHERE Car_id = ?";
        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, car.getBrand());
            statement.setString(2, car.getModel());
            statement.setInt(3, car.getCylinder());
            statement.setDouble(4, car.getPrice());
            statement.setInt(5, car.getCarId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    // DELETE: Remove a car record
    public boolean deleteCar(int id) throws SQLException {
        boolean rowDeleted;
        String sql = "DELETE FROM CarPricelist WHERE Car_id = ?";
        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
