package br.ucsal.rpg.sala.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.MestreDAO;
import br.ucsal.rpg.dao.SalaDAO;
import br.ucsal.rpg.model.Mestre;
import br.ucsal.rpg.model.Sala;

@WebServlet("/AlterarSalaServlet")
public class AlterarSalaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterarSalaServlet() {
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
		Sala sala = dao.getSala(id);
		request.setAttribute("sala", sala);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AlterarSalaForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String idmestre = request.getParameter("mestre");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String descricao = request.getParameter("descricao");
		Sala sala = new Sala();
		sala.setId(id);
		sala.setNome(nome);
		sala.setDescricao(descricao);
		sala.setSenha(senha);

		MestreDAO mestreDAO = new MestreDAO();
		Integer idmest = Integer.parseInt(idmestre);
		Mestre mestre = mestreDAO.getMestre(idmest);
		sala.setMestre(mestre);

		SalaDAO dao = new SalaDAO();
		dao.altera(sala);

		List<Sala> lista = dao.getLista();
		request.setAttribute("sala", lista);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarSala.jsp");
		requestDispatcher.forward(request, response);

	}

}
