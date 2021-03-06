package br.ucsal.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.rpg.model.Dangeon;
import br.ucsal.rpg.model.Monstro;
import br.ucsal.rpg.util.ConnectionFactory;

public class DangeonDAO {

	private Connection connection;

	public DangeonDAO() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void inserir(Dangeon dangeon) {
		String sql = "insert into Dangeon (idMonstro, nome, descricao) values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, dangeon.getMonstro().getId());
			stmt.setString(2, dangeon.getNome());
			stmt.setString(3, dangeon.getDescricao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Dangeon getDangeon(Integer id) {
		Dangeon dangeon = null;
		try {
			String sql = "select * from dangeon where iddangeon=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				dangeon = new Dangeon();
				dangeon.setId(rs.getInt("iddangeon"));
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
				dangeon.setId(rs.getInt("iddangeon"));
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

	public List<Dangeon> getListaInner() {
		try {
			List<Dangeon> dangeons = new ArrayList<>();
			String sql = "SELECT dangeon.nome, monstro.nome\r\n" + "FROM dangeon\r\n"
					+ "INNER JOIN monstro ON dangeon.iddangeon = monstro.idmonstro;";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Dangeon dangeon = new Dangeon();
				dangeon.setNome(rs.getString("nome"));

				Monstro monstro = new Monstro();
				monstro.setNome(rs.getString("nome"));
				dangeon.setMonstro(monstro);

				dangeons.add(dangeon);
			}
			rs.close();
			stmt.close();
			return dangeons;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Dangeon dangeon) {
		String sql = "update dangeon set idMonstro=?, nome=?, descricao=? where iddangeon=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, dangeon.getMonstro().getId());
			stmt.setString(2, dangeon.getNome());
			stmt.setString(3, dangeon.getDescricao());
			stmt.setInt(4, dangeon.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from dangeon where iddangeon=?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
