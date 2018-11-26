package br.ucsal.rpg.mestre.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.MestreDAO;
import br.ucsal.rpg.model.Mestre;

@WebServlet("/AlterarMestreServlet")
public class AlterarMestreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterarMestreServlet() {
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
		Mestre mestre = dao.getMestre(id);
		request.setAttribute("mestre", mestre);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AlterarMestreForm.jsp");
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
		String descricao = request.getParameter("descricao");

		Mestre mestre = new Mestre();
		mestre.setId(id);
		mestre.setNome(nome);
		mestre.setDescricao(descricao);

		MestreDAO dao = new MestreDAO();
		dao.altera(mestre);

		List<Mestre> lista = dao.getLista();
		request.setAttribute("mestre", lista);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarMestre.jsp");
		requestDispatcher.forward(request, response);

	}

}
