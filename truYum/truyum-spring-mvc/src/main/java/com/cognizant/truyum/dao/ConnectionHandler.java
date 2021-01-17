package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionHandler {

	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		FileInputStream fileInputStream = new FileInputStream("..\\truYum\\src\\connection.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		Class.forName(properties.getProperty("driver"));
		Connection con = DriverManager.getConnection(properties.getProperty("connection-url"),
				properties.getProperty("user"), properties.getProperty("password"));
		return con;
	}

}
