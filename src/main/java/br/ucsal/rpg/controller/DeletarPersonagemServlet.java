package br.ucsal.rpg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.PersonagemDAO;
import br.ucsal.rpg.model.Personagem;

/**
 * Servlet implementation class DeletarMestreServlet
 */
@WebServlet("/DeletarPersonagemServlet")
public class DeletarPersonagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletarPersonagemServlet() {
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
		PersonagemDAO dao = new PersonagemDAO();
		dao.remove(id);

		List<Personagem> lista = dao.getLista();
		request.setAttribute("personagem", lista);
		response.sendRedirect("ListarPersonagemServlet");
		// RequestDispatcher requestDispatcher =
		// request.getRequestDispatcher("ListarClientes.jsp");
		// requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
