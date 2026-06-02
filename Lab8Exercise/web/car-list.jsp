<%-- 
    Document   : car-list
    Created on : Jun 2, 2026, 8:50:38 PM
    Author     : idil
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.carshop.model.Car" %>
<html>
<head>
    <title>Car Shop Management</title>
    <style>
        body { font-family: sans-serif; margin: 30px; }
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
        a { text-decoration: none; color: blue; }
        .btn { background: #28a745; color: white; padding: 8px 12px; border-radius: 4px; }
    </style>
</head>
<body>

    <h2>Car Price List Management</h2>
    <a href="new" class="btn">Add New Car</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Brand</th>
            <th>Model</th>
            <th>Cylinder</th>
            <th>Price ($)</th>
            <th>Actions</th>
        </tr>
        <%
            List<Car> listCar = (List<Car>) request.getAttribute("listCar");
            if(listCar != null) {
                for(Car car : listCar) {
        %>
        <tr>
            <td><%= car.getCarId() %></td>
            <td><%= car.getBrand() %></td>
            <td><%= car.getModel() %></td>
            <td><%= car.getCylinder() %></td>
            <td><%= String.format("%.2f", car.getPrice()) %></td>
            <td>
                <a href="edit?id=<%= car.getCarId() %>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="delete?id=<%= car.getCarId() %>" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
        <% 
                }
            } 
        %>
    </table>
</body>
</html>
