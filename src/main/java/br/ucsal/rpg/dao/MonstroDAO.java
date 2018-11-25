package br.ucsal.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.rpg.model.Monstro;
import br.ucsal.rpg.util.ConnectionFactory;

public class MonstroDAO {

	private Connection connection;

	public MonstroDAO() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void inserir(Monstro mostro) {
		String sql = "insert into monstro (nome, pontosDeVida, descricao) values (?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, mostro.getNome());
			stmt.setInt(2, mostro.getPontosDeVida());
			stmt.setString(3, mostro.getDescricao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Monstro getMonstro(Integer id) {
		Monstro monstro = null;
		try {
			String sql = "select * from monstro where idMonstro=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				monstro = new Monstro();
				monstro.setId(rs.getInt("idMonstro"));
				monstro.setNome(rs.getString("nome"));
				monstro.setPontosDeVida(rs.getInt("pontosDeVida"));
				monstro.setDescricao(rs.getString("descricao"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return monstro;
	}

	public List<Monstro> getLista() {
		try {
			List<Monstro> monstros = new ArrayList<>();
			String sql = "select * from monstro";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Monstro monstro = new Monstro();
				monstro.setId(rs.getInt("idMonstro"));
				monstro.setNome(rs.getString("nome"));
				monstro.setPontosDeVida(rs.getInt("pontosDeVida"));
				monstro.setDescricao(rs.getString("descricao"));
				monstros.add(monstro);
			}
			rs.close();
			stmt.close();
			return monstros;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Monstro monstro) {
		String sql = "update monstro set nome=?,pontosDeVida=?, descricao=? where idMonstro=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, monstro.getNome());
			stmt.setInt(2, monstro.getPontosDeVida());
			stmt.setString(3, monstro.getDescricao());
			stmt.setInt(4, monstro.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Integer id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from monstro where idMonstro=?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
