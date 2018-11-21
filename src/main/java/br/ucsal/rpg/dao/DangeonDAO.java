package br.ucsal.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.rpg.model.Dangeon;
import br.ucsal.rpg.util.ConnectionFactory;

public class DangeonDAO {

	private Connection connection;

	public DangeonDAO() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void inserir(Dangeon dangeon) {
		String sql = "insert into cliente (nome, descricao) values (?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, dangeon.getNome());
			stmt.setString(2, dangeon.getDescricao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Dangeon getDangeon(Integer id) {
		Dangeon dangeon = null;
		try {
			String sql = "select * from dangeon where id_dangeon=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				dangeon = new Dangeon();
				dangeon.setId(rs.getInt("id_dangeon"));
				dangeon.setNome(rs.getString("nome"));
				dangeon.setDescricao(rs.getString("descricao"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return dangeon;
	}

	public List<Dangeon> getLista() {
		try {
			List<Dangeon> dangeons = new ArrayList<>();
			String sql = "select * from dangeon";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Dangeon dangeon = new Dangeon();
				dangeon.setId(rs.getInt("id_dangeon"));
				dangeon.setNome(rs.getString("nome"));
				dangeon.setDescricao(rs.getString("descricao"));
				dangeons.add(dangeon);
			}
			rs.close();
			stmt.close();
			return dangeons;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Dangeon daongeon) {
		String sql = "update daongeon set nome=?, descricao=? where id_dangeon=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, daongeon.getNome());
			stmt.setString(2, daongeon.getDescricao());
			stmt.setInt(3, daongeon.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from daongeon where id_dangeon=?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
