package br.ucsal.rpg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory connectionFactory = null;

	private static Connection connection = null;

	private String conStr = "jdbc:postgresql://localhost:6543/rpg";
	private String usuario = "postgres";
	private String senha = "postgresql";

	private ConnectionFactory() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(conStr, usuario, senha);

			/*connection.createStatement();

			connection.createStatement().execute("CREATE TABLE IF NOT EXISTS MESTRE (" + "ID SERIAL PRIMARY KEY, "
					+ "NOME VARCHAR(15), DESCRICAO VARCHAR(255));");
			connection.createStatement().execute("CREATE TABLE IF NOT EXISTS SALA (" + "ID SERIAL PRIMARY KEY, "
					+ "MESTRE INT, NOME VARCHAR(255), SENHA VARCHAR(255), DESCRICAO INT);");
			connection.createStatement().execute("CREATE TABLE IF NOT EXISTS MONSTRO (" + "ID SERIAL PRIMARY KEY, "
					+ "NOME VARCHAR(255), DANGEON INT,PONTOSDEVIDA INT, DESCRICAO VARCHAR(255));");
			connection.createStatement().execute("CREATE TABLE IF NOT EXISTS PERSONAGEM (" + "ID SERIAL PRIMARY KEY, "
					+ "NOME VARCHAR(255), RACA INT,MAIORPERSONALIDADE VARCHAR(255),PONTOSDEVIDA INT,PONTOSDEENERGIA INT,XP INT,LEVEL INT);");
			connection.createStatement().execute("CREATE TABLE IF NOT EXISTS RACA (" + "ID SERIAL PRIMARY KEY, "
					+ "NOME_ID VARCHAR(30), FORCA INT,DESTREZA INT,CONSTITUICAO INT,INTELIGENCIA INT,PERCEPICAO INT,CARISMA INT);");
			connection.createStatement().execute("CREATE TABLE IF NOT EXISTS USUARIO (" + "ID SERIAL PRIMARY KEY, "
					+ "NOME VARCHAR(30), SENHA VARCHAR(30),EMAIL VARCHAR(30));");*/

			// connection.createStatement().execute(
			// "ALTER TABLE mestre \n" + "ADD CONSTRAINT FK_mestre\n" + "FOREIGN
			// KEY (ID) REFERENCES sala(ID);");
			// connection.createStatement().execute("ALTER TABLE usuario \n" +
			// "ADD CONSTRAINT FK_usuario \n"
			// + "FOREIGN KEY (ID) REFERENCES personagem(ID);");
			// connection.createStatement().execute("ALTER TABLE personagem\n" +
			// "ADD CONSTRAINT FK_usuario \n"
			// + "FOREIGN KEY (ID) REFERENCES raca(ID);");
			// connection.createStatement().execute("ALTER TABLE sala \n" + "ADD
			// CONSTRAINT FK_usuario \n"
			// + "FOREIGN KEY (ID) REFERENCES dangeon(ID);");
			// connection.createStatement().execute("ALTER TABLE dangeon \n" +
			// "ADD CONSTRAINT FK_usuario \n"
			// + "FOREIGN KEY (ID) REFERENCES monstros(ID);");

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
