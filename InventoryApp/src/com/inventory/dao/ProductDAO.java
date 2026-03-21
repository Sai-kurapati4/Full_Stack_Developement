package com.inventory.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.inventory.model.Product;
import com.inventory.util.DBConnection;
import com.inventory.model.Product;
public class ProductDAO {
	public Product getProductById(int id) {

	    Product product = null;

	    try {
	        Connection con = DBConnection.getConnection();

	        PreparedStatement ps = con.prepareStatement(
	                "SELECT * FROM products WHERE id=?");

	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            product = new Product();
	            product.setId(rs.getInt("id"));
	            product.setName(rs.getString("name"));
	            product.setPrice(rs.getDouble("price"));
	            product.setQuantity(rs.getInt("quantity"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return product;
	}
// DELETE PRODUCT
	public boolean deleteProduct(int id) {

	    boolean status = false;

	    try {
	        Connection con = DBConnection.getConnection();

	        String query = "DELETE FROM products WHERE product_id = ?";
	        PreparedStatement ps = con.prepareStatement(query);

	        ps.setInt(1, id);

	        int rows = ps.executeUpdate();

	        if (rows > 0) {
	            status = true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
    // ADD PRODUCT
	public boolean addProduct(Product product) {

	    boolean status = false;

	    try {
	        Connection con = DBConnection.getConnection();

	        String query = "INSERT INTO products (name, category, price, quantity) VALUES (?, ?, ?, ?)";
	        PreparedStatement ps = con.prepareStatement(query);

	        ps.setString(1, product.getName());
	        ps.setString(2, product.getCategory());
	        ps.setDouble(3, product.getPrice());
	        ps.setInt(4, product.getQuantity());

	        int rows = ps.executeUpdate();

	        System.out.println("Rows inserted: " + rows);

	        if (rows > 0) {
	            status = true;
	        }

	    } catch (Exception e) {
	        System.out.println("ERROR OCCURRED:");
	        e.printStackTrace();
	    }

	    return status;
	}
    // GET ALL PRODUCTS
    public List<Product> getAllProducts() {

        List<Product> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM products";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("Product Found!");

                Product p = new Product();

                p.setProductId(rs.getInt("product_id"));
                p.setName(rs.getString("name"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));

                list.add(p);
            }System.out.println("Total products fetched: " + list.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}