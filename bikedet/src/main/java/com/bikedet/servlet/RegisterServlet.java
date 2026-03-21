package com.bikedet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikedet.util.DBUtil;

/**

 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter()
                .append("Served at: ")
                .append(request.getContextPath());
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String name=request.getParameter("name");
        String cc1 = request.getParameter("cc");
        String company = request.getParameter("company");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int cc=Integer.parseInt(cc1);

        // Validation
        if (name == null || name.trim().isEmpty() ||
            cc == 0 ||
company==null || company.trim().isEmpty()){

            out.println("<h3 style='color:red;'>All fields are required!</h3>");
            return;
        }

        try (Connection con = DBUtil.getConnection()) {

            if (con != null) {
                String sql = "INSERT INTO bike_details (name,cc,company) VALUES (?,?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1, name);
             ps.setInt(2,cc);
                ps.setString(3,company);

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    out.println("<h2>Registration SUCCESS!</h2>");
                    out.println("<p>Name: " + name + "</p>");
                    out.println("<p>CC: " + cc+ "</p>");
                    out.println("<p>Company: " + company+ "</p>");
                } else {
                    out.println("<h3 style='color:red;'>Registration FAILED.</h3>");
                }
            } else {
                out.println("<h3 style='color:red;'>Database connection FAILED.</h3>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
        }
    }
}