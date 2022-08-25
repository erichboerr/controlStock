package com.controlStock.controlStock.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.controlStock.controlStock.loggers.Logs;

public class ConnectionDB {
	private static Connection conn = null;
	private static String bd;
	private static String user;
	private static String pass;
	private static String url;
	private static String driver;
	private static ResourceBundle rb;

	public static Connection getConnection() {

		try {
			if (conn == null) {
				rb = ResourceBundle.getBundle("connection.jdbc");
				driver = rb.getString("driver");
				user = rb.getString("user");
				pass = rb.getString("pass");
				url = rb.getString("url");
				bd = rb.getString("bd");

				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e) {
					String error = e.getMessage();
					Logs miLogs = new Logs();
					miLogs.cargarArchivo(error);
				}
				conn = DriverManager.getConnection(url + bd, user, pass);			
			}

		} catch (SQLException e) {
			String error = e.getMessage();
			Logs miLogs = new Logs();
			miLogs.cargarArchivo(error);
		}
		return conn;
	}
}
