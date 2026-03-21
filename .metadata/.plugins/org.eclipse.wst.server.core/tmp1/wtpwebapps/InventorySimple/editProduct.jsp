<html>
<head>
<title>Edit Product</title>

<style>

body{
margin:0;
font-family:Segoe UI;
background:#f1f3f6;
}

.sidebar{
width:220px;
height:100vh;
background:#0f1c2e;
color:white;
position:fixed;
padding:20px;
}

.sidebar h2{
margin-bottom:40px;
}

.sidebar a{
display:block;
color:white;
text-decoration:none;
margin:18px 0;
}

.main{
margin-left:240px;
padding:40px;
}

.formbox{
background:white;
padding:30px;
width:400px;
border-radius:10px;
box-shadow:0 3px 10px rgba(0,0,0,0.2);
}

input{
width:100%;
padding:10px;
margin:10px 0;
border-radius:6px;
border:1px solid #ccc;
}

button{
padding:10px 20px;
background:#0f1c2e;
color:white;
border:none;
border-radius:6px;
cursor:pointer;
}

button:hover{
background:#1c2f4a;
}

</style>

</head>

<body>

<div class="sidebar">

<h2>Store Admin</h2>

<a href="ViewProductsServlet">Dashboard</a>
<a href="addProduct.jsp">Add Product</a>
<a href="#">Logout</a>

</div>

<div class="main">

<h1>Edit Product</h1>

<div class="formbox">

<form action="UpdateProductServlet" method="post">

<input type="hidden" name="id"
value="<%= request.getAttribute("id") %>">

<label>Product Name</label>
<input type="text" name="name"
value="<%= request.getAttribute("name") %>">

<label>Price</label>
<input type="text" name="price"
value="<%= request.getAttribute("price") %>">

<label>Quantity</label>
<input type="text" name="quantity"
value="<%= request.getAttribute("quantity") %>">

<br>

<button type="submit">Update Product</button>

</form>

</div>

</div>

</body>
</html>