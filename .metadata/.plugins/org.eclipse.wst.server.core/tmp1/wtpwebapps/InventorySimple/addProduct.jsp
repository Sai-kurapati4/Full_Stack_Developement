<%@ page session="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(session.getAttribute("user") == null){
        response.sendRedirect("index.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

<style>
body{margin:0;font-family:Poppins;background:#f3f4f6;}

.sidebar{
    width:240px;
    height:100vh;
    background:#111827;
    color:white;
    position:fixed;
    padding-top:30px;
}
.sidebar h2{text-align:center;margin-bottom:40px;}
.sidebar a{
    display:block;
    color:#cbd5e1;
    padding:15px 30px;
    text-decoration:none;
}
.sidebar a:hover{
    background:#1f2937;
    color:white;
}

.content{
    margin-left:240px;
    padding:50px;
}

.card{
    background:white;
    padding:40px;
    width:450px;
    border-radius:14px;
    box-shadow:0 10px 30px rgba(0,0,0,0.08);
}

h2{margin-top:0;}

input{
    width:100%;
    padding:14px;
    margin:12px 0;
    border-radius:10px;
    border:1px solid #ccc;
}

button{
    width:100%;
    padding:14px;
    background:#111827;
    color:white;
    border:none;
    border-radius:10px;
    font-size:14px;
    cursor:pointer;
}

button:hover{
    background:#1f2937;
}

.back{
    display:inline-block;
    margin-bottom:20px;
    text-decoration:none;
    color:#2563eb;
}
</style>
</head>

<body>

<div class="sidebar">
<h2>Cricket Stall</h2>
<a href="ViewProductsServlet">Dashboard</a>
<a href="addProduct.jsp">Add Product</a>
<a href="LogoutServlet">Logout</a>
</div>

<div class="content">

<a class="back" href="ViewProductsServlet">← Back to Dashboard</a>

<div class="card">
<h2>Add Product</h2>

<form action="AddProductServlet" method="post">
<input type="text" name="name" placeholder="Product Name" required minlength="2">
<input type="number" step="1" name="price" placeholder="Price" required min="1" step="1">
<input type="number" name="quantity" placeholder="Quantity" required min="0">
<button type="submit">Save Product</button>
</form>

</div>
</div>

</body>
</html>