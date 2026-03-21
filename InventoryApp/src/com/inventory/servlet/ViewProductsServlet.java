
package com.inventory.servlet;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.inventory.dao.ProductDAO;
import com.inventory.model.Product;
@WebServlet("/viewProducts")
public class ViewProductsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create DAO object
        ProductDAO dao = new ProductDAO();

        // Fetch products from database
        List<Product> productList = dao.getAllProducts();

        // Send list to JSP
        request.setAttribute("productList", productList);

        // Forward request to JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("viewProducts.jsp");
        dispatcher.forward(request, response);
    }
}