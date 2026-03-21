package com.inventory.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import com.inventory.util.DBConnection;

@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
double price = Double.parseDouble(request.getParameter("price"));
int quantity = Integer.parseInt(request.getParameter("quantity"));

try{

Connection conn = DBConnection.getConnection();

PreparedStatement ps =
conn.prepareStatement(
"UPDATE products SET name=?,price=?,quantity=? WHERE id=?"
);

ps.setString(1,name);
ps.setDouble(2,price);
ps.setInt(3,quantity);
ps.setInt(4,id);

ps.executeUpdate();

response.sendRedirect("ViewProductsServlet");

}catch(Exception e){
e.printStackTrace();
}

}
}