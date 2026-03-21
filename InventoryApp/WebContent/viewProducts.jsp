<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Products</title>
</head>
<body>

<h2>Product List</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>

<c:forEach var="product" items="${productList}">
    <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>${product.quantity}</td>

        <td>
            <a href="deleteProduct?id=${product.id}">Delete</a>
        </td>

        <td>
            <a href="editProduct?id=${product.id}">Edit</a>
        </td>
    </tr>
</c:forEach>

</table>

<br>
<a href="index.html">Back to Home</a>

</body>
</html>