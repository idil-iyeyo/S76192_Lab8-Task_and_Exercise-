<%-- 
    Document   : car-form
    Created on : Jun 2, 2026, 8:51:02 PM
    Author     : idil
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.carshop.model.Car" %>
<html>
<head>
    <title>Car Form</title>
    <style>
        body { font-family: sans-serif; margin: 40px; }
        form { width: 300px; display: flex; flex-direction: column; gap: 10px; }
        input { padding: 8px; }
        input[type="submit"] { background: #007bff; color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>

    <%
        Car car = (Car) request.getAttribute("car");
    %>

    <h2><%= (car != null) ? "Edit Car Details" : "Add New Car" %></h2>

    <form action="<%= (car != null) ? "update" : "insert" %>" method="post">
        
        <% if (car != null) { %>
            <input type="hidden" name="id" value="<%= car.getCarId() %>" />
        <% } %>

        <label>Brand:</label>
        <input type="text" name="brand" value="<%= (car != null) ? car.getBrand() : "" %>" required maxlength="15"/>

        <label>Model:</label>
        <input type="text" name="model" value="<%= (car != null) ? car.getModel() : "" %>" required maxlength="30"/>

        <label>Cylinder:</label>
        <input type="number" name="cylinder" value="<%= (car != null) ? car.getCylinder() : "" %>" required/>

        <label>Price:</label>
        <input type="number" step="0.01" name="price" value="<%= (car != null) ? car.getPrice() : "" %>" required/>

        <input type="submit" value="Save Car Record" />
    </form>
    
    <br>
    <a href="list">Back to Catalog</a>
</body>
</html>
