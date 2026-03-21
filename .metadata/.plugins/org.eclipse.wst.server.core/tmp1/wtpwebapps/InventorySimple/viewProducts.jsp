<%@ page import="java.sql.*" %>
<%@ page import="com.inventory.util.DBConnection" %>

<html>
<head>
<title>Inventory Dashboard</title>

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
font-size:15px;
}

.sidebar a:hover{
color:#00d9ff;
}

.main{
margin-left:240px;
padding:40px;
}

.cards{
display:flex;
gap:25px;
margin-bottom:35px;
}

.card{
background:white;
padding:25px;
border-radius:10px;
width:230px;
box-shadow:0 4px 10px rgba(0,0,0,0.15);
}

.card h3{
margin:0;
color:#555;
}

.card h2{
margin-top:10px;
}

.search{
margin-bottom:20px;
}

.search input{
padding:10px;
width:300px;
border-radius:6px;
border:1px solid #ccc;
}

table{
width:100%;
border-collapse:collapse;
background:white;
border-radius:8px;
overflow:hidden;
box-shadow:0 2px 8px rgba(0,0,0,0.1);
}

th{
background:#0f1c2e;
color:white;
padding:14px;
text-align:left;
}

td{
padding:14px;
border-bottom:1px solid #eee;
}

tr:hover{
background:#f7f9fc;
}

.lowstock{
color:red;
font-weight:bold;
}

.edit{
color:#007bff;
text-decoration:none;
}

.delete{
color:red;
text-decoration:none;
}

</style>

<script>

function searchProduct(){
let input=document.getElementById("search").value.toLowerCase();
let rows=document.querySelectorAll("tbody tr");

rows.forEach(row=>{
let text=row.innerText.toLowerCase();
row.style.display=text.includes(input) ? "" : "none";
});

}

</script>

</head>

<body>

<div class="sidebar">

<h2>Dom Cricket Store</h2>

<a href="ViewProductsServlet">Dashboard</a>
<a href="addProduct.jsp">Add Product</a>
<a href="#">Logout</a>

</div>

<div class="main">

<h1>Dashboard Overview</h1>

<div class="cards">

<%

Connection conn=DBConnection.getConnection();

Statement s1=conn.createStatement();
ResultSet r1=s1.executeQuery("SELECT COUNT(*) FROM products");
r1.next();

Statement s2=conn.createStatement();
ResultSet r2=s2.executeQuery("SELECT SUM(quantity) FROM products");
r2.next();

Statement s3=conn.createStatement();
ResultSet r3=s3.executeQuery("SELECT SUM(price*quantity) FROM products");
r3.next();

%>

<div class="card">
<h3>Total Products</h3>
<h2><%=r1.getInt(1)%></h2>
</div>

<div class="card">
<h3>Total Stock</h3>
<h2><%=r2.getInt(1)%></h2>
</div>

<div class="card">
<h3>Total Inventory Value</h3>
<h2><%=r3.getDouble(1)%> Rs</h2>
</div>

</div>

<h2>Product List</h2>

<div class="search">
<input type="text" id="search" onkeyup="searchProduct()" placeholder="Search product...">
</div>

<table>

<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Quantity</th>
<th>Edit</th>
<th>Delete</th>
</tr>
</thead>

<tbody>

<%

Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery("SELECT * FROM products");

while(rs.next()){

int id=rs.getInt("id");
String name=rs.getString("name");
double price=rs.getDouble("price");
int qty=rs.getInt("quantity");

%>

<tr>

<td><%=id%></td>
<td><%=name%></td>
<td><%=price%> Rs</td>

<td>

<%
if(qty<5){
%>

<span class="lowstock">Only <%=qty%> left</span>

<%
}else{
%>

<%=qty%>

<%
}
%>

</td>

<td>
<a class="edit" href="EditProductServlet?id=<%=id%>">Edit</a>
</td>

<td>
<a class="delete" href="DeleteProductServlet?id=<%=id%>">Delete</a>
</td>

</tr>

<%
}
%>

</tbody>

</table>

</div>

</body>
</html>