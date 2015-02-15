package com.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleConnection {

	Connection conn = null;

	private OracleConnection(){
		Properties property = new Properties();
		try {
			//FileInputStream istream = new FileInputStream(new File(getClass().getResourceAsStream("env.properties").));
			property.load(getClass().getResourceAsStream("env.properties"));
			Class.forName(property.getProperty("connDriver"));
			String username = property.getProperty("username");
			String password = property.getProperty("password");
			String url = property.getProperty("connURL");

			conn = DriverManager.getConnection(url,username,password);

			System.out.println("Connection Established ..!");
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException : "+e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found : "+e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL Exception : "+e.getMessage());
		} catch (Exception e) {
			System.out.println("Exception : "+e.getMessage());
		}
	}

	public static Connection getConnection(){
		return new OracleConnection().conn;
	}

	public static void main(String[] args) {
		System.out.println(OracleConnection.getConnection());
	}
}
