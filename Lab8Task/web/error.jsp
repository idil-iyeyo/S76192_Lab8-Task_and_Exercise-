<%-- 
    Document   : error
    Created on : Jun 2, 2026, 8:11:19 PM
    Author     : idil
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="bg-light">
    
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card border-danger shadow-sm">
                    <div class="card-header bg-danger text-white text-center">
                        <h3 class="mb-0">An Error Has Occurred</h3>
                    </div>
                    <div class="card-body text-center py-4">
                        <h4 class="text-secondary mb-3">Exception Details:</h4>
                        <p class="lead text-dark font-weight-bold">
                            <%= (exception != null && exception.getMessage() != null) ? exception.getMessage() : "No detailed message provided by the application environment." %>
                        </p>
                        <hr>
                        <a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger mt-2">
                            Return to Employee List
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
