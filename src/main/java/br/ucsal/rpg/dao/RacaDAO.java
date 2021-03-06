package br.ucsal.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.rpg.model.Raca;
import br.ucsal.rpg.util.ConnectionFactory;

public class RacaDAO {

	private Connection connection;

	public RacaDAO() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void inserir(Raca raca) {
		String sql = "insert into raca (nome, forca, destreza, constituicao, inteligencia, percepicao, carisma) values (?,?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, raca.getNome());
			stmt.setInt(2, raca.getForca());
			stmt.setInt(3, raca.getDestreza());
			stmt.setInt(4, raca.getContituicao());
			stmt.setInt(5, raca.getInteligencia());
			stmt.setInt(6, raca.getPercepicao());
			stmt.setInt(7, raca.getCarisma());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Raca getRaca(int id) {
		Raca raca = null;
		try {
			String sql = "select * from raca where idRaca=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				raca = new Raca();
				raca.setNome(rs.getString("nome"));
				raca.setId(rs.getInt("idRaca"));
				raca.setForca(rs.getInt("forca"));
				raca.setDestreza(rs.getInt("destreza"));
				raca.setContituicao(rs.getInt("constituicao"));
				raca.setInteligencia(rs.getInt("inteligencia"));
				raca.setPercepicao(rs.getInt("percepicao"));
				raca.setCarisma(rs.getInt("carisma"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return raca;
	}

	public List<Raca> getLista() {
		try {
			List<Raca> racas = new ArrayList<>();
			String sql = "select * from raca";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Raca raca = new Raca();
				raca.setNome(rs.getString("nome"));
				raca.setId(rs.getInt("idRaca"));
				raca.setForca(rs.getInt("forca"));
				raca.setDestreza(rs.getInt("destreza"));
				raca.setContituicao(rs.getInt("constituicao"));
				raca.setInteligencia(rs.getInt("inteligencia"));
				raca.setPercepicao(rs.getInt("percepicao"));
				raca.setCarisma(rs.getInt("carisma"));
				racas.add(raca);
			}
			rs.close();
			stmt.close();
			return racas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Raca raca) {
		String sql = "update raca set nome=?, forca=?, destreza=?, constituicao=?, inteligencia=?, percepicao=?, carisma=? where idRaca=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, raca.getNome());
			stmt.setInt(2, raca.getForca());
			stmt.setInt(3, raca.getDestreza());
			stmt.setInt(4, raca.getContituicao());
			stmt.setInt(5, raca.getInteligencia());
			stmt.setInt(6, raca.getPercepicao());
			stmt.setInt(7, raca.getCarisma());
			stmt.setInt(8, raca.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(int id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from raca where idRaca=?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
