package com.inventory.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.inventory.dao.ProductDAO;

public class DeleteProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get ID from URL
        int id = Integer.parseInt(request.getParameter("id"));

        // Call DAO
        ProductDAO dao = new ProductDAO();
        dao.deleteProduct(id);

        // Redirect back to viewProducts
        response.sendRedirect("viewProducts");
    }
}