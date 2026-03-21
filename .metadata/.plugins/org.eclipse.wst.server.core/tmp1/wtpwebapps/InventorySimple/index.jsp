<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    if(session.getAttribute("user") != null){
        response.sendRedirect("ViewProductsServlet");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dom Cricket Store</title>

<style>
body{
    margin:0;
    font-family:'Poppins', sans-serif;
    background:linear-gradient(135deg,#141e30,#243b55);
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
}

.card{
    background:white;
    width:400px;
    padding:50px;
    border-radius:16px;
    box-shadow:0 20px 50px rgba(0,0,0,0.4);
    text-align:center;
}

.logo{
    font-size:28px;
    font-weight:600;
    color:#243b55;
}

.subtitle{
    margin-top:5px;
    color:#777;
    margin-bottom:30px;
}

input{
    width:100%;
    padding:14px;
    margin:12px 0;
    border-radius:10px;
    border:1px solid #ddd;
    font-size:14px;
}

button{
    width:100%;
    padding:14px;
    background:#243b55;
    color:white;
    border:none;
    border-radius:10px;
    font-size:15px;
    cursor:pointer;
    transition:0.3s;
}

button:hover{
    background:#141e30;
}

.footer{
    margin-top:25px;
    font-size:12px;
    color:#aaa;
}
</style>
</head>

<body>

<div class="card">
<div class="logo">🏏 Dom Cricket Store</div>
<div class="subtitle">Inventory Management Dashboard</div>

<form action="<%= request.getContextPath() %>/LoginServlet" method="post">
<input type="text" name="username" placeholder="Username" required>
<input type="password" name="password" placeholder="Password" required>
<button type="submit">Login</button>
</form>

<div class="footer">
© 2026 Sai Ganesh
</div>
</div>

</body>
</html>