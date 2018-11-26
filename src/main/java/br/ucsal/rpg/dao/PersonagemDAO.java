package br.ucsal.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.rpg.model.Personagem;
import br.ucsal.rpg.model.Raca;
import br.ucsal.rpg.model.Sala;
import br.ucsal.rpg.model.Usuario;
import br.ucsal.rpg.util.ConnectionFactory;

public class PersonagemDAO {

	private Connection connection;

	public PersonagemDAO() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void inserir(Personagem personagem) {
		String sql = "insert into personagem (idusuario, idraca, idsala, nome,maiorPersonalidade, pontosDeVida, pontosDeEnergia, xp, levelxp) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, personagem.getUsuario().getId());
			stmt.setInt(2, personagem.getRaca().getId());
			stmt.setInt(3, personagem.getSala().getId());
			stmt.setString(4, personagem.getNome());
			stmt.setString(5, personagem.getMaiorPersonalidade());
			stmt.setInt(6, personagem.getPontosDeVida());
			stmt.setInt(7, personagem.getPontosDeEnergia());
			stmt.setInt(8, personagem.getXP());
			stmt.setInt(9, personagem.getLevel());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Personagem getPersonagem(Integer id) {
		Personagem personagem = null;
		try {
			String sql = "select * from personagem where idPersonagem=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				personagem = new Personagem();
				personagem.setId(rs.getInt("idPersonagem"));
				personagem.getRaca().setId(rs.getInt("raca"));
				personagem.setMaiorPersonalidade(rs.getString("maiorPersonalidade"));
				personagem.setPontosDeVida(rs.getInt("pontosDeVida"));
				personagem.setPontosDeEnergia(rs.getInt("pontosDeEnergia"));
				personagem.setXP(rs.getInt("xP"));
				personagem.setLevel(rs.getInt("levelxp"));
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
				personagem.setId(rs.getInt("idPersonagem"));
				personagem.setMaiorPersonalidade(rs.getString("maiorPersonalidade"));
				personagem.setPontosDeEnergia(rs.getInt("pontosDeVida"));
				personagem.setPontosDeEnergia(rs.getInt("pontosDeEnergia"));
				personagem.setXP(rs.getInt("xP"));
				personagem.setLevel(rs.getInt("levelxp"));

				Raca raca = new Raca();
				raca.setId(rs.getInt("idraca"));
				personagem.setRaca(raca);

				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("idusuario"));
				personagem.setUsuario(usuario);

				Sala sala = new Sala();
				sala.setId(rs.getInt("idsala"));
				personagem.setSala(sala);

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
		String sql = "update personagem set idusuario=?, idraca=?, idsala=?, nome=?, raca=?, maiorPersonalidade=?, pontosDeVida=?, pontosDeEnergia=?, xP=?, levelxp=? where idPersonagem=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, personagem.getUsuario().getId());
			stmt.setInt(2, personagem.getRaca().getId());
			stmt.setInt(3, personagem.getSala().getId());
			stmt.setString(4, personagem.getNome());
			stmt.setInt(5, personagem.getRaca().getId());
			stmt.setString(6, personagem.getMaiorPersonalidade());
			stmt.setInt(7, personagem.getPontosDeVida());
			stmt.setInt(8, personagem.getPontosDeEnergia());
			stmt.setInt(9, personagem.getXP());
			stmt.setInt(10, personagem.getLevel());
			stmt.setInt(11, personagem.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Integer id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from personagem where idPersonagem=?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
