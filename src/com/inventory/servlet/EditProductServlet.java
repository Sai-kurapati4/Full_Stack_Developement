package com.inventory.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import com.inventory.util.DBConnection;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

int id = Integer.parseInt(request.getParameter("id"));

try{

Connection conn = DBConnection.getConnection();

PreparedStatement ps =
conn.prepareStatement("SELECT * FROM products WHERE id=?");

ps.setInt(1,id);

ResultSet rs = ps.executeQuery();

if(rs.next()){

request.setAttribute("id", rs.getInt("id"));
request.setAttribute("name", rs.getString("name"));
request.setAttribute("price", rs.getDouble("price"));
request.setAttribute("quantity", rs.getInt("quantity"));

}

RequestDispatcher rd = request.getRequestDispatcher("editProduct.jsp");
rd.forward(request,response);

}catch(Exception e){
e.printStackTrace();
}

}
}