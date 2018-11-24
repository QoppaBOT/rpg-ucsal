package br.ucsal.rpg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory connectionFactory = null;

	private static Connection connection = null;

	private String conStr = "jdbc:postgresql://localhost:5432/rpg";
	private String usuario = "postgres";
	private String senha = "postgresql";

	private ConnectionFactory() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(conStr, usuario, senha);
	


		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

	public static Connection getConnection() {
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactory();
		}
		return connection;
	}

}
