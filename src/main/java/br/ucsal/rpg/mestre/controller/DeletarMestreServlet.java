package br.ucsal.rpg.mestre.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.MestreDAO;
import br.ucsal.rpg.model.Mestre;

/**
 * Servlet implementation class DeletarMestreServlet
 */
@WebServlet("/DeletarMestreServlet")
public class DeletarMestreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletarMestreServlet() {
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
		MestreDAO dao = new MestreDAO();
		dao.remove(id);

		List<Mestre> lista = dao.getLista();
		request.setAttribute("mestre", lista);
		response.sendRedirect("ListarMestreServlet");
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
