package com.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url="jdbc:mysql://localhost:3306/sample1";
		String user="root";
		String password="psgvicky";
				
		
		try(Connection con=DriverManager.getConnection(url,user,password))
          {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from employee1");
			DatabaseMetaData dbmd=con.getMetaData();
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getUserName());
			System.out.println(dbmd.getDatabaseProductName());
			while(rs.next())
			{
				System.out.println(rs.getInt("eid")+"|"+rs.getString("ename")+"|"+rs.getString("eaddres"));
			}
			System.out.println("end of program");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
