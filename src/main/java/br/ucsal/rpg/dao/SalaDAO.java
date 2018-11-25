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
		String sql = "insert into sala (idMestre,idDangeon, nome,senha, descricao) values (?, ?, ?, ?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, sala.getMestre().getId());
			stmt.setInt(2, sala.getDangeon().getId());
			stmt.setString(3, sala.getNome());
			stmt.setString(4, sala.getSenha());
			stmt.setString(5, sala.getDescricao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Sala getSala(int id) {
		Sala sala = null;
		try {
			String sql = "select * from sala where idSala=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				sala = new Sala();
				sala.setId(rs.getInt("idSala"));
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
			String sql = "select * from Sala";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Sala sala = new Sala();
				sala.setId(rs.getInt("idSala"));
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
		String sql = "update sala set idMestre=?,idDangeon=?, nome=?, descricao=? where idSala=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, sala.getMestre().getId());
			stmt.setInt(2, sala.getDangeon().getId());
			stmt.setString(3, sala.getNome());
			stmt.setString(4, sala.getDescricao());
			stmt.setLong(5, sala.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from sala where idSala=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
