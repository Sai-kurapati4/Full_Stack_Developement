package com.facultyreg.test;
import java.sql.Connection;
import com.facultyreg.util.DBUtil;
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