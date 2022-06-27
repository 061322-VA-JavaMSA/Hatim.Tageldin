
package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	private static Connection c;
	
	public static Connection getConnectionFromFile() throws SQLException {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			prop.load(loader.getResourceAsStream("connection.properties"));
		} catch (IOException e) {
			System.out.println("Unable to establish connection.");
		}
		
		String url = prop.getProperty("jdbc:postgresql://jdbc:postgresql://database-1.csu7osxc7lja.us-west-2.rds.amazonaws.com:5432/postgres");
		String username = prop.getProperty("htagel413");
		String password = prop.getProperty("H-moroco2");
		
		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
		}
		return c;
	}
}
	
//	public static Connection getConnectionFromEnv() throws SQLException {
//		String url = System.getenv("jdbc:postgresql://jdbc:postgresql://database-1.csu7osxc7lja.us-west-2.rds.amazonaws.com:5432/postgres");
//		String username = System.getenv("Htagel413");
//		String password = System.getenv("H-moroco2");
//		
//		if (c == null || c.isClosed()) {
//			c = DriverManager.getConnection(url, username, password);
//		}
//		return c;
//	}
//}
