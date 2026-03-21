package com.bikedet.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtil {
	
	private static final String URL =
	        "jdbc:mysql://localhost:3306/bike_det?useSSL=false&serverTimezone=UTC";
	    private static final String USER = "root";
	    private static final String PASSWORD = "Saikurapati";
	    public static Connection getConnection() {
	        Connection con = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(URL, USER, PASSWORD);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;
	    }
}