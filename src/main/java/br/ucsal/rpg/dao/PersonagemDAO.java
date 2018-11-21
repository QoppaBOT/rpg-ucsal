package br.ucsal.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.rpg.model.Personagem;
import br.ucsal.rpg.util.ConnectionFactory;

public class PersonagemDAO {

	private Connection connection;

	public PersonagemDAO() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void inserir(Personagem personagem) {
		String sql = "insert into personagem (nome, Raca, maiorPersonalidade, pontosDeVida, pontosDeEnergia, XP, level) values (?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, personagem.getNome());
			stmt.setInt(2, personagem.getRaca().getId());
			stmt.setString(3, personagem.getMaiorPersonalidade());
			stmt.setLong(4, personagem.getPontosDeVida());
			stmt.setLong(5, personagem.getPontosDeEnergia());
			stmt.setInt(6, personagem.getXP());
			stmt.setInt(7, personagem.getLevel());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Personagem getPersonagem(Long id) {
		Personagem personagem = null;
		try {
			String sql = "select * from personagem where id_Personagem=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				personagem = new Personagem();
				personagem.setId(rs.getInt("id_Personagem"));
				personagem.getRaca().setId(rs.getInt("raca"));
				personagem.setMaiorPersonalidade(rs.getString("maiorPersonalidade"));
				personagem.setPontosDeVida(rs.getInt("pontosDeVida"));
				personagem.setPontosDeEnergia(rs.getInt("pontosDeEnergia"));
				personagem.setXP(rs.getInt("xP"));
				personagem.setLevel(rs.getInt("level"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return personagem;
	}

	public List<Personagem> getLista() {
		try {
			List<Personagem> personagems = new ArrayList<>();
			String sql = "select * from personagem";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Personagem personagem = new Personagem();
				personagem.setId(rs.getInt("id_Personagem"));
				personagem.setNome(rs.getString("raca"));
				personagem.setMaiorPersonalidade(rs.getString("maiorPersonalidade"));
				personagem.setPontosDeEnergia(rs.getInt("pontosDeVida"));
				personagem.setPontosDeEnergia(rs.getInt("pontosDeEnergia"));
				personagem.setXP(rs.getInt("xP"));
				personagem.setLevel(rs.getInt("level"));
				personagems.add(personagem);
			}
			rs.close();
			stmt.close();
			return personagems;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Personagem personagem) {
		String sql = "update personagem set nome=?, raca=?, maiorPersonalidade=?, pontosDeVida=?, pontosDeEnergia=?, xP=?, level=? where id_Personagem=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, personagem.getNome());
			stmt.setInt(2, personagem.getRaca().getId());
			stmt.setString(3, personagem.getMaiorPersonalidade());
			stmt.setInt(4, personagem.getPontosDeVida());
			stmt.setInt(5, personagem.getPontosDeEnergia());
			stmt.setInt(6, personagem.getXP());
			stmt.setInt(7, personagem.getLevel());
			stmt.setInt(8, personagem.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Integer id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from personagem where id_Personagem=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
