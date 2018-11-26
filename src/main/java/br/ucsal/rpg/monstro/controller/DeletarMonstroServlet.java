package br.ucsal.rpg.monstro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.MonstroDAO;
import br.ucsal.rpg.model.Monstro;

/**
 * Servlet implementation class DeletarMestreServlet
 */
@WebServlet("/DeletarMonstroServlet")
public class DeletarMonstroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletarMonstroServlet() {
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
		MonstroDAO dao = new MonstroDAO();
		dao.remove(id);

		List<Monstro> lista = dao.getLista();
		request.setAttribute("monstro", lista);
		response.sendRedirect("ListarMonstroServlet");
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
