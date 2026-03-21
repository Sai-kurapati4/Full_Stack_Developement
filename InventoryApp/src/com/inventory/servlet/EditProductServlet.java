package com.inventory.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.inventory.dao.ProductDAO;
import com.inventory.model.Product;
@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ProductDAO dao = new ProductDAO();
        Product product = dao.getProductById(id);

        request.setAttribute("product", product);
        request.getRequestDispatcher("editProduct.jsp").forward(request, response);
    }
}