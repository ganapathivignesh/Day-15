package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Rollback {

	private static String INSERT = "INSERT INTO test.department (idDepartment, name) VALUES (?, ?)";

	public static void insertRow(Connection conn, int idRow, String contentRow)
			throws SQLException {
		PreparedStatement ps = null;
		ps = conn.prepareStatement(INSERT);
		ps.setInt(1, idRow);
		ps.setString(2, contentRow);
		ps.execute();
		ps.close();
	}

	public static void main(String[] args) {
		Connection connection = null;
		try {
		
			connection = DBConnection.getConnection();
		} catch (SQLException e) {
			System.out.println("error getting the connection");
		}
		try {
			// Disable the auto commit
			connection.setAutoCommit(false);
			System.out.println("The autocommit");
		} catch (SQLException e) {
			System.out.println("error disabling autocommit");
		}
	
		try {
			
			insertRow(connection, 1, "Barcelona");
			insertRow(connection, 2, "Malaga");
	
			connection.commit();
			System.out.println("The transaction was successful");
		} catch (SQLException e) {
			try {
				//rollback the transaction 
			
				connection.rollback();
				System.out.println(e.getMessage());
				System.out.println("rollback");
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
				System.out.println(" error making a rollback");
			}
		}
	}

}