package br.ucsal.rpg.dangeon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.DangeonDAO;
import br.ucsal.rpg.dao.MonstroDAO;
import br.ucsal.rpg.model.Dangeon;
import br.ucsal.rpg.model.Monstro;

@WebServlet("/AlterarDangeonServlet")
public class AlterarDangeonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterarDangeonServlet() {
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
		
		MonstroDAO mdao = new MonstroDAO();
		List<Monstro> monstro = mdao.getLista();
		request.setAttribute("monstro", monstro);
		
		DangeonDAO dao = new DangeonDAO();
		Dangeon dangeon = dao.getDangeon(id);
		request.setAttribute("dangeon", dangeon);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AlterarDangeonForm.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idMonstro = request.getParameter("idMonstro");
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		Dangeon dangeon = new Dangeon();
		dangeon.setId(id);
		dangeon.setNome(nome);
		dangeon.setDescricao(descricao);

		MonstroDAO monstroDAO = new MonstroDAO();
		int idmons = Integer.parseInt(idMonstro);
		Monstro monstro = monstroDAO.getMonstro(idmons);
		dangeon.setMonstro(monstro);

		DangeonDAO dao = new DangeonDAO();
		dao.altera(dangeon);

		List<Dangeon> lista = dao.getLista();
		request.setAttribute("dangeon", lista);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ListarDangeon.jsp");
		requestDispatcher.forward(request, response);

	}

}
