<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Bike Details</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: linear-gradient(135deg, #43cea2, #185a9d);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .card {
        background: white;
        padding: 30px 40px;
        width: 350px;
        border-radius: 10px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.3);
        text-align: center;
    }

    h2 {
        color: #2e7d32;
        margin-bottom: 20px;
    }

    .error {
        color: #d32f2f;
        font-size: 16px;
        margin-bottom: 10px;
    }

    p {
        font-size: 15px;
        color: #444;
        margin: 6px 0;
    }

    a {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        background: #185a9d;
        color: white;
        padding: 10px 18px;
        border-radius: 5px;
    }

    a:hover {
        background: #0f3c6e;
    }
</style>

</head>
<body>

<div class="card">

<% if (request.getAttribute("success") != null) { %>

    <h2><%= request.getAttribute("success") %></h2>
    <p><b>Name:</b> <%= request.getAttribute("name") %></p>
    <p><b>CC:</b> <%= request.getAttribute("cc") %></p>
    <p><b>Company:</b> <%= request.getAttribute("company") %></p>

<% } else { %>

    <div class="error">
        <%= request.getAttribute("error") %>
    </div>

<% } %>

<a href="index.html">Go Back</a>

</div>

</body>
</html>
