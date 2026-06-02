<%-- 
    Document   : index
    Created on : Jun 2, 2026, 8:12:14 PM
    Author     : idil
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="bg-light">

    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato;">
            <div>
                <a href="${pageContext.request.contextPath}/" class="navbar-brand">Employee Management App</a>
            </div>
        </nav>
    </header>
    
    <div class="container mt-5">
        <div class="jumbotron shadow-sm text-center bg-white border">
            <h1 class="display-5 text-dark mb-4">Application MVC System for Employee Management</h1>
            <p class="lead text-muted">Select an administrative task from the options below to interact with the database engine.</p>
            <hr class="my-4">
            
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="list-group">
                        <a href="${pageContext.request.contextPath}/" 
                           class="list-group-item list-group-item-action font-weight-bold text-primary">
                           View All Employees
                        </a>
                        <a href="${pageContext.request.contextPath}/new" 
                           class="list-group-item list-group-item-action font-weight-bold text-success">
                           Add New Employee
                        </a>
                    </div>
                </div>
            </div>
            
        </div>
    </div>

</body>
</html>
