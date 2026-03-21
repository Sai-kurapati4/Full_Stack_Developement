<%@ page import="java.sql.*" %>
<%@ page import="com.inventory.util.DBConnection" %>

<html>
<head>
<title>Products</title>
</head>

<body>

<h2>Product List</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Quantity</th>
<th>Edit</th>
</tr>

<%

Connection conn = DBConnection.getConnection();
Statement stmt = conn.createStatement();

ResultSet rs = stmt.executeQuery("SELECT * FROM products");

while(rs.next()){

int id = rs.getInt("id");
String name = rs.getString("name");
double price = rs.getDouble("price");
int qty = rs.getInt("quantity");

%>

<tr>

<td><%= id %></td>

<td><%= name %></td>

<td><%= price %></td>

<td>

<%
if(qty < 5){
%>

<span style="color:red;font-weight:bold;">
Only <%= qty %> left
</span>

<%
}else{
%>

<%= qty %>

<%
}
%>

</td>

<td>

<a href="EditProductServlet?id=<%= id %>">Edit</a>

</td>

</tr>

<%
}
%>

</table>

</body>
</html>