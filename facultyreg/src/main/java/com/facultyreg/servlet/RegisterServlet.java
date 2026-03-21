package com.facultyreg.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facultyreg.util.DBUtil;

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
    	String tts=request.getParameter("tts");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Validation
        if (name == null || name.trim().isEmpty() ||
            email == null || email.trim().isEmpty()||
tts==null || tts.trim().isEmpty()){

            out.println("<h3 style='color:red;'>All fields are required!</h3>");
            return;
        }

        try (Connection con = DBUtil.getConnection()) {

            if (con != null) {
                String sql = "INSERT INTO faculty_details (tts,name, email) VALUES (?,?, ?)";
                PreparedStatement ps = con.prepareStatement(sql);
ps.setString(1, tts);
             ps.setString(2, name);
                ps.setString(3, email);

                int rows = ps.executeUpdate();

                if (rows > 0) {
                    out.println("<h2>Registration SUCCESS!</h2>");
                    out.println("<p>tts: " + tts + "</p>");
                    out.println("<p>Name: " + name + "</p>");
                    out.println("<p>Email: " + email + "</p>");
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