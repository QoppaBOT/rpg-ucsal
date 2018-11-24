package br.ucsal.rpg.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.rpg.dao.MonstroDAO;
import br.ucsal.rpg.model.Monstro;

/**

  */

@WebServlet("/AdicionarMonstroServlet")
public class AdicionarMonstroServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		Integer Dangeon = Integer.parseInt(request.getParameter("dangeon"));
		Integer pontosDeVida = Integer.parseInt(request.getParameter("pontosDeVida"));
		String descricao = request.getParameter("descricao");
		Monstro monstro = new Monstro();

		monstro.setId(id);
		monstro.setNome(nome);
		monstro.getDangeon().setId(Dangeon);
		monstro.setPontosDeVida(pontosDeVida);
		monstro.setDescricao(descricao);
		MonstroDAO dao = new MonstroDAO();
		dao.inserir(monstro);

		response.sendRedirect("ListarPersonagemServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdicionarPersonagemForm.jsp");
		dispatcher.forward(request, response);
	}

}
