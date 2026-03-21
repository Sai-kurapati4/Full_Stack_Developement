package com.bikedet.test;
import java.sql.Connection;
import com.bikedet.util.DBUtil;
public class TestJDBC {
	public static void main(String[] args) {
		Connection con = DBUtil.getConnection();
        if (con != null) {
            System.out.println("JDBC Connection SUCCESS");
        } else {
            System.out.println("JDBC Connection FAILED");
        }
	}
}