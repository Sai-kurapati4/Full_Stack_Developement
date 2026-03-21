<html>
<head>
<title>Edit Product</title>
</head>

<body>

<h2>Edit Product</h2>

<form action="UpdateProductServlet" method="post">

<input type="hidden" name="id"
value="<%= request.getAttribute("id") %>">

Name:
<input type="text" name="name"
value="<%= request.getAttribute("name") %>">

<br><br>

Price:
<input type="text" name="price"
value="<%= request.getAttribute("price") %>">

<br><br>

Quantity:
<input type="text" name="quantity"
value="<%= request.getAttribute("quantity") %>">

<br><br>

<input type="submit" value="Update Product">

</form>

</body>
</html>