<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Confirmation</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f6f8;
    }

    .container {
        width: 400px;
        margin: 80px auto;
        padding: 25px;
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0px 4px 12px rgba(0,0,0,0.1);
        text-align: center;
    }

    .success {
        color: #28a745;
        font-size: 20px;
        font-weight: bold;
        margin-bottom: 15px;
    }

    .details {
        color: #333;
        font-size: 16px;
        margin: 10px 0;
    }

    .id {
        font-weight: bold;
        color: #007bff;
    }

    .btn {
        display: inline-block;
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #007bff;
        color: #fff;
        text-decoration: none;
        border-radius: 5px;
    }

    .btn:hover {
        background-color: #0056b3;
    }
</style>

</head>

<body>

<div class="container">

    <div class="success">
        ✅ Product Uploaded Successfully!
    </div>

    <div class="details">
        Product ID: <span class="id">${response.productId}</span>
    </div>

    <div class="details">
        ${response.confirmationMSG}
    </div>

    <a href="index.jsp" class="btn">Upload Another Product</a>

</div>

</body>
</html>