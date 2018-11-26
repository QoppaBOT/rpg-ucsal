package br.ucsal.rpg.usuario.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.UsuarioDAO;
import br.ucsal.rpg.model.Usuario;

@WebServlet("/AlterarUsuarioServlet")
public class AlterarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterarUsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.getUsuario(id);
		request.setAttribute("usuario", usuario);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AlterarUsuarioForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");

		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);

		UsuarioDAO dao = new UsuarioDAO();
		dao.altera(usuario);

		List<Usuario> lista = dao.getLista();
		request.setAttribute("usuario", lista);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarUsuario.jsp");
		requestDispatcher.forward(request, response);

	}

}
