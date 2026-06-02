/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

/**
 *
 * @author idil
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.Model.Employee;

public class EmployeeDAO {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/company?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "";

    // SQL Queries
    private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employees (name, email, position) VALUES (?, ?, ?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "SELECT id, name, email, position FROM employees WHERE id = ?;";
    private static final String SELECT_ALL_EMPLOYEES  = "SELECT id, name, email, position FROM employees;";
    private static final String DELETE_EMPLOYEES_SQL  = "DELETE FROM employees WHERE id = ?;";
    private static final String UPDATE_EMPLOYEES_SQL  = "UPDATE employees SET name = ?, email = ?, position = ? WHERE id = ?;";

    public EmployeeDAO() {
        // No explicit driver loading needed for modern JDBC drivers (Java 8 to Java 28+)
    }

    protected Connection getConnection() throws SQLException {
        // Streamlined connection establishment
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // CREATE
    public void insertEmployee(Employee employee) throws SQLException {
        System.out.println(INSERT_EMPLOYEES_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL)) {
            
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getPosition());
            
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
            throw e; 
        }
    }

    // READ (Single)
    public Employee selectEmployee(int id) {
        Employee employee = null;
        // Added Connection to try-with-resources to ensure absolute closure on Tomcat 11
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String position = rs.getString("position");
                    employee = new Employee(id, name, email, position);
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employee;
    }

    // READ (All)
    public List<Employee> selectAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        // Managed both Connection and ResultSet inside try-with-resources
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
             ResultSet rs = preparedStatement.executeQuery()) {

            System.out.println(preparedStatement);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String position = rs.getString("position");
                employees.add(new Employee(id, name, email, position));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    // DELETE
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEES_SQL)) {
            
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
            throw e;
        }
        return rowDeleted;
    }

    // UPDATE
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEES_SQL)) {
            
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getPosition());
            statement.setInt(4, employee.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
            throw e;
        }
        return rowUpdated;
    }

    // Structured Exception Logger
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException sqlException) { // Using modern Java pattern matching for instanceof
                sqlException.printStackTrace(System.err);
                System.err.println("SQLState: " + sqlException.getSQLState());
                System.err.println("Error Code: " + sqlException.getErrorCode());
                System.err.println("Message: " + sqlException.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.err.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
