package com.kshirabditanaya.empapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static Connection connection;
	public static Connection createDBConnection() throws ClassNotFoundException, SQLException
	{
		//load driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//get connection
		String url="jdbc:oracle:thin:@localhost:1521:XE";//?useSSL=false
		String userName="kshirabdi";
		String password="1234";
		connection = DriverManager.getConnection(url,userName,password);
		
		return connection;
	}
	
}
