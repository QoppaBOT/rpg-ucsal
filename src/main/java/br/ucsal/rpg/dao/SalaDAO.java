package br.ucsal.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.rpg.model.Sala;
import br.ucsal.rpg.util.ConnectionFactory;

public class SalaDAO {

	private Connection connection;

	public SalaDAO() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void inserir(Sala sala) {
		String sql = "insert into sala (mestre, nome, descricao, montros) values (?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, sala.getMestre().getId());
			stmt.setString(2, sala.getNome());
			stmt.setString(3, sala.getDescricao());
			stmt.setInt(4, sala.getMonstro().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Sala getSala(int id) {
		Sala sala = null;
		try {
			String sql = "select * from sala where id_Sala=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				sala = new Sala();
				sala.setId(rs.getInt("id_Sala"));
				sala.setNome(rs.getString("nome"));
				sala.setDescricao(rs.getString("descricao"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return sala;
	}

	public List<Sala> getLista() {
		try {
			List<Sala> salas = new ArrayList<>();
			String sql = "select * from cliente";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Sala sala = new Sala();
				sala.setId(rs.getInt("id_Sala"));
				sala.setNome(rs.getString("nome"));
				sala.setDescricao(rs.getString("descricao"));
				salas.add(sala);
			}
			rs.close();
			stmt.close();
			return salas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Sala sala) {
		String sql = "update sala set nome=?, descricao=? where id_Sala=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, sala.getNome());
			stmt.setString(2, sala.getDescricao());
			stmt.setLong(3, sala.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from sala where id_Sala=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
