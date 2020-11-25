package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static String URL = "jdbc:mysql://localhost:3307/test";
	private static String USER = "admin";
	private static String PASSWORD = "admin";

	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(URL,USER, PASSWORD);
		System.out.println("The connection is successful");
		return connection;
	}
}