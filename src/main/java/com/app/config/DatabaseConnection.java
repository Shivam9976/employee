package com.app.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

 public static Connection connetion() throws SQLException, ClassNotFoundException {
	 
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Shivam@123");
	return conn;
	 
 }
}
