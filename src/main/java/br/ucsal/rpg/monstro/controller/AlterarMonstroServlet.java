package br.ucsal.rpg.monstro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.MonstroDAO;
import br.ucsal.rpg.model.Monstro;

@WebServlet("/AlterarMonstroServlet")
public class AlterarMonstroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterarMonstroServlet() {
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
		Monstro monstro = dao.getMonstro(id);
		request.setAttribute("monstro", monstro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AlterarMonstroForm.jsp");
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
		Integer pontosDeVida = Integer.parseInt(request.getParameter("pontosDeVida"));
		String descricao = request.getParameter("descricao");

		Monstro monstro = new Monstro();
		monstro.setId(id);
		monstro.setNome(nome);
		monstro.setPontosDeVida(pontosDeVida);
		monstro.setDescricao(descricao);

		MonstroDAO dao = new MonstroDAO();
		dao.altera(monstro);

		List<Monstro> lista = dao.getLista();
		request.setAttribute("monstro", lista);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarMonstro.jsp");
		requestDispatcher.forward(request, response);

	}

}
