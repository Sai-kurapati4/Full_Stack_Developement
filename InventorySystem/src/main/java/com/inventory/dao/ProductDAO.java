package com.inventory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.inventory.model.Product;
import com.inventory.util.DBConnection;

public class ProductDAO {

    public boolean addProduct(Product product) {

        boolean status = false;

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO products (name, category, price, quantity) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, product.getName());
            ps.setString(2, product.getCategory());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getQuantity());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }
}