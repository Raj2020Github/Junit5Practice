package com.giffgaff.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection { // This method will create connection to database
	public static Connection conn = null;

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;

	}

	public static void closeConnection() { // This method will close connection to database
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
