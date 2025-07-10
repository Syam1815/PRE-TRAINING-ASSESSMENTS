package com.litmus7.retail.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DBConnectionUtil {
	private static String url;
	private static String username;
	private static String password;
	private static String driverClassName;
	static {
		try (InputStream input = DBConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
			Properties props = new Properties();
			if (input == null) {
				throw new RuntimeException("Unable to find db.properties");
			}
			props.load(input);
			url = props.getProperty("jdbc.url");
			username = props.getProperty("jdbc.username");
			password = props.getProperty("jdbc.password");
			driverClassName = props.getProperty("jdbc.driverClassName");
			// Load JDBC driver
			Class.forName(driverClassName); // Optional after jdbc 4.0
		} catch (Exception e) {
			throw new RuntimeException("Failed to load DB configuration", e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
}
