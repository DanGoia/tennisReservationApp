package org.fasttrackit.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelpers {
	public Connection getConnection() throws ClassNotFoundException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis_app?user=root&password=dangoia");
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return null;
	}

	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}