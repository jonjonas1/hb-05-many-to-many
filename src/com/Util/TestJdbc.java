package com.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String pass = "admin";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			@SuppressWarnings("unused")
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
						
			System.out.println("Connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}