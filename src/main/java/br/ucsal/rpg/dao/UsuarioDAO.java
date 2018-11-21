package br.ucsal.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.rpg.model.Usuario;
import br.ucsal.rpg.util.ConnectionFactory;

public class UsuarioDAO {

	private Connection connection;

	public UsuarioDAO() {
		this.connection = ConnectionFactory.getConnection();
	}

	public void inserir(Usuario usuario) {
		String sql = "insert into mestre (nome, senha,email) values (?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmail());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Usuario getUsuario(Long id) {
		Usuario usuario = null;
		try {
			String sql = "select * from usuario where id_Usuario=?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id_Usuario"));
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usuario;
	}

	public List<Usuario> getLista() {
		try {
			List<Usuario> usuarios = new ArrayList<>();
			String sql = "select * from usuario";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id_Usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));

				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void altera(Usuario usuario) {
		String sql = "update usuario set nome=?, senha=?,email=? where id_Usuario=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, usuario.getEmail());
			stmt.setLong(4, usuario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Integer id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from usuario where id_Usuario=?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
