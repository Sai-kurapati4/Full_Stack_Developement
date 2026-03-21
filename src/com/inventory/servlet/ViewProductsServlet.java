package com.inventory.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import com.inventory.util.DBConnection;

@WebServlet("/ViewProductsServlet")
public class ViewProductsServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

try{

Connection conn = DBConnection.getConnection();
Statement stmt = conn.createStatement();

ResultSet rs = stmt.executeQuery("SELECT * FROM products");

request.setAttribute("products", rs);

RequestDispatcher rd = request.getRequestDispatcher("viewProducts.jsp");
rd.forward(request,response);

}catch(Exception e){
e.printStackTrace();
}

}
}