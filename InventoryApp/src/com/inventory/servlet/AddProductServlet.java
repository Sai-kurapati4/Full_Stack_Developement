package com.inventory.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inventory.dao.ProductDAO;
import com.inventory.model.Product;

public class AddProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String category = request.getParameter("category");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Product product = new Product(name, category, price, quantity);

        ProductDAO dao = new ProductDAO();
        boolean status = dao.addProduct(product);

        if (status) {
            response.getWriter().println("Product Added Successfully!");
        } else {
            response.getWriter().println("Failed to Add Product!");
        }
    }
}