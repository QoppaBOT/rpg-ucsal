package br.ucsal.rpg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.SalaDAO;
import br.ucsal.rpg.model.Sala;

/**
 * Servlet implementation class DeletarMestreServlet
 */
@WebServlet("/DeletarSalaServlet")
public class DeletarSalaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletarSalaServlet() {
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
		SalaDAO dao = new SalaDAO();
		dao.remove(id);

		List<Sala> lista = dao.getLista();
		request.setAttribute("sala", lista);
		response.sendRedirect("ListarSalaServlet");
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
