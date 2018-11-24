package br.ucsal.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.rpg.model.Mestre;
import br.ucsal.rpg.util.ConnectionFactory;

public class MestreDAO {

	private Connection connection;

	public MestreDAO() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void inserir(Mestre mestre) {
		String sql = "insert into mestre (nome, descricao) values (?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, mestre.getNome());
			stmt.setString(2, mestre.getDescricao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Mestre getMestre(Integer id) {
		Mestre mestre = null;
		try {
			String sql = "select * from mestre where idMestre=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				mestre = new Mestre();
				mestre.setId(rs.getInt("idMestre"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return mestre;
	}

	public List<Mestre> getLista() {
		try {
			List<Mestre> mestres = new ArrayList<>();
			String sql = "select * from mestre";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Mestre mestre = new Mestre();
				mestre.setId(rs.getInt("idMestre"));
				mestre.setNome(rs.getString("nome"));
				mestre.setDescricao(rs.getString("descricao"));
				mestres.add(mestre);
			}
			rs.close();
			stmt.close();
			return mestres;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Mestre mestre) {
		String sql = "update mestre set nome=?, descricao=? where idMestre=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, mestre.getNome());
			stmt.setString(2, mestre.getDescricao());
			stmt.setInt(3, mestre.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Integer id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from mestre where idMestre=?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
