package com.jdbc;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Studentdata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		
		int select;
		do
		{
			
			System.out.println("1.add ");
			System.out.println("2.remove");
			System.out.println("3.update");
			System.out.println("4.display");
			System.out.println("5.logout");
		    
		    System.out.println("chose from following operation");
		    select=sc.nextInt();
		
		
		String url="jdbc:mysql://localhost:3306/sample1";
		String user="root";
		String password="psgvicky";
		
		
		switch(select)
		{
		case 1:
		{
			System.out.println("enter student details");
			int sid=sc.nextInt();
			String sname=sc.next();
			int smobno=sc.nextInt();
			String scity=sc.next();
			try(Connection con=DriverManager.getConnection(url,user,password))
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Statement st=con.createStatement();
				
				int i=st.executeUpdate("insert into student values("+sid+",'"+sname+"',"+smobno+",'"+scity+"')");
				
				if(i>0)
				{
					System.out.println("values got inserted");
				}
				else
				{
					System.out.println("values does not insert");
				}
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
		}	
		case 2:
		{
			
			
			System.out.println("enter student name which u want to delete");
			String delname=sc.next();
			
	        try (Connection con = DriverManager.getConnection(url, user, password);
	                Statement st = con.createStatement()) {
	               st.executeUpdate("DELETE FROM student WHERE sname='"+delname+"'");
	               System.out.println("Record deleted successfully.");
	           } 
	           catch (Exception e) {
	               e.printStackTrace();
	           }
		};

		case 3:
		{
			System.out.println("enter student name which u want to update");
			String upname=sc.next();
			System.out.println("enter studentid which u want to update");
			int upid=sc.nextInt();
			
			
	        try (Connection connection = DriverManager.getConnection(url, user, password);
	                Statement st = connection.createStatement()) {
	             
	               st.executeUpdate("Update student SET sname='"+upname+"' where id="+upid+"");
	           }
	           catch (Exception e) {
	               e.printStackTrace();
	           }
		};
			
		case 4:
		{

	        try (Connection connection = DriverManager.getConnection(url, user, password);
	                Statement st = connection.createStatement()) {
	             
	               st.executeUpdate("select * from student");
	           }
	           catch (Exception e) {
	               e.printStackTrace();
	           }
			
		};
			
			
		case 5:
			break;
	      
		}
		
		
			
		}while(select!=5);

	
		
			
	}
}
		


