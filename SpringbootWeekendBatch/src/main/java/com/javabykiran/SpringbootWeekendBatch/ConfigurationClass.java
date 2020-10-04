package com.javabykiran.SpringbootWeekendBatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationClass {

	private static Connection conn=null;
	
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		if(conn==null)
		{
			System.out.println("connection");
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3309/student_demo", "root", "root");
			System.out.println("done!!");
		}
		
		return conn;
	}
	
	
}
